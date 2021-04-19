Use AdventureWorks2008R2;


--Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. 
--Modify the above trigger to execute its check code only if the ListPrice column is   updated (Use AdventureWorks Database).


GO
CREATE TRIGGER trigger_ListPriceRiseCheck 
ON Production.Product
For Update
AS
	If Exists(Select * From inserted as i Inner Join deleted as d
	On i.ProductID=d.ProductID Where i.ListPrice>1.15*d.ListPrice)

BEGIN
	Raiserror('Transaction Failed',10,1)
	Rollback tran
	
END
Go


--update Production.Product set ListPrice=1400  where ProductNumber='FR-M94S-38';
--Alter the trigger to execute its check code only if the ListPrice column is   updated


Go
Alter TRIGGER Production.trigger_ListPriceRiseCheck 
ON Production.Product
For Update
AS
If UPDATE(ListPrice)
  BEGIN
	   If Exists(Select * From inserted As i Inner Join deleted as d
	   On i.ProductID=d.ProductID Where i.ListPrice>1.15*d.ListPrice)

	BEGIN
	Raiserror('Transaction Failed',10,1)
	Rollback tran
	
	END
  END
Go
