--Connecting To DataBase

use AdventureWorks2008R2;

--1.Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)


Select Count(*) 
From Sales.SalesPerson;


--2.	Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. (Schema(s) involved: Person)

Select FirstName,LastName
From Person.Person
Where FirstName LIKE 'B%';


--3.	Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing Assistant. (Schema(s) involved: HumanResources, Person)

Select p.FirstName,p.LastName,e.JobTitle
From HumanResources.Employee as e 
Inner Join Person.Person as p on p.BusinessEntityID=e.BusinessEntityID
Where e.JobTitle in ('Design Engineer','Tool Designer','Marketing Assistant') ;


--4.	Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production)

Select Name,Color 
From Production.Product
Where Weight=(select max(Weight)
From Production.Product);


--5.	Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display the value 0.00 instead. (Schema(s) involved: Sales)

Select Description,Cast(IsNull(MaxQty,0.0) as numeric(10,2)) As 'MaxQty'
From Sales.SpecialOffer; 


--6.	Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’.
--Note: The field [CurrencyRate].[AverageRate] is defined as 'Average exchange rate for the day.' (Schema(s) involved: Sales)

Select FirstName,LastName,ROW_NUMBER() Over(order by FirstName,LastName) As 'Sr.No' 
From Person.Person
Where FirstName LIKE '%ss%';


--7.	Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’.
--Display an additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)


Select Avg(AdventureWorks2008R2.Sales.CurrencyRate.AverageRate) as'Average exchange rate for the day' 
From AdventureWorks2008R2.Sales.CurrencyRate 
Where FromCurrencyCode = 'USD' and ToCurrencyCode ='GBP' And year(CurrencyRateDate)=2005;


--8.	Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
--Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above.
Select BusinessEntityID 
As 'SalesPersonID',
      Case 
         When CommissionPct=0.0 Then 'Band 0'
         When CommissionPct>=0.01 and CommissionPct<=0.015 Then 'Band 2'
         When CommissionPct>=0.015 Then 'Band 3'
      End as 'Commission Band'
From AdventureWorks2008R2.Sales.SalesPerson;


--9.	Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. 
--Hint: use [uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) 

DECLARE @ID int
SELECT @ID = BusinessEntityID 
FROM AdventureWorks2008R2.Person.Person 
WHERE FirstName = 'Ruth' 
	AND LastName = 'Ellerbrock'
	AND PersonType = 'EM';
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @ID;


--10.	Display the ProductId of the product with the largest stock level. 
--Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. (Schema(s) involved: Production)
 
 Select Top 1 ProductID 
 From Production.Product 
 Order by dbo.ufnGetStock(ProductID) Desc;