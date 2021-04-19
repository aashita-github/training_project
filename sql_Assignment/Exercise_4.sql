--Connecting To DataBase

Use AdventureWorks2008R2;

--Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows for that Sales Order including Quantity, ProductID, UnitPrice, 
--and the unit price converted to the target currency based on the end of day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. ( Use AdventureWorks)


Go
Create or Alter Function Sales.GetProductDetails(@SalesOrderID int,@CurrencyCode nchar(5),@CurrencyRateDate datetime)
returns @product Table(
ProductID int,
Quantity int,
UnitPrice money)

As Begin
    Declare @Quantity int
	Declare @ProductID int
	Declare @UnitPrice money
    Set @Quantity=(Select OrderQty From Sales.SalesOrderDetail Where SalesOrderDetailID=@SalesOrderID)
	Set @ProductID=(Select ProductID From Sales.SalesOrderDetail Where SalesOrderDetailID=@SalesOrderID)
	Set @UnitPrice=(Select p.UnitPrice*scr.EndOfDayRate FROM Sales.SalesOrderDetail AS p, Sales.CurrencyRate AS scr WHERE scr.ToCurrencyCode = @CurrencyCode AND scr.CurrencyRateDate = @CurrencyRateDate and SalesOrderDetailID=@SalesOrderID)

	Insert into @product values(@ProductID,@Quantity,@UnitPrice)
	Return 
	End;
go
--select * from Sales.GetProductDetails(8367,'USD','2005-07-01 00:00:00.000');

