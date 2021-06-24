
--PART A--

CREATE DATABASE JAIN_ADITI_TEST;
USE JAIN_ADITI_TEST;

CREATE TABLE dbo.Customers 
(     CustomerID varchar(5) NOT NULL PRIMARY KEY ,     
	  Name varchar(40) NOT NULL     ); 
 
CREATE TABLE dbo.Orders 
(     OrderID int IDENTITY NOT NULL PRIMARY KEY,
	  CustomerID varchar(5) NOT NULL         
		REFERENCES Customers(CustomerID),
	  OrderDate datetime DEFAULT Current_Timestamp     ); 
 
CREATE TABLE dbo.Products ( 
ProductID int IDENTITY NOT NULL PRIMARY KEY,
Name varchar(40) NOT NULL, 
UnitPrice money NOT NULL     ); 
 
CREATE TABLE dbo.OrderItems (   
OrderID int NOT NULL         
	REFERENCES dbo.Orders(OrderID),     
ProductID int NOT NULL
	REFERENCES dbo.Products(ProductID),    
UnitPrice money NOT NULL,     
Quantity int NOT NULL         
CONSTRAINT PKOrderItem PRIMARY KEY CLUSTERED (OrderID, ProductID)     );

CREATE TABLE DBO.OFFER (
OFFERID INT IDENTITY NOT NULL PRIMARY KEY,
OFFERNAME VARCHAR(20) NOT NULL );


--ADD COLUMN 
ALTER TABLE DBO.ORDERITEMS
	ADD OFFER INT ;

ALTER TABLE DBO.ORDERITEMS
	ADD CONSTRAINT FK4 FOREIGN KEY (OFFER) REFERENCES OFFER(OFFERID);

SELECT * FROM dbo.OrderItems;

INSERT INTO dbo.Customers VALUES (11788, 'KATE JOHN');
INSERT INTO dbo.Customers VALUES (11789, 'ATE JOHN');
INSERT INTO dbo.Customers VALUES (11790, 'KAE JOHN');
INSERT INTO dbo.Customers VALUES (11791, 'KATE JON');
INSERT INTO dbo.Customers VALUES (11792, 'KOHN');
SELECT * FROM dbo.Customers;

INSERT INTO OrderS VALUES (11788, '2008-09-01');
INSERT INTO OrderS VALUES (11789, '2008-09-01');
INSERT INTO OrderS VALUES (11788, '2008-09-01');
SELECT * FROM Orders;

INSERT INTO Products VALUES ('PEN',12);
INSERT INTO Products VALUES ('PENCIL',8);
INSERT INTO Products VALUES ('RUBBER',2);
INSERT INTO Products VALUES ('BOOK',102);
SELECT * FROM Products;

INSERT INTO dbo.OFFER VALUES ('NONE');

INSERT INTO dbo.OFFER VALUES ('SPECIAL');

INSERT INTO OrderItems VALUES (2,1,12,30,1);
INSERT INTO OrderItems VALUES (2,2,12,30,2);
INSERT INTO OrderItems VALUES (3,4,1.3,30,2);
SELECT * FROM OrderItems;

DROP TABLE DBO.ORDERITEMS;
ALTER TABLE DBO.ORDERS
	ADD OFFER INT ;
SELECT * FROM Orders;
INSERT INTO dbo.Orders (CUSTOMERID, OrderDate, OFFER) VALUES (11788,GETDATE(),1) ;
SELECT * FROM Orders;

--CREATE VIEW ORDERS_V AS SELECT * FROM DBO.Orders;
--SELECT * FROM ORDERS_V;
--DROP VIEW ORDERS_V;

ALTER TABLE DBO.ORDERS ALTER COLUMN ORDERDATE DATETIME NOT NULL;
ALTER TABLE dbo.Orders DROP COLUMN OFFER;

DROP TABLE dbo.Orders;
DROP TABLE dbo.Customers;
DROP TABLE dbo.OFFER;
DROP TABLE dbo.ORDERITEMS;
DROP TABLE dbo.Products ;


---*******************************STEP 3*********************

--CREATE TargetCustomers
CREATE TABLE TargetCustomers
(
TargetID  INT identity NOT NULL PRIMARY KEY,
FirstName varchar(20) NOT NULL,
LastName varchar(20) NOT NULL,
Address varchar(100) NOT NULL,
City varchar(20) NOT NULL,
State varchar(20) NOT NULL,
ZipCode int NOT NULL
);

-- CREATE MailingLists
CREATE TABLE MailingLists (
MailingListID int identity NOT NULL PRIMARY KEY,
MailingList VARCHAR(200) NOT NULL
);

-- CREATE TargetMailingLists
CREATE TABLE TargetMailingLists(
TargetID INT NOT NULL
	REFERENCES TargetCustomers(TargetID),
MailingListID int NOT NULL
	REFERENCES MailingLists(MailingListID)
CONSTRAINT PKTargetMailingLists PRIMARY KEY CLUSTERED (TargetID, MailingListID)    
);
--DROP TABLE TargetMailingLists;
-- DROP TABLE MailingLists;
--DROP TABLE TargetCustomers;
--alter table TargetMailingLists alter column targetid int not null;
-- alter table TargetMailingLists alter column MailingListID int not null;
--select * from  TargetMailingLists;
--select * from TargetCustomers;
--select * from  MailingLists;

--*************************************PART B
use AdventureWorks2008R2;
SELECT DISTINCT CustomerID, 
	   STUFF((SELECT DISTINCT ', '+RTRIM(CAST(SALESPERSONID  as char))  
       FROM Sales.SalesOrderHeader 
       WHERE CustomerID = c.customerid
	   FOR XML PATH('')) , 1, 2, '') AS SalespersonID
FROM SALES.SalesOrderHeader C
WHERE SalesPersonID IS NOT NULL
ORDER BY CustomerID DESC;


--PART C
use AdventureWorks2008R2;
SELECT DISTINCT OD.SalesOrderID , 
		STUFF((SELECT ', '+RTRIM(CAST(ProductID AS CHAR))
		FROM SALES.SalesOrderDetail
		WHERE SalesOrderID = OD.SalesOrderID
		ORDER BY ProductID ASC
		FOR XML PATH('')) ,1,2,'') AS PRODUCTID
FROM Sales.SalesOrderDetail OD 
ORDER BY OD.SalesOrderID ASC;

--SELECT COUNT (*) FROM Sales.SalesOrderHeader;