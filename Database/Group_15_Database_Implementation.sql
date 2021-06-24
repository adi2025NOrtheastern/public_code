---Group 15 --
--Database implementation Script---



Create database Group15_Final;
go
Use Group15_Final;
go
-------------------------------------Encryption---------------------------------
CREATE MASTER KEY 
ENCRYPTION BY PASSWORD='Test_P@ssword';

CREATE CERTIFICATE TestCertificate
WITH SUBJECT='Test Certificate',
EXPIRY_DATE='10.31.2026'

CREATE SYMMETRIC KEY TestSymmetricKey
WITH ALGORITHM=AES_128
ENCRYPTION BY CERTIFICATE TestCertificate

OPEN SYMMETRIC KEY TestSymmetricKey
DECRYPTION BY CERTIFICATE TestCertificate

-- CREATE tables --

-------------------CustomerCareOffice-------------------------

CREATE TABLE CustomerCareOffice
(
        CCOfficeID INT NOT NULL PRIMARY KEY IDENTITY (1,1),
        OfficeTelNo VARCHAR(15),
        OfficeEmail VARCHAR(50),
        OfficeFaxNo VARCHAR(15),
        CreationDate DATETIME
);

-------------Location-----------------------


CREATE TABLE Location(
LocationID INT IDENTITY PRIMARY KEY,
ApartmentOrBuilding VARCHAR(50) NOT NULL,
StreetName VARCHAR(30) NOT NULL,
City VARCHAR(20) NOT NULL,
State VARCHAR(20) NOT NULL,
Country VARCHAR(15) NOT NULL,
Zipcode VARCHAR(10) NOT NULL,
CreationDate DATETIME NOT NULL
)



-------------------Employee-------------------------

CREATE TABLE Employee
(
	EmployeeID VARCHAR(5) NOT NULL PRIMARY KEY,
	EmpFName VARCHAR(50),
	EmpLName VARCHAR(50),
	WorkEmail VARCHAR(100),
	Designation VARCHAR(50),
	JoiningDate DATETIME,
	ManagerID VARCHAR(5) REFERENCES Employee(EmployeeID),
	CCOfficeID INT NOT NULL REFERENCES CustomerCareOffice(CCOfficeID),
	Salary INT,
	CreationDate DATETIME,
	ModifiedDate DATETIME,
	DOB DATE,
	Age AS DATEDIFF(hour,DOB,getdate())/8876
);

---------Login----------------

CREATE TABLE Login(                                                                
UserID INT IDENTITY PRIMARY KEY,                                                                
UserName VARCHAR(20) NOT NULL,                                                                
Password VARBINARY(250),                                                                
SecurityQues1 VARCHAR(200) NOT NULL,                                                                
SecurityAns1 VARCHAR(50) NOT NULL,                                                                
SecurityQues2 VARCHAR(200),                                                                
SecurityAns2 VARCHAR(50),                                                                
BusinessEntityID VARCHAR(5) NOT NULL UNIQUE,
CreationDate DATETIME NOT NULL                                                           
)  

 ----------------Product----------------------

CREATE TABLE PRODUCT(
PRODUCTID INT IDENTITY(1000,1) NOT NULL PRIMARY KEY,
PRODUCTName varchar(100) NOT NULL ,
ProductDescription varchar(100) NOT NULL ,
ProductSalesUoM char(10), 
Hazmat char ,
ProductWeightByOz decimal,
CreationDate date
);

---------------Card-----------------------


--------Function for Computed Column ExpiryDate in Card----------  
go
CREATE FUNCTION uf_ExpiryDate
(@yearValue INT , @monthValue INT)
RETURNS DATE
AS
BEGIN

DECLARE @todaydate AS DATE
DECLARE @dateAfterOneYear AS DATE

SET @todaydate = CAST('01-01-'+CAST(@yearValue AS char) AS DATE)
SET @dateAfterOneYear = DATEADD(yy, 1, @todaydate)

DECLARE @expiryDate AS DATE

SET @expiryDate = CAST((CAST(@yearValue AS CHAR) + '-'+ CAST(@monthValue AS CHAR) + '-' 
				+ CAST(CASE WHEN @monthValue IN (1,3,5,7,8,10,12)
					        THEN 31 
							WHEN @monthValue = 2 and  DATEDIFF(DAY,@todaydate,@dateAfterOneYear) = 365
							THEN 28
							WHEN @monthValue = 2 and  DATEDIFF(DAY,@todaydate,@dateAfterOneYear) = 366
							THEN 29
							ELSE 30
							END AS CHAR)) AS DATE)
RETURN @expiryDate;
END
go

CREATE TABLE Card(
  CardID int identity(1,1) NOT NULL primary key,
  NameonCard varchar(20) NOT NULL,
  CardType char(6) NOT NULL,
  CardNumber varbinary(250) NOT NULL,
  ExpMonth smallint CHECK (ExpMonth >=1 AND ExpMonth <=12),
  ExpYear smallint CHECK (ExpYear >= YEAR(GETDATE())),
  ExpDate AS dbo.uf_ExpiryDate(ExpYear,ExpMonth)
  UNIQUE (CardNumber)
  );

-------------------Membership------------
CREATE TABLE Membership
(
MembershipID varchar(10) NOT NULL Primary key,
Name varchar(50) NOT NULL,
ValidFrom date NOT NULL,
ValidTo date NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp 
);

-------------Promotions---------------
CREATE TABLE Promotions
(
PromotionID varchar(10) NOT NULL Primary key,
OfferBenefit varchar(50) NOT NULL,
PromoDescription varchar(150) NOT NULL,
OfferStartDate date NOT NULL,
OfferEndDate date NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp 
);

-------------Customer-------------


CREATE TABLE Customer
(
   CustomerID Varchar(5) NOT NULL PRIMARY KEY,
   FirstName VARCHAR(50),
   LastName VARCHAR(50),
   Email VARCHAR(200),
   PhoneNumber Varchar(10),
   Gender VARCHAR(25),
   DOB DATETIME,
   LocationID INT NOT NULL REFERENCES Location (LocationID),
   CreationDate DATETIME DEFAULT Current_Timestamp,
   ModifiedDate DATETIME DEFAULT Current_Timestamp,
   CardID INT NOT NULL REFERENCES Card (CardID),
   MembershipID Varchar(10) NOT NULL REFERENCES Membership (MembershipID),
   Age AS DATEDIFF(hour,DOB,getdate())/8876
   );

   ----------------Store------------------------

CREATE TABLE STORE(
STOREID INT IDENTITY(50000,1) NOT NULL PRIMARY KEY,
StoreName varchar(20) NOT NULL ,
LocationID INT NOT NULL
	REFERENCES LOCATION(LocationID),
PhoneNumber VARCHAR(20) NOT NULL, 
Email varchar(30) NOT NULL,
FaxNo VARCHAR(20) NOT NULL,
CreationDate date
);

-------------Catalog----------


 CREATE TABLE Catalog
(
   CatalogID VARCHAR(10) NOT NULL ,
   CatalogName VARCHAR(100),
   Category VARCHAR(100),
   Description VARCHAR(500),
   Price MONEY,
   ProductID INT NOT NULL REFERENCES Product (ProductID),
   StoreID INT NOT NULL REFERENCES Store (StoreID),
   AvailableStock INT,
   PromotionID Varchar(10) REFERENCES Promotions (PromotionID),
   CreationDate DATETIME DEFAULT Current_Timestamp,
   IsActive CHAR (5), 
   CONSTRAINT CatalogPK PRIMARY KEY CLUSTERED (ProductID, CatalogID, StoreID)
   );


-------------- MembershipPromo--------
CREATE TABLE MembershipPromo
(
MembershipID varchar(10)  NOT NULL
	References Membership(MembershipID),
PromotionID varchar(10)  NOT NULL 
	References Promotions(PromotionID),
	CONSTRAINT PKMemberPromo PRIMARY KEY CLUSTERED (MembershipID, PromotionID )
);

------------------- DeliveryExecutive-------------------------
		  
CREATE TABLE DeliveryExecutive
(
	EmployeeID VARCHAR(5) NOT NULL PRIMARY KEY REFERENCES Employee(EmployeeID),
	LocationID  INT NOT NULL REFERENCES Location(LocationID),
	CurrentAvailabilityStatus INT,
	NumOfSuccessfulOrder INT
);

-----------------------Cart------------------
go
CREATE FUNCTION uf_checkCartid
(@cartid int)
returns int
as
begin
Declare @flag int =1;
select @flag =  0 from cart where cartid = @cartid;

return @flag;
end;
go
CREATE TABLE Cart
(
RowID int identity primary key,
CartId int NOT NULL,
CustomerId varchar(5) NOT NULL  
	References Customer(CustomerId) ,
ProductID int NOT NULL,
CatalogID varchar(10) NOT NULL,
Quantity int NOT NULL ,
Price money NOT NULL ,
DateAdded date NOT NULL ,
Status char(10) NOT NULL ,
StoreID int NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp ,
CONSTRAINT FK_Cart foreign key (ProductID, CatalogID, StoreID) references dbo.catalog(ProductID, CatalogID, StoreID),
);
go
------------------- OrderHeader-------------
--Function for computed column TotalAmount in OrderHeader
go
CREATE FUNCTION UF_calc_total_amount
(@cartid int)
returns decimal
as
begin
Declare @totalamt decimal=0.0;
select @totalamt = cast(sum(price * quantity) as decimal) from cart where cartid = @cartid
group by cartid;

return @totalamt;
End;
go
CREATE TABLE ORDERHEADER(
OrderId int identity (100,1) NOT NULL PRIMARY KEY,
OrderDate date NOT NULL ,
OrderStatus char(15) NOT NULL ,
OrderCompletionDate date NOT NULL ,
EmployeeID varchar(5) NOT NULL
	references DeliveryExecutive(EmployeeID),
CartId int NOT NULL);


Alter table ORDERHEADER add TotalAmount AS dbo.UF_calc_total_amount(cartid);

Alter table orderheader add constraint checkCartid check (dbo.uf_checkCartid(cartid) =0);

-------------------OrderItems-------------------------
-------------Computed Column (ProductAmount)-------------------------
go
CREATE FUNCTION UF_calc_product_amount
(@rowid int)
returns decimal
as
begin
Declare @productamt decimal=0.0;
select @productamt = cast((c.price * o.confirmedquantity) as decimal) 
from cart c inner join orderitems  o
on c.rowid=o.rowid
where c.rowid = @rowid;

return @productamt;
end;
go

CREATE TABLE OrderItems
(
        OrderID INT REFERENCES OrderHeader(OrderID),
        ProductID INT REFERENCES Product(ProductID),
        OrderedQuantity INT NOT NULL,
        ConfirmedQuantity INT NOT NULL,
        RowID INT REFERENCES Cart(RowID),
		CONSTRAINT OrderItemsPK PRIMARY KEY CLUSTERED (RowID, OrderID)
)

Alter table ORDERITEMS add ProductAmount AS dbo.UF_calc_product_amount(rowid);

-------------Invoice--------------------------
----------Computed Column (TotalDue)-------------------------
go
CREATE FUNCTION uf_TotalDue( @orderid int )
returns float
as
begin
 
declare @Finalamount as float 
declare @Totalamount as float
declare @OfferBenefit as float

set @OfferBenefit = (select Cast(round(p.OfferBenefit,2) as float)
			from invoice as i 
			inner join OrderHeader as oh on oh.OrderId = i.orderid
			inner join Cart as c on c.cartid = oh.cartid
			inner join catalog as ct on ct.catalogid = c.catalogid
			inner join promotions as p on ct.promotionid = p.promotionid
			where oh.OrderId = @orderid
	group by i.invoiceid,oh.orderid,oh.totalamount,ct.promotionid,p.OfferBenefit) 

set @TotalAmount = (select Cast(round(oh.totalamount,2) as float)
			from invoice as i 
			inner join OrderHeader as oh on oh.OrderId = i.orderid
			where oh.OrderId = @orderid
			group by i.invoiceid,oh.orderid,oh.totalamount)

set @Finalamount =  CASE WHEN @OfferBenefit > 0 
THEN Cast(ISNULL(ROUND(@TotalAmount - ((@TotalAmount *    @OfferBenefit) / 100),2),0)  AS FLOAT)
		ELSE @TotalAmount
		END
					
return @Finalamount;
End;
go

 CREATE TABLE Invoice
(
InvoiceID varchar(10) NOT NULL Primary key,
OrderID Int References OrderHeader(OrderID) NOT NULL,
TotalDue AS dbo.uf_totaldue(OrderID),
InvoiceDate date NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp 
);

--------------Payment-------------------------

  CREATE TABLE Payment
(
PaymentID varchar(10) NOT NULL Primary key,
InvoiceID varchar(10) NOT NULL References Invoice(InvoiceID),
PaymentStatus varchar(15) NOT NULL,
CardID INT NOT NULL References Card(CardID),
PaymentDate date NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp 
);


-------------Feedback-----------------------

 CREATE TABLE Feedback
(
FeedbackID INT IDENTITY(1,1) NOT NULL Primary key,
FeedbackDescription varchar(50) NOT NULL,
RatingOutof5 INT CHECK(RatingOutof5 >=0 AND RatingOutof5 <=5) NOT NULL,
OrderID Int References OrderHeader(OrderID) NOT NULL,
FeedbackDate date NOT NULL,
CreationDate datetime DEFAULT Current_Timestamp 
);

---------------------------------------------------------Triggers ----------------------------------------------------------

--1. When an item is inserted into Orderheader, Inactive field in Cart is updated :
 go
CREATE TRIGGER tr_InactiveCart
   ON OrderHeader
   AFTER INSERT
   AS
   BEGIN

		UPDATE Cart
		SET Status='InActive' 
		FROM Cart o
		JOIN Inserted i
		ON o.CartID = i.CartID;


   END
   go
--2. Based on the available stock, available stock field on Catalog is updated :

CREATE TRIGGER AvailabilityStatus ON [dbo].Catalog
   FOR INSERT,UPDATE 
   AS 
   declare @flag char(10);
	SET NOCOUNT ON;
	BEGIN
	Select @flag =  'Yes' FROM CATALOG c join inserted i  
						on i.ProductID = c.productid 
						and i.storeid=c.storeid
						where c.availablestock > 0;
	
	UPDATE dbo.Catalog  SET IsActive = IsNull(@flag,'No')
	where ProductID in (SELECT ProductID FROM inserted) AND StoreID IN (SELECT StoreID FROM inserted)  
    END;

--3. ‘NumOfSuccessfulOrder’ for delivery executives is incremented based on ‘successful’ order -- completion :
go
CREATE trigger tr_UpdateNoOfSuccessfulOrder
ON OrderHeader
AFTER UPDATE
AS
BEGIN
	IF(EXISTS(SELECT * FROM inserted) AND EXISTS (SELECT * FROM inserted))
	BEGIN
	SET nocount on;

	SELECT * INTO #inserted FROM inserted
	SELECT * INTO #deleted FROM deleted

	DECLARE @a AS CHAR(15)
	DECLARE @b AS CHAR(15)
	DECLARE @empId AS CHAR(5)

	SET @empId = (select EmployeeID from #inserted)
	SET @a= (select OrderStatus from #inserted)
	SET @b = (select OrderStatus from #deleted)

		IF(@a <> @b)
		BEGIN
		UPDATE DeliveryExecutive SET NumOfSuccessfulOrder =  NumOfSuccessfulOrder +1 WHERE EmployeeID = @empId
		END
	END
END
go
--4. Trigger for inserting in OrderItems when an order entry is created in OrderHeader :

Create trigger tname 
 on Orderheader
 after insert
 as
 begin
 insert into orderitems (orderid, productid, orderedquantity, confirmedquantity, rowid)
 select i.orderid,c.productid,c.quantity,c.quantity,c.rowid
 from cart c inner join inserted i
 on c.cartid=i.cartid;

 End;

-------------------------------------------Insert Statements------------------------------------------
-------Location----------

GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'Apt D', N'Winn Street', N'Burlington', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'Target', N'Pleasant Street', N'Burlington', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'143 Avalon Apt', N'Bristol Street', N'Jersey City', N'NJ', N'USA', N'90001', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'Central Ave', N'Lynwood', N'Jersey City', N'NJ', N'USA', N'90002', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'1 Daniel Apt', N'Foster Rd', N'Boston', N'MA', N'USA', N'78244', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'Bodega', N'Washington Street', N'Boston', N'MA', N'USA', N'2210', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'416 Young Apt', N'Hopewell Junction', N'New York', N'NY', N'USA', N'10004', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'NorthVille', N'Woburn Street', N'New York', N'NY', N'USA', N'10004', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES (N'414 AltaUnion House', N'Arlington Road', N'Natick', N'MA', N'USA', N'17600', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'Victoria', N'Boylston Street', N'Boston', N'MA', N'USA', N'1899', CAST(N'2020-08-10T09:14:10.860' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'101 Eaves', N'Center Street', N'Burlington', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'Cold Stone', N'39 Center Street', N'Burlington', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'12 Brooks Apt', N'Wall Street', N'Woburn', N'MA', N'USA', N'1930', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'WaySide', N'Badfer Street', N'BadFered', N'MA', N'USA', N'12580', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'12 City View Apt', N'Alpnohsuh Street', N'Malden', N'MA', N'USA', N'25001', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'MarryMac', N'Mac Street', N'Nashua', N'NH', N'USA', N'15001', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'102 Terrace Drive', N'Happy Street', N'Charlotte', N'NC', N'USA', N'2803', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'Chipottle', N'University Buolevard', N'Charlotte', N'NC', N'USA', N'2804', CAST(N'2020-08-10T09:14:14.530' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'271 Cambridge Apt', N'Cambridge Street', N'Boston', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:17:59.190' AS DateTime))
GO
INSERT [dbo].[Location] ([ApartmentOrBuilding], [StreetName], [City], [State], [Country], [Zipcode], [CreationDate]) VALUES ( N'Lumber Store', N'Pleasant Street', N'Boston', N'MA', N'USA', N'1803', CAST(N'2020-08-10T09:17:59.190' AS DateTime))
GO


-----------------membership---------------------
INSERT [dbo].[Membership] ([MembershipID], [Name], [ValidFrom], [ValidTo], [CreationDate]) VALUES (N'M001', N'Gold', CAST(N'2020-08-01' AS Date), CAST(N'3001-12-31' AS Date), CAST(N'2020-08-10T09:04:25.860' AS DateTime))
GO
INSERT [dbo].[Membership] ([MembershipID], [Name], [ValidFrom], [ValidTo], [CreationDate]) VALUES (N'M002', N'Silver', CAST(N'2020-08-01' AS Date), CAST(N'3001-12-31' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Membership] ([MembershipID], [Name], [ValidFrom], [ValidTo], [CreationDate]) VALUES (N'M003', N'Platinum', CAST(N'2020-08-01' AS Date), CAST(N'3001-12-31' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Membership] ([MembershipID], [Name], [ValidFrom], [ValidTo], [CreationDate]) VALUES (N'M004', N'Regular', CAST(N'2020-08-01' AS Date), CAST(N'3001-12-31' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Membership] ([MembershipID], [Name], [ValidFrom], [ValidTo], [CreationDate]) VALUES (N'M005', N'Premium', CAST(N'2020-08-01' AS Date), CAST(N'3001-12-31' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
-------------------Promotion------------------

INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO1', N'5', N'This offer will provide 5 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO10', N'50', N'This offer will provide 50 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO2', N'10', N'This offer will provide 10 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO3', N'12', N'This offer will provide 12 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO4', N'13', N'This offer will provide 13 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO5', N'14', N'This offer will provide 14 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO6', N'1', N'This offer will provide 1 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO7', N'20', N'This offer will provide 20 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO8', N'25', N'This offer will provide 25 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO
INSERT [dbo].[Promotions] ([PromotionID], [OfferBenefit], [PromoDescription], [OfferStartDate], [OfferEndDate], [CreationDate]) VALUES (N'PROMO9', N'0', N'This offer will provide 0 percent off on the order', CAST(N'2020-08-10' AS Date), CAST(N'2020-08-01' AS Date), CAST(N'2020-08-10T09:04:25.873' AS DateTime))
GO

--------------MembershipPromo--------------------
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M001', N'PROMO1')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M001', N'PROMO2')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M001', N'PROMO3')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M001', N'PROMO4')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M001', N'PROMO5')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M002', N'PROMO1')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M002', N'PROMO2')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M002', N'PROMO3')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M003', N'PROMO4')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M003', N'PROMO5')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M004', N'PROMO1')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M004', N'PROMO3')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M004', N'PROMO4')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M005', N'PROMO2')
GO
INSERT [dbo].[MembershipPromo] ([MembershipID], [PromotionID]) VALUES (N'M005', N'PROMO5')
GO
--------------card--------------------------
 
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Aditya Jumani', N'Debit ', 0x00EE9549C5194043B47881425468B99A02000000A5032689DF936CE4FE22EB5F14EFCEA591CB42C904D7328C0FADF09C8A90B3D33AFE59E4A7A725510C0AA9C85587BB7E, 6, 2024)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Jina Kumar', N'Credit', 0x00EE9549C5194043B47881425468B99A02000000A2A7649BA48C6D4DD699AFCFD946FAEF17B187FC620C804B35630257EC30022BAF64EEB0A42D46810C961BFE672A59F4, 12, 2020)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'John Jacob', N'Credit', 0x00EE9549C5194043B47881425468B99A02000000CCAF5E06769121FBAD301DAD76A922D35F0D9506EC60FDF3E478ACF5C151834F4A776A5236ECE0C1C64DC6453CB3FA24, 10, 2040)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Yahum Mani', N'Credit', 0x00EE9549C5194043B47881425468B99A02000000417389819A4E0166FE239D282B9B2397E944A0DA22AF7D339F5EE266BBE603323C793C61AC8C69B002E72A98FCE95833, 11, 2030)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Lily Tsu', N'Debit ', 0x00EE9549C5194043B47881425468B99A02000000B49BA455113968717D741DCF8BE4B1CDC57548B9F363266E5EC8A961A44789CA4DDE92D2BE24FFD688A7F01C93E4188A, 8, 2021)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Mary Lu', N'Debit ', 0x00EE9549C5194043B47881425468B99A020000006D0A7E0EC5E88F7FE674EE418CDA3D3F5B0F58C0AFF57D86C0F2D03616C2282581701F9E6233CB19F4463480B60FACC6, 4, 2025)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Bilal Shaikh', N'Credit', 0x00EE9549C5194043B47881425468B99A020000004251D9BCE5D33FFF89C32E75F5EAB26238CAC1C7DCBD7E3A20411E20126B207F925D8D3184F8BFFBFC3A5FF23B811FBD, 7, 2025)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Milton Musk', N'Credit', 0x00EE9549C5194043B47881425468B99A020000007DDF88FFB66991268E788B50C071E88EE80C5872981AF920176817AB61FC154C5BB52D480B2570A0B2B7379CA26EA829, 2, 2024)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES (N'Ronald Koeman', N'Credit', 0x00EE9549C5194043B47881425468B99A02000000F4A49744E7DCFBB811739A4FC9EF41DA1024EA6172187FB6EB856E8586847939B660A805B67A2494D30A76E31F88901F, 3, 2022)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES ( N'Ryan Hudson', N'Debit ', 0x00EE9549C5194043B47881425468B99A0200000064E0C52364F73FF82FABB8ADC3099A50A20CADF909E59652D0F9A898BDC4B4FC9863E0150AD4AABABD079AFDD2DEA15F, 5, 2028)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES ( N'Nestor Carbonell', N'Credit', 0x00EE9549C5194043B47881425468B99A02000000A17E20DDEDFD2C43643932C36F9147A64BB8A95EB55D5CDED90F6A5947E11D43ABCEEF8D36995CAFC33994F0044B4316, 12, 2020)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES ( N'King James', N'Credit', 0x00EE9549C5194043B47881425468B99A0200000024DCD52094F89821C8ED9D619B079E9BBCD9A2C8B7DDC95E132D1A411E9CB9725CEAB4730966CF890BAF6373E0B2E390, 1, 2035)
GO
INSERT [dbo].[Card] ([NameonCard], [CardType], [CardNumber], [ExpMonth], [ExpYear]) VALUES ( N'Martin Odegaard', N'Credit', 0x00EE9549C5194043B47881425468B99A0200000098A462FD1A44640DE615BE5F6AE090DF48BE6E7EBF792BBAFDD9AC40E5A2B2F31A721E4CE1CF6A71450022904BCD9114, 10, 2025)
GO


-----------------------------customer-----------------------------------
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C001', N'John', N'Jacob', N'jj12@yahoo.com', N'9991276840', N'Male', CAST(N'1985-08-10T00:00:00.000' AS DateTime), 14, CAST(N'2020-08-10T11:30:05.587' AS DateTime), CAST(N'2020-08-10T11:30:05.587' AS DateTime), 3, N'M002')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C002', N'Lily', N'Tsu', N'lily32@yahoo.co.in', N'9876452713', N'Female', CAST(N'1997-09-04T00:00:00.000' AS DateTime), 10, CAST(N'2020-08-10T11:30:05.587' AS DateTime), CAST(N'2020-08-10T11:30:05.587' AS DateTime), 5, N'M001')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C003', N'Mary', N'Lu', N'Lmary@gmail.com', N'7833127463', N'Female', CAST(N'1981-02-03T00:00:00.000' AS DateTime), 12, CAST(N'2020-08-10T11:30:27.067' AS DateTime), CAST(N'2020-08-10T11:30:27.067' AS DateTime), 6, N'M003')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C004', N'Milton', N'Musk', N'milton_cool@yahoo.com', N'9091927681', N'Male', CAST(N'1956-08-10T00:00:00.000' AS DateTime), 5, CAST(N'2020-08-10T11:30:47.463' AS DateTime), CAST(N'2020-08-10T11:30:47.463' AS DateTime), 8, N'M004')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C005', N'Ryan', N'Hudson', N'Ryan_boy@gmail.com', N'7764532871', N'Male', CAST(N'1992-05-01T00:00:00.000' AS DateTime), 2, CAST(N'2020-08-10T11:30:27.080' AS DateTime), CAST(N'2020-08-10T11:30:27.080' AS DateTime), 10, N'M001')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C006', N'Ronald', N'Koemon', N'RonaldK_09@yahoo.co.in', N'7769843510', N'Male', CAST(N'1981-05-18T00:00:00.000' AS DateTime), 7, CAST(N'2020-08-10T11:30:33.767' AS DateTime), CAST(N'2020-08-10T11:30:33.767' AS DateTime), 9, N'M002')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C007', N'Aditya', N'Jumani', N'adi_cool@yahoo.com', N'9091927684', N'Male', CAST(N'1986-08-10T00:00:00.000' AS DateTime), 1, CAST(N'2020-08-10T11:30:40.567' AS DateTime), CAST(N'2020-08-10T11:30:40.567' AS DateTime), 1, N'M001')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C008', N'Jina', N'Kumar', N'jin_cool@yahoo.com', N'9791927684', N'Male', CAST(N'1996-08-10T00:00:00.000' AS DateTime), 2, CAST(N'2020-08-10T11:30:40.567' AS DateTime), CAST(N'2020-08-10T11:30:40.567' AS DateTime), 2, N'M001')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C009', N'Yahum', N'Mani', N'mani_cool@yahoo.com', N'8098927684', N'Male', CAST(N'1986-08-10T00:00:00.000' AS DateTime), 3, CAST(N'2020-08-10T11:30:40.567' AS DateTime), CAST(N'2020-08-10T11:30:40.567' AS DateTime), 4, N'M002')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C010', N'Bilal', N'Shaikh', N'BS_91@yahoo.com', N'9091947084', N'Male', CAST(N'1966-08-10T00:00:00.000' AS DateTime), 4, CAST(N'2020-08-10T11:30:47.463' AS DateTime), CAST(N'2020-08-10T11:30:47.463' AS DateTime), 7, N'M004')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C011', N'Nestor', N'Carbonell', N'nestor_carbonell87@gmail.com', N'8746537264', N'Male', CAST(N'1965-03-23T00:00:00.000' AS DateTime), 15, CAST(N'2020-08-10T11:45:51.033' AS DateTime), CAST(N'2020-08-10T11:45:51.033' AS DateTime), 11, N'M003')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C012', N'King', N'James', N'james_k@yahoo.com', N'763586544', N'Male', CAST(N'1972-10-08T00:00:00.000' AS DateTime), 6, CAST(N'2020-08-10T11:45:51.033' AS DateTime), CAST(N'2020-08-10T11:45:51.033' AS DateTime), 12, N'M002')
GO
INSERT [dbo].[Customer] ([CustomerID], [FirstName], [LastName], [Email], [PhoneNumber], [Gender], [DOB], [LocationID], [CreationDate], [ModifiedDate], [CardID], [MembershipID]) VALUES (N'C013', N'Martin', N'Odegaard', N'odegaard@yahoo.co.in', N'8354670854', N'Male', CAST(N'1992-02-12T00:00:00.000' AS DateTime), 10, CAST(N'2020-08-10T11:45:51.033' AS DateTime), CAST(N'2020-08-10T11:45:51.033' AS DateTime), 13, N'M004')
GO

------------------CustomerCare Office------------------------

INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(541) 754-3010', N'ccareoffice2000@OnlineService.Com', N'+1 143 555 1234', CAST(N'2000-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(342) 122-6724', N'ccareoffice2002@OnlineService.Com', N'+1 456 666 3256', CAST(N'2002-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(987) 784-7009', N'ccareoffice2005@OnlineService.Com', N'+1 765 311 8456', CAST(N'2005-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(345) 889-6743', N'ccareoffice2005@OnlineService.Com', N'+1 543 342 1257', CAST(N'2005-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(787) 766-7891', N'ccareoffice2009@OnlineService.Com', N'+1 876 655 8916', CAST(N'2009-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(672) 788-7890', N'ccareoffice2010@OnlineService.Com', N'+1 468 876 4536', CAST(N'2010-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(196) 786-4532', N'ccareoffice2010@OnlineService.Com', N'+1 643 978 7589', CAST(N'2010-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(985) 655-7131', N'ccareoffice2010@OnlineService.Com', N'+1 256 908 6954', CAST(N'2010-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES (N'(344) 754-7846', N'ccareoffice2014@OnlineService.Com', N'+1 877 366 8531', CAST(N'2014-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[CustomerCareOffice] ([OfficeTelNo], [OfficeEmail], [OfficeFaxNo], [CreationDate]) VALUES ( N'(785) 688-0987', N'ccareoffice2015@OnlineService.Com', N'+1 988 677 4516', CAST(N'2015-01-01T00:00:00.000' AS DateTime))
GO


GO
--employee
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1000', N'Harvey', N'Specter', N'hsrules@yahoo.com', N'Vice President', CAST(N'2000-02-01T00:00:00.000' AS DateTime), NULL, 1, 50000, CAST(N'2000-02-01T00:00:00.000' AS DateTime), CAST(N'2019-04-14T00:00:00.000' AS DateTime), CAST(N'1975-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1001', N'Bob', N'Desa', N'desaBob@yahoo.com', N'Area Manager', CAST(N'2001-03-03T00:00:00.000' AS DateTime), N'E1000', 1, 25000, CAST(N'2001-03-03T00:00:00.000' AS DateTime), CAST(N'2019-02-15T00:00:00.000' AS DateTime), CAST(N'1977-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1002', N'Smith', N'Fernandes', N'Smith132@rediffmail.com', N'Area Manager', CAST(N'2001-05-04T00:00:00.000' AS DateTime), N'E1000', 1, 25000, CAST(N'2001-05-04T00:00:00.000' AS DateTime), CAST(N'2019-02-01T00:00:00.000' AS DateTime), CAST(N'1977-04-12' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1003', N'Mark', N'Litt', N'markLi@gmail.com', N'ProductManager', CAST(N'2000-06-05T00:00:00.000' AS DateTime), N'E1001', 2, 25000, CAST(N'2000-06-05T00:00:00.000' AS DateTime), CAST(N'2019-04-18T00:00:00.000' AS DateTime), CAST(N'1978-04-09' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1004', N'Mike', N'Pearson', N'pearsonMiky@', N'Product Manager', CAST(N'2000-07-06T00:00:00.000' AS DateTime), N'E1002', 2, 25000, CAST(N'2000-07-06T00:00:00.000' AS DateTime), CAST(N'2017-02-17T00:00:00.000' AS DateTime), CAST(N'1993-04-08' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1005', N'Richard', N'Nicolas', N'nickrich12@yahoo.com', N'Service Executive', CAST(N'2002-07-23T00:00:00.000' AS DateTime), N'E1003', 2, 20000, CAST(N'2002-07-23T00:00:00.000' AS DateTime), CAST(N'2018-04-15T00:00:00.000' AS DateTime), CAST(N'1983-04-08' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1006', N'Mary', N'Smith', N'mary786@gmail.com', N'Service Executive', CAST(N'2005-08-23T00:00:00.000' AS DateTime), N'E1004', 2, 20000, CAST(N'2005-08-23T00:00:00.000' AS DateTime), CAST(N'2017-02-16T00:00:00.000' AS DateTime), CAST(N'1993-04-11' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1007', N'William', N'Periera', N'willspw@gmail.com', N'Service Executive', CAST(N'2005-08-31T00:00:00.000' AS DateTime), N'E1004', 3, 20000, CAST(N'2005-08-31T00:00:00.000' AS DateTime), CAST(N'2018-03-01T00:00:00.000' AS DateTime), CAST(N'1993-04-11' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1008', N'Jack', N'Wilis', N'jackky124@yahoo.com', N'Admin Executive', CAST(N'2005-09-01T00:00:00.000' AS DateTime), N'E1006', 3, 15000, CAST(N'2005-09-01T00:00:00.000' AS DateTime), CAST(N'2017-02-16T00:00:00.000' AS DateTime), CAST(N'1978-04-12' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1009', N'Robin', N'Louis', N'louisrob@gmail.com', N'Admin Executive', CAST(N'2005-02-05T00:00:00.000' AS DateTime), N'E1006', 3, 15000, CAST(N'2005-02-05T00:00:00.000' AS DateTime), CAST(N'2018-04-09T00:00:00.000' AS DateTime), CAST(N'1978-04-11' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1010', N'Richards', N'Dan', N'richdanny123@gmail.com', N'Admin Executive', CAST(N'2006-03-06T00:00:00.000' AS DateTime), N'E1007', 4, 15000, CAST(N'2006-03-06T00:00:00.000' AS DateTime), CAST(N'2000-02-07T00:00:00.000' AS DateTime), CAST(N'1983-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1011', N'Steven', N'Poulla', N'poulla778@yahoo.com', N'Delivery Executive', CAST(N'2007-04-12T00:00:00.000' AS DateTime), N'E1007', 4, 10000, CAST(N'2007-04-12T00:00:00.000' AS DateTime), CAST(N'2017-03-12T00:00:00.000' AS DateTime), CAST(N'2000-04-15' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1012', N'Samuels', N'Jenny', N'samuels8@gmail.com', N'Delivery Executive', CAST(N'2007-05-15T00:00:00.000' AS DateTime), N'E1006', 4, 10000, CAST(N'2007-05-15T00:00:00.000' AS DateTime), CAST(N'2018-03-01T00:00:00.000' AS DateTime), CAST(N'1978-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1013', N'Simon', N'Silvester', N'simonzone@gmail.com', N'Delivery Executive', CAST(N'2008-05-16T00:00:00.000' AS DateTime), N'E1006', 5, 10000, CAST(N'2008-05-16T00:00:00.000' AS DateTime), CAST(N'2015-02-16T00:00:00.000' AS DateTime), CAST(N'1993-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1014', N'Jaden', N'Maroon', N'jaden121@gmail.com', N'Delivery Executive', CAST(N'2008-06-30T00:00:00.000' AS DateTime), N'E1006', 5, 10000, CAST(N'2008-06-30T00:00:00.000' AS DateTime), CAST(N'2015-02-01T00:00:00.000' AS DateTime), CAST(N'2000-04-12' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1015', N'Cole', N'Vaz', N'colevazcc@yahoo.com', N'Delivery Executive', CAST(N'2009-07-11T00:00:00.000' AS DateTime), N'E1011', 6, 10000, CAST(N'2009-07-11T00:00:00.000' AS DateTime), CAST(N'2017-03-18T00:00:00.000' AS DateTime), CAST(N'1999-04-12' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1016', N'Carry', N'Hendry', N'carrychendry@gmail.com', N'Delivery Executive', CAST(N'2010-08-23T00:00:00.000' AS DateTime), N'E1011', 6, 10000, CAST(N'2010-08-23T00:00:00.000' AS DateTime), CAST(N'2018-02-12T00:00:00.000' AS DateTime), CAST(N'1997-04-16' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1017', N'Collin', N'Zane', N'zanethecollins@gmail.com', N'Delivery Executive', CAST(N'2010-08-29T00:00:00.000' AS DateTime), N'E1011', 7, 10000, CAST(N'2010-08-29T00:00:00.000' AS DateTime), CAST(N'2017-02-15T00:00:00.000' AS DateTime), CAST(N'1999-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1018', N'Ricky', N'Ross', N'rossricky776@gmail', N'Delivery Executive', CAST(N'2012-04-02T00:00:00.000' AS DateTime), N'E1012', 8, 10000, CAST(N'2012-04-02T00:00:00.000' AS DateTime), CAST(N'2015-02-01T00:00:00.000' AS DateTime), CAST(N'1984-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1019', N'Danny', N'Specter', N'dannydspecter@gmail.com', N'Delivery Executive', CAST(N'2012-05-05T00:00:00.000' AS DateTime), N'E1012', 9, 10000, CAST(N'2012-05-05T00:00:00.000' AS DateTime), CAST(N'2015-02-14T00:00:00.000' AS DateTime), CAST(N'2000-04-14' AS Date))
GO
INSERT [dbo].[Employee] ([EmployeeID], [EmpFName], [EmpLName], [WorkEmail], [Designation], [JoiningDate], [ManagerID], [CCOfficeID], [Salary], [CreationDate], [ModifiedDate], [DOB]) VALUES (N'E1020', N'John', N'Richardson', N'johnRichard112@gmail.com', N'Delivery Executive', CAST(N'2014-06-23T00:00:00.000' AS DateTime), N'E1012', 10, 10000, CAST(N'2014-06-23T00:00:00.000' AS DateTime), CAST(N'2015-03-20T00:00:00.000' AS DateTime), CAST(N'2001-04-14' AS Date))
GO


--delivery executive
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1011', 2, 1, 79)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1012', 12, 0, 68)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1013', 6, 1, 70)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1014', 16, 0, 88)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1015', 10, 0, 90)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1016', 8, 0, 90)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1017', 4, 1, 68)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1018', 14, 1, 99)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1019', 18, 1, 57)
GO
INSERT [dbo].[DeliveryExecutive] ([EmployeeID], [LocationID], [CurrentAvailabilityStatus], [NumOfSuccessfulOrder]) VALUES (N'E1020', 20, 0, 68)
GO


INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'john.jacob', 0x00EE9549C5194043B47881425468B99A0200000032C3393FC089ACA5C2A5A44AA80EDF0BF40436D1B9FBE431D1C1C47E476946A39EB34F5FDC70758EF7A09A8155F85734, N'What primary school did you attend?', N'San Marino United School', N'In what town or city was your first full time job?', N'Natick', N'C001', CAST(N'2020-08-10T13:06:31.140' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'lily.tsu', 0x00EE9549C5194043B47881425468B99A02000000937640575D6A508A96E7DEF8F614626E4867611362556F6B612D5CD07AB3576F4957D83DAA6C2B040187D39D84843F02, N'What is your  mother''s maiden name?', N'Logan', N'In what town or city was your first full time job?', N'New York', N'C002', CAST(N'2020-08-10T13:06:31.160' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'mary.lu45', 0x00EE9549C5194043B47881425468B99A02000000A2B087AA6AC98B0DF3CB13BEB86B9A78EECCA381B910E83A17D691F3A602707110D815EF89C68C8F8D8B149221C57F3F, N'What were the last four digits of your childhood telephone number?', N'4589', N'In what town or city was your first full time job?', N'Houston', N'C003', CAST(N'2020-08-10T13:06:31.160' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'milton.musk', 0x00EE9549C5194043B47881425468B99A0200000013EE9E8DF214DE4C17650CF9912F06AF5E2D9114158B7875AB8084C6CF766EB7689F52736C1FEEBDD992ADE38982D53E, N'What were the last four digits of your childhood telephone number?', N'5558', N'In what town or city was your first full time job?', N'Los Angeles', N'C004', CAST(N'2020-08-10T13:06:31.160' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'ryan.hudson', 0x00EE9549C5194043B47881425468B99A020000007AA5F651EA22E70EEFD331DDE05B11A83BF340D116AB8E532EE4969C9AB17C98BC8E8797BD14FCE9E9E9AB5CC1E2F008, N'What primary school did you attend?', N'Chelmsford Primary School', N'In what town or city was your first full time job?', N'Chelmsford', N'C005', CAST(N'2020-08-10T13:06:31.160' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'ronald.koeman55', 0x00EE9549C5194043B47881425468B99A02000000214E76161AB171607F015FCC642F0E10D34C861DB63059B1F9E338E3568B1A9726E3FD276B616ACA611FAFA280C50B2C, N'What primary school did you attend?', N'Woburn Street School', N'In what town or city was your first full time job?', N'Woburn', N'C006', CAST(N'2020-08-10T13:06:31.160' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'aditya.jumani', 0x00EE9549C5194043B47881425468B99A02000000BC7BAB0E7D7FA4FA455850B66D04000EA8A78F0712EA8E4ACA4FD3BCD686CE1BF79A71E647DE80B59C13F38282202BF3, N'What primary school did you attend?', N'Boston Primary School', N'In what town or city was your first full time job?', N'Burlington', N'C007', CAST(N'2020-08-10T13:06:31.173' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'jina.kumar11', 0x00EE9549C5194043B47881425468B99A0200000037EC162E03322B012DE6971AD3E62BFE97F5891A28D592A6015C7CB22DDBAFBF9C32C2458B6CD8AD146E91ED121EA20A, N'What primary school did you attend?', N'Belmont Day Lower School', N'What is your  mother''s maiden name?', N'Elisa', N'C008', CAST(N'2020-08-10T13:06:31.173' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES (N'yahum.mani', 0x00EE9549C5194043B47881425468B99A0200000004C2685F51AA74481A447522A200963C0E150244D9E17D08A87E775E2F8CE6F0BD3A0205B11BD6F37757ADAB407C62BD, N'What is your  mother''s maiden name?', N'Sarah', N'In what town or city was your first full time job?', N'Atlanta', N'C009', CAST(N'2020-08-10T13:06:31.173' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'bilal.shaikh', 0x00EE9549C5194043B47881425468B99A02000000748A66527A9D9626B9953B514B0D19C18CBB8263AE484F615AE6E3A2E32E16B831BB0878FD75B4F270FEE8BB4DE47B4E, N'What were the last four digits of your childhood telephone number?', N'1258', N'In what town or city was your first full time job?', N'Chicago', N'C010', CAST(N'2020-08-10T13:06:31.190' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'nestor.carbonell', 0x00EE9549C5194043B47881425468B99A02000000FAD862EE98030052C791A1F9DCDE0CFADB546176DECC794FF4FF4939D911F219E005D3E7119805BB49343DE399467E42, N'What primary school did you attend?', N'Hiliard Primary School', N'In what town or city was your first full time job?', N'Burlington', N'C011', CAST(N'2020-08-10T13:06:31.190' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'king.james', 0x00EE9549C5194043B47881425468B99A02000000E6893555C400BCB99FDBEED3BA8599D41F30F34C722BA47310D8C6CCCE075C81965335A56DF070D9D35215570FBB2F44, N'What primary school did you attend?', N'Fermont Day Lower School', N'What is your  mother''s maiden name?', N'Jesica', N'C012', CAST(N'2020-08-10T13:06:31.190' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'martin.odegaard', 0x00EE9549C5194043B47881425468B99A020000009A3DF37D02B938930C3BC6B62D359F0E7A52A39BE0A30EA38B5D89D018BFF439EEC1FD3BE8D1E4A3BA96A9DF2CEAEA0C, N'What primary school did you attend?', N'Little Harbor United School', N'In what town or city was your first full time job?', N'Alaska', N'C013', CAST(N'2020-08-10T13:06:31.203' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'harvey.specter', 0x00EE9549C5194043B47881425468B99A0200000065FCB5BF3B5771148712C3068D36FF5F71ED90D4052421A858C1C8B2AE33701A74A1B30E6A8BD9B83CFEC33768BFF954, N'What is your  mother''s maiden name?', N'', N'In what town or city was your first full time job?', N'Florence', N'E1000', CAST(N'2020-08-10T13:06:31.203' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'bob.desa', 0x00EE9549C5194043B47881425468B99A0200000025CBA1584E6E3DAD3D9837120D03328ED418117E3A39FD0CE8E1C83C4653B849F9EAA11D0F9B78F3D77D25EE36E92ED3, N'What is your  mother''s maiden name?', N'', N'In what town or city was your first full time job?', N'Arcadia', N'E1001', CAST(N'2020-08-10T13:06:31.203' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'smith.fernandes', 0x00EE9549C5194043B47881425468B99A0200000082C66C90787394115ED8B3E22BC7B0F8A9189DBB1C3FE46E7FD8FA3042C29439D073EEF21EAEF848151B755B56CDD737, N'What were the last four digits of your childhood telephone number?', N'4455', N'In what town or city was your first full time job?', N'Denver', N'E1002', CAST(N'2020-08-10T13:06:31.203' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'mark.litt', 0x00EE9549C5194043B47881425468B99A02000000F56379570A729FF7EA03AA64F43BB3AC802152316F5991103C9395C43BF39C25FFB5B07172EA2A5C22E095D0774AC0FC, N'What were the last four digits of your childhood telephone number?', N'7854', N'In what town or city was your first full time job?', N'Berlin', N'E1003', CAST(N'2020-08-10T13:06:31.203' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'mike.pearson', 0x00EE9549C5194043B47881425468B99A020000009098E381374DAD9DF880FCCB14214941A3B72E988FDC575604810BAA01682D43D7C894640A15F521465B66C74D6057E6, N'What were the last four digits of your childhood telephone number?', N'2563', N'In what town or city was your first full time job?', N'Greenwich', N'E1004', CAST(N'2020-08-10T13:06:31.220' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'richard.nicolas', 0x00EE9549C5194043B47881425468B99A020000002A3931FCE3A6591B38267C92DFF96BEE2F5C776C4EBF76B05EB5FE0C0B226D72B5323D816E22A1197BCB9C53E7CE09A6, N'What primary school did you attend?', N'Woburn Street School', N'In what town or city was your first full time job?', N'Norwalk', N'E1005', CAST(N'2020-08-10T13:06:31.220' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'mary.smith', 0x00EE9549C5194043B47881425468B99A02000000A8052297E5A3E9B55157B0E669E4EF35663552901AE6AEFAA40F729E0152FC904BDE785A6CC8A38E4F91318C6C98A915, N'What primary school did you attend?', N'Chelmsford Primary School', N'In what town or city was your first full time job?', N'Lake City', N'E1006', CAST(N'2020-08-10T13:06:31.220' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'william.periera', 0x00EE9549C5194043B47881425468B99A020000000E27B8DB1B9E7D55CCC2B45459E22E518429FD640714F4311C47DA72DFE50111E75DE0D712D473914AE85062B7EE9D21, N'What primary school did you attend?', N'Little Flower', N'In what town or city was your first full time job?', N'San Francisco', N'E1007', CAST(N'2020-08-10T13:06:31.220' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'Jack.Wilis', 0x00EE9549C5194043B47881425468B99A02000000443A2FC3AF7744697449B9C872DBD191C3DB5AA7E5716033788544FF383ABC9C160FF1782CA0C0325F3ACD0A78DE600B, N'What primary school did you attend?', N'Maple Elementary School', N'In what town or city was your first full time job?', N'Fullerton', N'E1008', CAST(N'2020-08-10T13:06:31.237' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'Robin.Louis', 0x00EE9549C5194043B47881425468B99A020000001650F7C3C5B50843E99E79F26918D66C99D949CD8FE2C6A02DDF0AF13C2DE03044DF0F9CD9E85F52E8F100FAE0834470, N'What primary school did you attend?', N'Maple Elementary School', N'In what town or city was your first full time job?', N'Fullerton', N'E1009', CAST(N'2020-08-10T13:06:31.237' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'Richard.Dan', 0x00EE9549C5194043B47881425468B99A020000000BB6CFD1E57CD5C19A554B8F32CAE08742C99C4AC8221465A0E94346107503E6, N'What primary school did you attend?', N'Woburn Primary School', N'In what town or city was your first full time job?', N'Woburn', N'E1010', CAST(N'2020-08-10T13:06:31.237' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'Steven.Poulla', 0x00EE9549C5194043B47881425468B99A0200000093382D1984471D3C0D61EDF1FBE76D9F822D57018C6CFCBE1B35BEEF774C6D83CE5DB50ACE8F96C74F6EA6F285F0A275, N'What primary school did you attend?', N'Burlington Elementary School', N'In what town or city was your first full time job?', N'Burlington', N'E1011', CAST(N'2020-08-10T13:06:31.237' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'samuels.jenny', 0x00EE9549C5194043B47881425468B99A020000007BE95A46A0CB12DCBAAE65E8C063F0C9679BC48AAA8D8722CB441F815E70B29A, N'What primary school did you attend?', N'Burlington Elementary School', N'In what town or city was your first full time job?', N'Burlington', N'E1012', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'simon.silvester', 0x00EE9549C5194043B47881425468B99A020000005CF9B7567E961887E553C784D5653C734112DD7CB7DF999BE75B3360D409A2049A2F8ADE8ABE31B801DC0D63A958018E, N'What primary school did you attend?', N'Alabama Elementary School', N'In what town or city was your first full time job?', N'Alabama', N'E1013', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'jaden.maroon', 0x00EE9549C5194043B47881425468B99A02000000B811F3178E594242ED975A5892ABFE56B9F82A3F81251835846477AC722C1AE175C291051331C5B5A1BA7DDFEFA7524E, N'What is your  mother''s maiden name?', N'Lisa', N'In what town or city was your first full time job?', N'Houston', N'E1014', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'cole.vaz', 0x00EE9549C5194043B47881425468B99A0200000047AE5E3951E62C41B383600E573D084AB97C7CE0B5448ABC591EDF67454B2183D83624B94B6FA98E4AA95243EF5D5E06, N'What is your  mother''s maiden name?', N'Feriha', N'In what town or city was your first full time job?', N'Austin', N'E1015', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'carry.hendry', 0x00EE9549C5194043B47881425468B99A02000000EA6088937BC371B0C3ADE7998BB42EE0C472C28D2CEDAE685529BC24923B40B2DB88BDC942EA43F99316CD5D755A2734, N'What is your  mother''s maiden name?', N'Linda', N'In what town or city was your first full time job?', N'Austin', N'E1016', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'collin.zane', 0x00EE9549C5194043B47881425468B99A0200000058CF4E811ACED21D4D65653C0A0560D5371B3657FE8783AA5D4F1E30FCC9FDE783BD720EF590DBD6481456DD54607BAD, N'What is your  mother''s maiden name?', N'Barbara', N'In what town or city was your first full time job?', N'Seattle', N'E1017', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'ricky.ross', 0x00EE9549C5194043B47881425468B99A020000009F8706E33969BC10951DF52034469B01728FE2802C7E3AB7E3F4FB38B96E20C667243FEFA4723ACAD596351537CB66A4, N'What is your  mother''s maiden name?', N'Patrica', N'In what town or city was your first full time job?', N'Seattle', N'E1018', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'danny.specter', 0x00EE9549C5194043B47881425468B99A020000003F924872FBFF7F8CE83DDF93A02B6C0CF0AEA8844A855F3943A7A39A8A6F2A81196470C304757E4845C5E080DB2CD5D8, N'What is your  mother''s maiden name?', N'Mary', N'In what town or city was your first full time job?', N'Boston', N'E1019', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO
INSERT [dbo].[Login] ([UserName], [Password], [SecurityQues1], [SecurityAns1], [SecurityQues2], [SecurityAns2], [BusinessEntityID], [CreationDate]) VALUES ( N'john.richardson', 0x00EE9549C5194043B47881425468B99A02000000E5711848C595C395AEF79234BF464D76F8775F4C4B63BC595BEFA6A6D91004ED6FF05EBA300F05338B15BE31470BD055, N'What is your  mother''s maiden name?', N'Ela', N'In what town or city was your first full time job?', N'Boston', N'E1020', CAST(N'2020-08-10T13:06:31.250' AS DateTime))
GO


-----------------------Product-------------------------------------


INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Dove Deep Moisture Shower Foam', N'Shower Foam', N'Each      ', N'N', CAST(5 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Dove Deep Moisture Shower Foam', N'Shower Foam', N'Each      ', N'N', CAST(5 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Dove Gentle Exfoliating Beauty Bar', N'Beauty Bar', N'Each      ', N'N', CAST(4 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Scott Choose-A-Sheet White Mega Roll Paper Towels', N'Paper Towel', N'Each      ', N'N', CAST(40 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Classico Pasta Sauce - Tomato & Basil', N'Pasta Sauce', N'Each      ', N'N', CAST(24 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Classico Pizza Sauce', N'Pizza Sauce', N'Each      ', N'N', CAST(14 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'Frito Lay Classic Mix', N'Snack Mix', N'Each      ', N'N', CAST(18 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Product] ([PRODUCTName], [ProductDescription], [ProductSalesUoM], [Hazmat], [ProductWeightByOz], [CreationDate]) VALUES (N'SHRIMP TACO', N'Tacos', N'Each      ', N'N', CAST(18 AS Decimal(18, 0)), CAST(N'2020-08-10' AS Date))
GO


-----------------------Store--------------------------


INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Shoprite', 4, N'2135238963', N'ccare@shoprite.com', N'2135238963', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Walmart', 6, N'2135238985', N'ccare@walmart.com', N'2135238985', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Target', 2, N'3128568956', N'support@target.com', N'3128568956', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Walgreens', 8, N'2453659832', N'care@walgreens.com', N'2453659832', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Chipotle', 18, N'2258258899', N'support@chipotle.com', N'2258258899', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Subway', 6, N'2245639876', N'support@subway.com', N'2245639876', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'CVS', 6, N'2245639877', N'care@cvs.com', N'2245639877', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Starbucks', 6, N'2245639878', N'support@starbucks.com', N'2245639878', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Dunkin Donuts', 6, N'2245639879', N'care@dunkindonuts.com', N'2245639879', CAST(N'2020-08-10' AS Date))
GO
INSERT [dbo].[Store] ([StoreName], [LocationID], [PhoneNumber], [Email], [FaxNo], [CreationDate]) VALUES (N'Buffalo Wild Wings', 6, N'2245639880', N'support@bdubs.com', N'2245639880', CAST(N'2020-08-10' AS Date))
GO

-----------------------Catalog---------------------------------------
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT100', N'Catalog1', N'Cosmetic', N'Cosmetic products', 500.0000, 1000, 50000, 0, N'PROMO2', CAST(N'2020-08-10T12:24:32.757' AS DateTime), N'No   ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Cosmetic', N'Cosmetic products', 500.0000, 1000, 50002, 100, NULL, CAST(N'2020-08-10T17:59:23.220' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog13', N'Cosmetic', N'Cosmetic products', 650.0000, 1000, 50001, 1200, NULL, CAST(N'2020-08-10T18:00:40.780' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1000, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:03:23.427' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Cosmetic', N'Cosmetic products', 500.0000, 1000, 50003, 100, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Cosmetic', N'Cosmetic products', 500.0000, 1001, 50002, 1010, NULL, CAST(N'2020-08-10T17:59:23.237' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog13', N'Vegetables', N'Veg Products', 300.0000, 1001, 50001, 1000, NULL, CAST(N'2020-08-10T18:03:14.657' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1001, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:05:45.020' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Cosmetic', N'Cosmetic products', 500.0000, 1001, 50003, 1010, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Cosmetic', N'Cosmetic products', 500.0000, 1002, 50002, 500, NULL, CAST(N'2020-08-10T17:59:23.237' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog13', N'Vegetables', N'Veg Products', 600.0000, 1002, 50001, 1200, NULL, CAST(N'2020-08-10T18:03:52.853' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1002, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:05:45.020' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Cosmetic', N'Cosmetic products', 500.0000, 1002, 50003, 500, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Cosmetic', N'Cosmetic products', 500.0000, 1003, 50002, 10, NULL, CAST(N'2020-08-10T17:59:23.237' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog14', N'Vegetables', N'Veg Products', 800.0000, 1003, 50001, 1300, NULL, CAST(N'2020-08-10T18:04:57.390' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1003, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:05:45.020' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Cosmetic', N'Cosmetic products', 500.0000, 1003, 50003, 10, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT110', N'Catalog10', N'Cafes', N'Icecream sundaes, donuts', 500.0000, 1004, 50007, 50, NULL, CAST(N'2020-08-10T12:26:40.637' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Food', N'Food products', 500.0000, 1004, 50002, 700, NULL, CAST(N'2020-08-10T17:59:23.237' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog14', N'Food', N'Food Products', 900.0000, 1004, 50001, 1300, NULL, CAST(N'2020-08-10T18:05:30.633' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Food', N'Food Products', 5.2900, 1004, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:06:54.863' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Food', N'Food products', 500.0000, 1004, 50003, 700, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT100', N'Catalog1', N'Cosmetic', N'Cosmetic products', 1200.0000, 1005, 50000, 1090, NULL, CAST(N'2020-08-10T15:36:21.870' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT106', N'Catalog6', N'SuperMarket', N'Households and daily needs', 500.0000, 1005, 50004, 100, N'PROMO3', CAST(N'2020-08-10T12:24:32.767' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT107', N'Catalog7', N'SuperMarket', N'Households and daily needs', 500.0000, 1005, 50005, 100, N'PROMO3', CAST(N'2020-08-10T12:24:32.767' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Food', N' Food products', 500.0000, 1005, 50002, 170, NULL, CAST(N'2020-08-10T17:59:23.237' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog14', N'Food', N'Food Products', 1200.0000, 1005, 50001, 700, NULL, CAST(N'2020-08-10T18:05:56.210' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1005, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:06:54.863' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Food', N' Food products', 500.0000, 1005, 50003, 170, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT100', N'Catalog1', N'Cosmetic', N'Cosmetic products', 1900.0000, 1006, 50000, 190, NULL, CAST(N'2020-08-10T15:37:49.623' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT108', N'Catalog9', N'Groceries', N'Spices and sugar', 200.0000, 1006, 50006, 100, N'PROMO6', CAST(N'2020-08-10T12:24:32.767' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT110', N'Catalog10', N'Cafes', N'Icecream sundaes, donuts', 500.0000, 1006, 50007, 0, NULL, CAST(N'2020-08-10T12:33:59.437' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Food', N'Food products', 500.0000, 1006, 50002, 800, NULL, CAST(N'2020-08-10T17:59:23.250' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog14', N'Food', N'Food Products', 200.0000, 1006, 50001, 700, NULL, CAST(N'2020-08-10T18:06:22.043' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT114', N'Catalog14', N'Cosmetic', N'Cosmetic Products', 5.2900, 1006, 50000, 112, N'PROMO1', CAST(N'2020-08-10T18:06:54.863' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Food', N'Food products', 500.0000, 1006, 50003, 800, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT112', N'Catalog13', N'Food', N'Food products', 500.0000, 1007, 50002, 1980, NULL, CAST(N'2020-08-10T17:59:23.250' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT113', N'Catalog14', N'Food', N'Food Products', 560.0000, 1007, 50001, 1700, NULL, CAST(N'2020-08-10T18:06:45.057' AS DateTime), N'Yes  ')
GO
INSERT [dbo].[Catalog] ([CatalogID], [CatalogName], [Category], [Description], [Price], [ProductID], [StoreID], [AvailableStock], [PromotionID], [CreationDate], [IsActive]) VALUES (N'CT117', N'Catalog17', N'Food', N'Food products', 500.0000, 1007, 50003, 1980, NULL, CAST(N'2020-08-10T18:07:57.683' AS DateTime), N'Yes  ')
GO


----------------------------Cart-------------------------------

INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (1, N'C001', 1000, N'CT100', 10, 500.0000, CAST(N'2020-08-10' AS Date), N'Active', 50000, CAST(N'2020-08-10T14:46:26.080' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (111, N'C001', 1004, N'CT110', 10, 500.0000, CAST(N'2020-08-10' AS Date), N'Active', 50007, CAST(N'2020-08-10T14:46:26.080' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (4, N'C001', 1004, N'CT110', 1, 500.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50007, CAST(N'2020-08-10T14:46:26.080' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (4, N'C001', 1006, N'CT110', 10, 500.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50007, CAST(N'2020-08-10T14:46:26.080' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1000, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:13:33.617' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 6, N'C006', 1000, N'CT112', 10, 500.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:13:35.320' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 6, N'C006', 1001, N'CT112', 10, 35.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:13:35.320' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 6, N'C006', 1002, N'CT112', 10, 520.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:13:35.320' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 6, N'C006', 1003, N'CT112', 10, 60.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:13:35.320' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 6, N'C006', 1004, N'CT112', 10, 1.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:13:35.320' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1000, N'CT113', 6, 750.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:13:39.340' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1001, N'CT114', 7, 35.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:14:54.093' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1003, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:14:54.093' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1004, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:14:54.093' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1005, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:14:54.093' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1006, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:14:54.093' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1001, N'CT113', 10, 35.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:16:04.517' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1002, N'CT113', 9, 1200.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:16:32.610' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1000, N'CT112', 10, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:16:38.260' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1002, N'CT112', 40, 220.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:16:38.260' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1003, N'CT112', 50, 20.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:16:38.273' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1006, N'CT112', 70, 160.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:16:38.273' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1007, N'CT112', 10, 13.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:16:38.273' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1003, N'CT113', 12, 100.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:17:00.493' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 10, N'C007', 1000, N'CT114', 7, 22.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:17:01.213' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 10, N'C007', 1001, N'CT114', 5, 35.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:17:01.213' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 10, N'C007', 1003, N'CT114', 8, 28.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:17:01.230' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 10, N'C007', 1004, N'CT114', 12, 85.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:17:01.230' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1004, N'CT113', 11, 120.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:17:21.120' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1005, N'CT113', 15, 85.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:17:33.483' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1006, N'CT113', 17, 145.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:17:52.640' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 5, N'C003', 1007, N'CT113', 14, 45.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:18:09.057' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1000, N'CT113', 7, 900.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1001, N'CT113', 4, 250.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1002, N'CT113', 6, 2500.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1003, N'CT113', 6, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1004, N'CT113', 8, 20.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1005, N'CT113', 9, 458.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1006, N'CT113', 10, 250.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 8, N'C004', 1007, N'CT113', 45, 425.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50001, CAST(N'2020-08-10T18:20:38.867' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1000, N'CT117', 10, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.667' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1001, N'CT117', 120, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.667' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1002, N'CT117', 40, 220.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.667' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1003, N'CT117', 50, 20.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.667' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1006, N'CT117', 70, 160.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.667' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 12, N'C011', 1007, N'CT117', 10, 13.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50003, CAST(N'2020-08-10T18:21:31.683' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1000, N'CT112', 10, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:38.630' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1002, N'CT112', 40, 220.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:38.630' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1003, N'CT112', 50, 20.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:38.630' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1006, N'CT112', 70, 160.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:38.630' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1007, N'CT112', 10, 13.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:38.630' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1000, N'CT112', 10, 300.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:44.040' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1002, N'CT112', 40, 220.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:44.040' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1003, N'CT112', 50, 20.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:44.040' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1006, N'CT112', 70, 160.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:44.040' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 9, N'C009', 1007, N'CT112', 10, 13.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50002, CAST(N'2020-08-10T18:21:44.040' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1000, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.717' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1001, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.717' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1003, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.717' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1004, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.717' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1005, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.717' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES ( 7, N'C005', 1006, N'CT114', 7, 29.0000, CAST(N'2020-08-10' AS Date), N'InActive', 50000, CAST(N'2020-08-10T18:45:13.730' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (15, N'C013', 1006, N'CT110', 10, 500.0000, CAST(N'2020-08-11' AS Date), N'InActive', 50007, CAST(N'2020-08-11T09:00:06.280' AS DateTime))
GO
INSERT [dbo].[Cart] ( [CartId], [CustomerId], [ProductID], [CatalogID], [Quantity], [Price], [DateAdded], [Status], [StoreID], [CreationDate]) VALUES (15, N'C013', 1004, N'CT110', 3, 50.0000, CAST(N'2020-08-11' AS Date), N'InActive', 50007, CAST(N'2020-08-11T09:00:44.903' AS DateTime))
GO


------------------------------OrderHeader-------------------------


INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-10' AS Date), N'Open', CAST(N'2020-08-10' AS Date), N'E1011', 10)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-10-08' AS Date), N'Open', CAST(N'2020-10-08' AS Date), N'E1012', 8)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-10' AS Date), N'Open', CAST(N'2020-08-10' AS Date), N'E1012', 12)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-10' AS Date), N'Open', CAST(N'2020-08-10' AS Date), N'E1011', 7)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-10' AS Date), N'Open', CAST(N'2020-08-10' AS Date), N'E1011', 6)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-11' AS Date), N'Open', CAST(N'2020-08-11' AS Date), N'E1011', 5)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-11' AS Date), N'Open', CAST(N'2020-08-11' AS Date), N'E1011', 4)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-11' AS Date), N'Open', CAST(N'2020-08-11' AS Date), N'E1011', 9)
GO
INSERT [dbo].[OrderHeader] ( [OrderDate], [OrderStatus], [OrderCompletionDate], [EmployeeID], [CartId]) VALUES ( CAST(N'2020-08-11' AS Date), N'Open', CAST(N'2020-08-11' AS Date), N'E1011', 15)
GO


-----------------------Invoice------------------------------------

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I001', 101  , CAST('2020-10-08' as date), Getdate())

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES (  'I002', 102  , CAST('2020-08-10' as date), Getdate())

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I003',  103  , CAST('2020-08-10' as date), Getdate())

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I004',  104  , CAST('2020-08-10' as date), Getdate())

INSERT INTO Invoice (InvoiceID,OrderID, InvoiceDate, CreationDate) VALUES ( 'I005',  100  , CAST('2020-08-10' as date), Getdate())

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I006',  105  , CAST('2020-08-11' as date), Getdate())

INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I007',  106  , CAST('2020-08-11' as date), Getdate())
INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I008',  107  , CAST('2020-08-11' as date), Getdate())
INSERT INTO Invoice (InvoiceID, OrderID, InvoiceDate, CreationDate) VALUES ( 'I009',  108 , CAST('2020-08-11' as date), Getdate())


----------------------Payment-------------------------------


INSERT INTO Payment VALUES ('P001', 'I001', 'successful', 2,  CAST('2020-10-08' as date), Getdate());
INSERT INTO Payment VALUES ('P002','I002', 'successful', 1,  CAST('2020-08-10' as date), Getdate());
INSERT INTO Payment VALUES ('P003', 'I003', 'successful', 4,  CAST('2020-08-10' as date), Getdate());
INSERT INTO Payment VALUES ('P004','I004',  'successful', 3,  CAST('2020-08-10' as date), Getdate());
INSERT INTO Payment VALUES ('P005', 'I005',  'successful', 6,  CAST('2020-08-10' as date), Getdate());
INSERT INTO Payment VALUES ('P006', 'I006', 'successful', 5,  CAST('2020-08-11' as date), Getdate());
INSERT INTO Payment VALUES ('P007', 'I007', 'successful', 8,  CAST('2020-08-11' as date), Getdate()); --
INSERT INTO Payment VALUES ('P008', 'I008', 'successful', 7,  CAST('2020-08-11' as date), Getdate());
INSERT INTO Payment VALUES ('P009', 'I009', 'successful', 10,  CAST('2020-08-11' as date), Getdate());



------------------Feedback---------------------------------------

INSERT INTO Feedback VALUES ('Excellent Quality', 5, 100, CAST('2020-08-10' as date), Getdate());
INSERT INTO Feedback VALUES ('Poor Quality', 1, 102 , CAST('2020-08-10' as date), Getdate());
INSERT INTO Feedback VALUES ('Excellent Quality', 5,  103 , CAST('2020-08-10' as date), Getdate());
INSERT INTO Feedback VALUES ('Excellent Quality', 5, 104 , CAST('2020-08-10' as date), Getdate());
INSERT INTO Feedback VALUES ('Excellent Quality', 4, 101 , CAST('2020-10-08' as date), Getdate());
INSERT INTO Feedback VALUES ('Poor Quality', 0, 105 , CAST('2020-08-11' as date), Getdate());
INSERT INTO Feedback VALUES ('Excellent Quality', 5, 106 , CAST('2020-08-12' as date), Getdate());
INSERT INTO Feedback VALUES ('Excellent Quality', 4, 107 , CAST('2020-08-13' as date), Getdate());
INSERT INTO Feedback VALUES ('Mediocre Quality', 2, 108 , CAST('2020-08-14' as date), Getdate());


/*
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

------------------------------------------------------------------------------------------------------------------------------
*/