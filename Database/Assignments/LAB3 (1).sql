--Lab 3-1
/* Modify the following query to add a column that identifies the
 frequency of repeat customers and contains the following values
 based on the number of orders during 2007:
 'No Order' for count = 0
 'One Time' for count = 1
 'Regular' for count range of 2-5
 'Often' for count range of 6-10
 'Loyal' for count greater than 10
 Give the new column an alias to make the report more readable.
*/
USE AdventureWorks2008R2;

SELECT c.CustomerID, c.TerritoryID,
COUNT(o.SalesOrderid) [Total Orders],
CASE WHEN COUNT(o.SalesOrderid) = 0
	 THEN 'No Order'
	 WHEN COUNT(o.SalesOrderid) = 1
	 THEN 'One Time'
	 WHEN COUNT(o.SalesOrderid) BETWEEN 2 and 5
	 THEN 'Regular'
	 WHEN COUNT(o.SalesOrderid) BETWEEN 6 and 10
	 THEN 'Often'
	 WHEN COUNT(O.SalesOrderid) > 10
	 THEN 'Loyal' 
	 END AS [Order Frequency]
FROM Sales.Customer c
LEFT OUTER JOIN Sales.SalesOrderHeader o
 ON c.CustomerID = o.CustomerID
WHERE DATEPART(year, OrderDate) = 2007
GROUP BY c.TerritoryID, c.CustomerID;


--Lab 3-2
/* Modify the following query to add a rank without gaps in the
 ranking based on total orders in the descending order. Also
 partition by territory.*/
SELECT c.CustomerID, c.TerritoryID,
 COUNT(o.SalesOrderid) [Total Orders],
 DENSE_RANK() OVER (PARTITION BY c.TERRITORYID ORDER BY COUNT(o.SalesOrderid) DESC) AS Rank
FROM Sales.Customer c
LEFT OUTER JOIN Sales.SalesOrderHeader o
 ON c.CustomerID = o.CustomerID
WHERE DATEPART(year, OrderDate) = 2007
GROUP BY c.TerritoryID, c.CustomerID;


--Lab 3-3
/* Write a query that returns the female salesperson who received
 the highest bonus amount in North America. Include the salesperson's
 id and bonus amount in the returned data. Your solution must
 retrieve the tie if there is a tie. */

 SELECT "BUSINESS ENTITY ID", BONUS FROM (
	SELECT S.BusinessEntityID "BUSINESS ENTITY ID", 
	S.Bonus "BONUS", 
	DENSE_RANK() OVER (ORDER BY s.BONUS DESC) AS RANKING
	FROM Sales.SalesPerson S
	WHERE S.BusinessEntityID IN (SELECT BusinessEntityID FROM [HumanResources].[Employee] E 
								WHERE E.Gender='F')
	AND S.TerritoryID IN
		 (SELECT SS.TerritoryID FROM Sales.SalesTerritory SS WHERE SS.[Group] = 'North America')
 ) TEMP WHERE RANKING =1;

 --*****************Lab 3-4
/* Write a query to retrieve the most valuable salesperson of each month
 in 2007. The most valuable salesperson is the salesperson who has
 made most sales for AdventureWorks in the month. Use the monthly sum
 of the TotalDue column of SalesOrderHeader as the monthly total sales
 for each salesperson. If there is a tie for the most valuable salesperson,
 your solution should retrieve it. Exclude the orders which didn't have
 a salesperson specified.
 Include the salesperson id, the bonus the salesperson earned,
 and the most valuable salesperson's total sales for the month
 columns in the report. Sort the returned data by the month. */

 SELECT SalesPersonID "SALES PERSON ID",  Bonus "BONUS", "TOTAL SALES", "MONTH NUMBER" FROM (
 SELECT  OH.SalesPersonID "SalesPersonID", SP.Bonus , SUM(OH.TOTALDUE) AS [TOTAL SALES],
 DATEPART(MONTH,OH.ORDERDATE) "MONTH NUMBER",
 DENSE_RANK() OVER (PARTITION BY DATEPART(YEAR,OH.ORDERDATE), DATEPART(MONTH,OH.ORDERDATE) 
			  ORDER BY SUM(OH.TOTALDUE) DESC) AS RANKING
 FROM Sales.SalesOrderHeader OH JOIN Sales.SalesPerson SP
 ON OH.SalesPersonID = SP.BusinessEntityID
 WHERE OH.SalesPersonID IS NOT NULL
 AND DATEPART(YEAR, OrderDate) = 2007
 GROUP BY OH.SalesPersonID,SP.BONUS, OH.OrderDate
  ) TEMP WHERE RANKING=1
 ORDER BY DATEPART(MONTH,"MONTH NUMBER");
--OR--
  SELECT SalesPersonID "SALES PERSON ID", BONUS, [TOTAL SALES], "MONTH NUMBER" FROM (
 SELECT  OH.SalesPersonID, SUM(OH.TOTALDUE) AS [TOTAL SALES],
 DATEPART(MONTH,OH.ORDERDATE) "MONTH NUMBER",
 DENSE_RANK() OVER (PARTITION BY DATEPART(YEAR,OH.ORDERDATE), DATEPART(MONTH,OH.ORDERDATE) 
			  ORDER BY SUM(OH.TOTALDUE) DESC) AS RANKING
 FROM Sales.SalesOrderHeader OH 
 WHERE OH.SalesPersonID IS NOT NULL
 AND DATEPART(YEAR, OrderDate) = 2007
 GROUP BY OH.SalesPersonID, OH.OrderDate
  ) TEMP JOIN Sales.SalesPerson SP
 ON TEMP.SalesPersonID = SP.BusinessEntityID
  WHERE RANKING=1
 ORDER BY DATEPART(MONTH,"MONTH NUMBER");

 
--*****************Lab 3-5
/* Provide a unique list of customer id’s and account numbers which
 have ordered both the red and yellow products after May 1, 2008.
 Sort the list by customer id. */

 SELECT DISTINCT OH.CustomerID, OH.AccountNumber FROM SALES.SALESORDERHEADER OH
 WHERE OH.OrderDate > CONVERT(DATE,'2008-05-01',102)
 AND
 OH.SalesOrderID IN (SELECT SalesOrderID FROM Sales.SalesOrderDetail 
 WHERE ProductID IN ( SELECT ProductID FROM PRODUCTION.PRODUCT 
		WHERE COLOR IN ('Yellow')))
intersect
 SELECT DISTINCT OH.CustomerID, OH.AccountNumber FROM SALES.SALESORDERHEADER OH
 WHERE OH.OrderDate > CONVERT(DATE,'2008-05-01',102)
 AND
 OH.SalesOrderID IN (SELECT SalesOrderID FROM Sales.SalesOrderDetail 
 WHERE ProductID IN ( SELECT ProductID FROM PRODUCTION.PRODUCT 
		WHERE COLOR IN ('Red')))
ORDER BY OH.CustomerID;
