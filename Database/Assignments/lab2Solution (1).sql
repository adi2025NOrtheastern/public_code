-- LAB 2--
-- Setting the database context
USE AdventureWorks2008R2;
--2.1--

SELECT 
	CustomerID AS "Customer ID", 
	SalesOrderID AS "Sales order ID", 
	CAST(OrderDate AS DATE) AS "Order Date", 
	ROUND(TotalDue, 2) AS "Total Due"
FROM  Sales.SalesOrderHeader
WHERE OrderDate > CONVERT (DATE , '2008-05-01' , 102)
	AND TotalDue > 50000
ORDER BY CustomerID, OrderDate;	


--2.2--
SELECT 
	CustomerID AS "Customer ID",
	AccountNumber AS "Account Number",
	CAST(MAX(OrderDate) AS DATE) AS "Lastest Order Date",
	COUNT(*)	AS "Total Number of Orders"
	FROM  Sales.SalesOrderHeader
GROUP BY CustomerID, AccountNumber
ORDER BY CustomerID;

--2.3--

SELECT
	P.ProductID AS "Product ID", 
	P.Name AS "Product Name", 
	Round (P.ListPrice ,2 ) AS "List Price"
FROM Production.Product AS P
WHERE P.ListPrice > (SELECT ListPrice from Production.Product where ProductID =912)
ORDER BY P.ListPrice DESC;


--2.4--
SELECT 
	P.ProductID AS "Product ID", 
	P.Name AS "Product Name", 
	COUNT(*) AS "Number of Times"
FROM  Sales.SalesOrderDetail AS S JOIN  Production.Product AS P 
	ON S.ProductID = P.ProductID
GROUP BY P.ProductID, P.Name
HAVING COUNT(*) > 5
ORDER BY "Number of Times" DESC , P.ProductID ASC;


--2.5--

SELECT DISTINCT s.CUSTOMERID AS "Customer ID" , s.ACCOUNTNUMBER AS "Account Number"
FROM Sales.SalesOrderHeader s
EXCEPT
SELECT DISTINCT CUSTOMERID AS "Customer ID" ,  ACCOUNTNUMBER AS "Account Number"
FROM  Sales.SalesOrderHeader WHERE OrderDate > CONVERT (DATE , '2008-01-01' , 102)  
ORDER BY 1 ASC; 
--or--
/*SELECT DISTINCT s.CUSTOMERID AS "Customer ID" , s.ACCOUNTNUMBER AS "Account Number"
FROM Sales.SalesOrderHeader s
WHERE s.CUSTOMERID NOT IN (Select distinct CUSTOMERID AS "Customer ID" 
FROM  Sales.SalesOrderHeader WHERE OrderDate > CONVERT (DATE , '2008-01-01' , 102))
ORDER BY 1 ASC; -- 7315 rows */


--2.6--
SELECT  C.CustomerID AS "Customer ID", 
	P.FirstName AS "First Name",
	P.LastName AS "Last Name",
	E.EmailAddress AS "Email Address"
FROM Sales.Customer AS C  left JOIN Person.Person AS P 
ON C.CUSTOMERID = P.BusinessEntityID
left JOIN Person.EmailAddress AS E  
ON E.BusinessEntityID = C.CustomerID 
ORDER BY C.CUSTOMERID ASC;  

--or--

SELECT  C.CustomerID AS "Customer ID", 
	P.FirstName AS "First Name",
	P.LastName AS "Last Name",
	E.EmailAddress AS "Email Address"
FROM Person.Person AS P  JOIN Person.EmailAddress AS E    
ON E.BusinessEntityID = P.BusinessEntityID
 Right outer JOIN   Sales.Customer c
ON P.BusinessEntityID = C.CustomerID 
ORDER BY C.CUSTOMERID ASC; 

