--Connecting To DataBase
Use AdventureWorks2008R2;

--Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks.


SELECT TOP 5 AccountNumber,OrderDate
FROM Sales.SalesOrderHeader s
WHERE s.TotalDue > 70000
Order By OrderDate Desc;