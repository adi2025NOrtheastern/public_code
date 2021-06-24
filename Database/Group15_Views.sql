Use Group15_Final;
go
---------------------------Views-------------------------------

--1.To report all Products a customer purchased with the quantity of the particular --product.
go
CREATE VIEW vwCustomerWiseOrderDetail
AS
	SELECT TOP 100 PERCENT p.PRODUCTName AS ProductName, c.CustomerID, (c.FirstName + ' ' + c.LastName) AS CustomerName , SUM(ConfirmedQuantity) AS [Total Quantity]   
	FROM Customer c
	JOIN Cart c1
	ON c.CustomerID = c1.CustomerId
	JOIN Product p
	ON c1.ProductID = p.PRODUCTID
	JOIN OrderHeader h
	ON c1.CartId = h.CartId
	JOIN OrderItems i
	ON i.OrderID = h.OrderId
	WHERE c1.Status = 'InActive'
	GROUP BY c.CustomerId, c.FirstName, c.LastName, PRODUCTName
	ORDER BY CustomerID

go
-- 2. View for displaying all products sold by store in Horizontal reporting format.

 create view vv_Store_Products
 as
  with temp as(
 select distinct c.catalogid as [Catalog],  s.storename as [Store Name] , p.productname ,
 c.promotionid as [Promotion], c.availablestock [Quantity Available],  c.productid
 from [dbo].catalog c inner join dbo.product p
 on c.productid = p.productid
 inner join store s 
 on s.storeid = c.storeid
 where c.isactive='Yes')
 select t.[Store Name] , 
 stuff((select ', ' + Rtrim(cast (t1.productid as char))
 from  temp t1
 where t1.[Store Name]=t.[Store Name]
 for xml path('')),1, 2, '' ) as Products 
 from temp t
 group by t.[Store Name];
 --order by t.productid 

 go
--3. A view to display the catalog of each store.
 
 CREATE VIEW v_Catalog
 AS 
 select top 100 percent c.catalogid as [Catalog],  s.storename as [Store Name] , p.productname as [Product Name],
 c.promotionid as [Promotion], c.availablestock [Quantity Available]
 from [dbo].catalog c inner join dbo.product p
 on c.productid = p.productid
 inner join store s 
 on s.storeid = c.storeid
 where c.isactive='Yes'
 order by c.catalogid desc, s.storeName;
 


go
-----------------------------------------------------------PIVOT-----------------------------------------------------------

--ProductWise Customers’ OrderItems’ count

	SELECT ProductName, ISNULL([C001], 0) AS [C001], ISNULL([C003], 0) AS [C003], 
	ISNULL([C004], 0) AS [C004], ISNULL([C005], 0) AS [C005], 
	ISNULL([C006], 0) AS [C006], ISNULL([C007], 0) AS [C007], ISNULL([C009], 0) AS [C009], 
	ISNULL([C011], 0) AS [C011], ISNULL([C013], 0) AS [C013] 
	FROM
	(
		SELECT p.PRODUCTName AS ProductName, c.CustomerID AS CustomerID, ConfirmedQuantity   
		FROM Cart c1
		JOIN Customer c
		ON c.CustomerID = c1.CustomerId
		JOIN Product p
		ON c1.ProductID = p.PRODUCTID
		JOIN OrderHeader h
		ON c1.CartId = h.CartId
		JOIN OrderItems i
		ON i.OrderID = h.OrderId
		WHERE c1.Status = 'InActive'
	)SourceTable
	PIVOT
	(
		SUM(ConfirmedQuantity)
		FOR CustomerID IN ([C001], [C003], [C004], [C005], [C006], [C007], [C009], [C011], [C013])
	)PivotTable