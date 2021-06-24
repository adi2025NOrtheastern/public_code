
-- Last Digit 0 or 4 Quiz 1

-- Question 3

select CustomerID, count(od.ProductID) AllProducts, 
       count(distinct od.ProductID) DifferentProducts
from [Sales].[SalesOrderHeader] sh
join [Sales].[SalesOrderDetail] od
     on sh.SalesOrderID = od.SalesOrderID
group by sh.CustomerID
having count(od.ProductID) = count(distinct od.ProductID)
       and count(distinct od.ProductID) > 10
order by count(distinct od.ProductID) desc;



-- Question 4

with temp1 as
(select sh.SalesPersonID, sum(sd.OrderQty) TotalQty
 from Sales.SalesOrderHeader sh
 join Sales.SalesOrderDetail sd
      on sh.SalesOrderID = sd.SalesOrderID
 join Production.Product p
      on sd.ProductID = p.ProductID 
 where year(OrderDate) in (2005, 2006, 2007) and month(OrderDate) in (10, 11, 12)
       and p.Color = 'Black'
 group by sh.SalesPersonID)

select top 1 with ties SalesPersonID, TotalQty
from temp1 
order by TotalQty desc;

