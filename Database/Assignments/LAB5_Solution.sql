USE JAIN_ADITI_TEST;

--lab 5-1
--CREATE SCHEMA SALES GO SELECT * INTO JAIN_ADITI_TEST.SALES.SALESORDERHEADER FROM AdventureWorks2008R2.Sales.SalesOrderHeader;
GO

CREATE FUNCTION uf_total_sales_year_month
(@YEAR INT, @MONTH INT)
RETURNS FLOAT
AS
BEGIN
	DECLARE @TOTAL_SALES FLOAT;

	SELECT @TOTAL_SALES = SUM(TOTALDUE) 
	FROM AdventureWorks2008R2.Sales.SALESORDERHEADER
	WHERE YEAR(ORDERDATE) = @YEAR
			AND MONTH(ORDERDATE) = @MONTH
	GROUP BY YEAR(ORDERDATE), MONTH(ORDERDATE);

	RETURN ISNULL(@TOTAL_SALES, 0);
END


--or--
CREATE FUNCTION uf_total_sales_yr_month
(@YEAR INT, @MONTH INT)
RETURNS FLOAT
AS
BEGIN
	DECLARE @TOTAL_SALES FLOAT;

	SELECT @TOTAL_SALES = SUM(TOTALDUE) FROM AdventureWorks2008R2.Sales.SALESORDERHEADER
	WHERE YEAR(ORDERDATE) = @YEAR
			AND MONTH(ORDERDATE) = @MONTH
	GROUP BY YEAR(ORDERDATE), MONTH(ORDERDATE);

	SELECT  @TOTAL_SALES = CASE	WHEN @TOTAL_SALES IS NULL 
			THEN 0.0
			ELSE @TOTAL_SALES
			END; 

	RETURN @TOTAL_SALES;
END

--EXECUTE FUNCTION
use JAIN_ADITI_TEST;
SELECT dbo.uf_total_sales_yr_month(2009,2)  AS [TOTAL SALES];
SELECT dbo.uf_total_sales_yr_month(2008,2)  AS [TOTAL SALES];  

SELECT dbo.uf_total_sales_year_month(2009,2) AS [TOTAL SALES];
SELECT dbo.uf_total_sales_year_month(2008,2)  AS [TOTAL SALES];  

--drop function dbo.uf_total_sales_yr_mon;
/*USE AdventureWorks2008R2;
	SELECT SUM(TOTALDUE) as t FROM SALES.SALESORDERHEADER
	WHERE YEAR(ORDERDATE) = 2009
			AND MONTH(ORDERDATE) = 2
	GROUP BY YEAR(ORDERDATE), MONTH(ORDERDATE); --4662655.6183 */

/********************************************
--lab 5-2
*******************************************/

/* Write a trigger to put the change date and time in the LastModified column
 of the Order table whenever an order item in SaleOrderDetail is changed. */
use JAIN_ADITI_TEST;
CREATE TABLE Customer
(CustomerID INT PRIMARY KEY,
CustomerLName VARCHAR(30),
CustomerFName VARCHAR(30));

CREATE TABLE SaleOrder
(OrderID INT IDENTITY PRIMARY KEY,
CustomerID INT REFERENCES Customer(CustomerID),
OrderDate DATE,
LastModified datetime);

CREATE TABLE SaleOrderDetail
(OrderID INT REFERENCES SaleOrder(OrderID),
ProductID INT,
Quantity INT,
UnitPrice INT,
PRIMARY KEY (OrderID, ProductID));

--drop trigger T_UPDATE_ORDER_WHEN_SOD_UPDATE;
GO
CREATE TRIGGER T_UPDATE_ORDER_WHEN_SOD_UPDATE
ON DBO.SaleOrderDetail
AFTER INSERT,UPDATE, DELETE AS
BEGIN 
SET NOCOUNT ON
UPDATE SaleOrder SET LastModified= GETDATE()
FROM SaleOrder S 
where S.OrderID IN (SELECT ORDERID FROM INSERTED )
OR S.OrderID IN (SELECT ORDERID FROM deleted);
END;

go
SELECT * FROM dbo.Customer;
SELECT * FROM dbo.SaleOrder;
SELECT * FROM dbo.SaleOrderDetail;

INSERT INTO dbo.Customer VALUES (1,'AA','AJ');
INSERT INTO dbo.SaleOrder VALUES (1,GETDATE(),GETDATE());
INSERT INTO dbo.SaleOrderDetail VALUES (1,1,34,25);

UPDATE SaleOrderDetail SET Quantity=9 WHERE OrderID=1;
delete from SaleOrderDetail where OrderID=1;

select GETDATE();