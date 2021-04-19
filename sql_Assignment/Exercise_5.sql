----Connecting To DataBase

Use AdventureWorks2008R2;

--Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. 

Go
Create Procedure Person.GetPersonNameInfo
		@name nchar(10)
		AS

		Select FirstName,MiddleName,LastName From Person.Person
		Where FirstName=@name
Go

--Alter the above Store Procedure to supply Default Values if user does not enter any value.( Use AdventureWorks)

Go
Alter Procedure Person.GetPersonNameInfo
		@name nchar(10)=null
	
		AS

		Select FirstName,MiddleName,LastName From Person.Person
		Where FirstName=IsNull(@name,FirstName)
Go
--Exec Person.GetPersonNameInfo 'Joseph';
