--Connecting To DataBase

Use AdventureWorks2008R2;


--Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed an order.

--Using Join


Select c.CustomerID
From Sales.Customer as c
     Left Join Sales.SalesOrderHeader as s On c.CustomerID=s.CustomerID 
Where s.SalesOrderID IS NULL; 


--Using SubQuery


Select CustomerID
From Sales.Customer
Where  CustomerID Not In (Select  CustomerID From Sales.SalesOrderHeader); 


--Using CTE


With CustomersWithNoOrder (CustomerID) 
AS 
(
	Select c.CustomerID
	From Sales.Customer as c
    Left Join Sales.SalesOrderHeader as s On c.CustomerID=s.CustomerID 
	Where s.SalesOrderID IS NULL
)
Select * FROM CustomersWithNoOrder;


--Using Exists


Select c.CustomerID
	From Sales.Customer as c
	where Not Exists (Select s.CustomerID from Sales.SalesOrderHeader as s where c.CustomerID=s.CustomerID);
