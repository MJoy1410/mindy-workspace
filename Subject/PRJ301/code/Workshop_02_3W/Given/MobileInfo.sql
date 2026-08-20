USE master;
GO

/* ------------------------------------------------------------
   1. Create Database
   ------------------------------------------------------------ */
IF DB_ID(N'MobileStore') IS NULL
BEGIN
    CREATE DATABASE MobileStore;
END
GO

USE MobileStore;
GO

/* ------------------------------------------------------------
   2. Drop tables if they already exist
   ------------------------------------------------------------ */
IF OBJECT_ID(N'dbo.Mobile', N'U') IS NOT NULL
    DROP TABLE dbo.Mobile;
GO

IF OBJECT_ID(N'dbo.[User]', N'U') IS NOT NULL
    DROP TABLE dbo.[User];
GO


/* ============================================================
   3. Create [User] table
   ============================================================ */

CREATE TABLE dbo.[User]
(
    [user]      varchar(35) NOT NULL,
    [password]  varchar(50) NOT NULL,
    fullName    varchar(50) NOT NULL,
    [role]      int         NULL,
    inUse       bit         NULL,

    CONSTRAINT PK_User PRIMARY KEY ([user]),

    CONSTRAINT CK_User_Role
        CHECK ([role] IN (0, 1, 2)),

    CONSTRAINT CK_User_InUse
        CHECK (inUse IN (0, 1))
);
GO


/* ============================================================
   4. Insert 25 Users
      role:
        0 = user
        1 = manager
        2 = staff

      inUse:
        0 = inactive
        1 = activated
   ============================================================ */

INSERT INTO dbo.[User]
    ([user], [password], fullName, [role], inUse)
VALUES
    ('annv', '1', 'Nguyen Van An',       0, 1),
    ('binhtt', '1', 'Tran Thi Binh',       0, 1),
    ('cuonglv', '1', 'Le Van Cuong',        0, 0),
    ('dungpt', '1', 'Pham Thi Dung',       0, 0),
    ('emhv', '1', 'Hoang Van Em',        0, 1),
    ('phuongvt', '1', 'Vo Thi Phuong',       0, 1),
    ('giangdv', '1', 'Dang Van Giang',      0, 0),
    ('hoabt', '1', 'Bui Thi Hoa',         0, 1),
    ('khangdv', '1', 'Do Van Khang',        0, 1),
    ('lannt', '1', 'Ngo Thi Lan',         0, 0),

    ('anhnm', '1', 'Nguyen Minh Anh',     2, 0),
    ('baotq', '2', 'Tran Quoc Bao',      2, 1),
    ('chault', '1', 'Le Thi Chau',        2, 1),
    ('duypv', '1', 'Pham Van Duy',       2, 0),
    ('gianght', '2', 'Hoang Thi Giang',    2, 1),
    ('haivt', '1', 'Vu Thanh Hai',       2, 0),
    ('kimdt', '1', 'Dang Thi Kim',       2, 1),
    ('longbv', '2', 'Bui Van Long',       2, 1),

    ('namhv', '1', 'Nguyen Hoang Nam',  1, 1),
    ('quantm', '2', 'Tran Minh Quan',    1, 1),
    ('huylq', '1', 'Le Quang Huy',      1, 0),
    ('sonpt', '2', 'Pham Thanh Son',    1, 1),
    ('tuanhm', '1', 'Hoang Minh Tuan',   1, 1),
    ('thangvd', '2', 'Vo Duc Thang',      1, 0),
    ('vietdq', '1', 'Dang Quoc Viet',    1, 1);
GO


/* ============================================================
   5. Create Mobile table
   ============================================================ */

CREATE TABLE dbo.Mobile
(
    mobileId        varchar(10)  NOT NULL,
    description     varchar(250) NOT NULL,
    price           float        NULL,
    mobileName      varchar(20)  NOT NULL,
    yearOfProduction int         NULL,
    quantity        int          NULL,
    outOfStock      bit          NULL,

    CONSTRAINT PK_Mobile PRIMARY KEY (mobileId),

    CONSTRAINT CK_Mobile_Year
        CHECK (yearOfProduction BETWEEN 2008 AND 2026),

    CONSTRAINT CK_Mobile_Quantity
        CHECK (quantity >= 0),

    CONSTRAINT CK_Mobile_OutOfStock
        CHECK (outOfStock IN (0, 1))
);
GO


/* ============================================================
   6. Insert 68 Mobile Products

   outOfStock:
       1 = out of stock
       0 = in stock
   ============================================================ */

INSERT INTO dbo.Mobile
    (mobileId, description, price, mobileName,
     yearOfProduction, quantity, outOfStock)
VALUES

/* ------------------------------------------------------------
   Apple
   ------------------------------------------------------------ */
('MOB001',
 'Apple smartphone with compact design and Retina display.',
 699.99, 'iPhone 6', 2014, 0, 1),

('MOB002',
 'Apple smartphone featuring improved performance and Retina HD display.',
 799.99, 'iPhone 7', 2016, 0, 1),

('MOB003',
 'Apple smartphone with Face ID and edge-to-edge OLED display.',
 999.99, 'iPhone X', 2017, 3, 0),

('MOB004',
 'Apple smartphone with A13 Bionic chip and dual camera system.',
 599.99, 'iPhone 11', 2019, 8, 0),

('MOB005',
 'Apple smartphone with 5G support and advanced dual camera.',
 799.99, 'iPhone 12', 2020, 6, 0),

('MOB006',
 'Apple smartphone with A15 Bionic chip and improved camera system.',
 699.99, 'iPhone 13', 2021, 10, 0),

('MOB007',
 'Apple smartphone with Dynamic Island and 48MP main camera.',
 899.99, 'iPhone 14', 2022, 7, 0),

('MOB008',
 'Apple smartphone with USB-C connectivity and titanium design.',
 999.99, 'iPhone 15', 2023, 12, 0),

('MOB009',
 'Apple smartphone with advanced camera system and A18 chip.',
 999.99, 'iPhone 16', 2024, 9, 0),

('MOB010',
 'Apple smartphone with latest generation performance and camera features.',
 1099.99, 'iPhone 17', 2025, 5, 0),

/* ------------------------------------------------------------
   Samsung
   ------------------------------------------------------------ */
('MOB011',
 'Samsung flagship smartphone with Super AMOLED display.',
 649.99, 'Galaxy S6', 2015, 0, 1),

('MOB012',
 'Samsung flagship smartphone with premium glass design.',
 749.99, 'Galaxy S8', 2017, 0, 1),

('MOB013',
 'Samsung flagship smartphone with Infinity Display and triple camera.',
 799.99, 'Galaxy S10', 2019, 2, 0),

('MOB014',
 'Samsung flagship smartphone with 5G support and high refresh rate display.',
 999.99, 'Galaxy S20', 2020, 4, 0),

('MOB015',
 'Samsung flagship smartphone with advanced camera and AMOLED display.',
 899.99, 'Galaxy S21', 2021, 6, 0),

('MOB016',
 'Samsung flagship smartphone with 108MP camera and premium design.',
 899.99, 'Galaxy S22', 2022, 8, 0),

('MOB017',
 'Samsung flagship smartphone featuring improved camera and performance.',
 999.99, 'Galaxy S23', 2023, 10, 0),

('MOB018',
 'Samsung flagship smartphone with Galaxy AI features.',
 1199.99, 'Galaxy S24', 2024, 7, 0),

('MOB019',
 'Samsung flagship smartphone with next generation Galaxy AI features.',
 1199.99, 'Galaxy S25', 2025, 9, 0),

('MOB020',
 'Samsung premium smartphone with large foldable display.',
 1799.99, 'Galaxy Fold5', 2023, 3, 0),

/* ------------------------------------------------------------
   Xiaomi
   ------------------------------------------------------------ */
('MOB021',
 'Xiaomi smartphone with affordable price and large display.',
 199.99, 'Redmi Note 5', 2018, 0, 1),

('MOB022',
 'Xiaomi smartphone with high capacity battery and dual camera.',
 249.99, 'Redmi Note 7', 2019, 4, 0),

('MOB023',
 'Xiaomi smartphone with AMOLED display and quad camera.',
 299.99, 'Redmi Note 9', 2020, 8,0),

('MOB024',
 'Xiaomi smartphone with 5G connectivity and high refresh rate.',
 329.99, 'Redmi Note 10', 2021, 10, 0),

('MOB025',
 'Xiaomi smartphone with AMOLED display and powerful processor.',
 349.99, 'Redmi Note 11', 2022, 7, 0),

('MOB026',
 'Xiaomi smartphone with high performance Snapdragon chipset.',
 399.99, 'Redmi Note 12', 2023, 9, 0),

('MOB027',
 'Xiaomi smartphone with high resolution camera and fast charging.',
 449.99, 'Redmi Note 13', 2024, 12, 0),

('MOB028',
 'Xiaomi smartphone with modern design and upgraded performance.',
 499.99, 'Redmi Note 14', 2025, 6, 0),

/* ------------------------------------------------------------
   OPPO
   ------------------------------------------------------------ */
('MOB029',
 'OPPO smartphone with stylish design and high quality camera.',
 299.99, 'OPPO F5', 2017, 0, 1),

('MOB030',
 'OPPO smartphone with AI enhanced camera and fast charging.',
 329.99, 'OPPO F9', 2018, 0, 1),

('MOB031',
 'OPPO smartphone with quad camera and large AMOLED display.',
 399.99, 'OPPO Reno2', 2019, 3, 0),

('MOB032',
 'OPPO smartphone with 5G connectivity and advanced camera.',
 499.99, 'OPPO Reno4', 2020, 5, 0),

('MOB033',
 'OPPO smartphone with AMOLED display and fast charging.',
 449.99, 'OPPO Reno5', 2021, 8, 0),

('MOB034',
 'OPPO smartphone with portrait camera and premium design.',
 499.99, 'OPPO Reno6', 2021, 6, 0),

('MOB035',
 'OPPO smartphone with high refresh rate display and fast charging.',
 549.99, 'OPPO Reno8', 2022, 9, 0),

('MOB036',
 'OPPO smartphone with improved camera and performance.',
 599.99, 'OPPO Reno10', 2023, 7, 0),

/* ------------------------------------------------------------
   Vivo
   ------------------------------------------------------------ */
('MOB037',
 'Vivo smartphone designed for photography and entertainment.',
 249.99, 'Vivo V5', 2016, 0, 1),

('MOB038',
 'Vivo smartphone with high resolution selfie camera.',
 279.99, 'Vivo V7', 2017, 0, 1),

('MOB039',
 'Vivo smartphone with AMOLED display and dual camera.',
 329.99, 'Vivo V11', 2018, 2, 0),

('MOB040',
 'Vivo smartphone with modern design and AI camera.',
 399.99, 'Vivo V15', 2019, 5, 0),

('MOB041',
 'Vivo smartphone with 5G connectivity and AMOLED display.',
 449.99, 'Vivo V20', 2020, 7, 0),

('MOB042',
 'Vivo smartphone with high refresh rate and advanced camera.',
 499.99, 'Vivo V23', 2022, 8, 0),

('MOB043',
 'Vivo smartphone with powerful processor and portrait camera.',
 549.99, 'Vivo V27', 2023, 10, 0),

('MOB044',
 'Vivo smartphone with upgraded camera and fast charging.',
 599.99, 'Vivo V30', 2024, 6, 0),

/* ------------------------------------------------------------
   Nokia
   ------------------------------------------------------------ */
('MOB045',
 'Nokia smartphone with durable design and basic smart features.',
 179.99, 'Nokia 5.1', 2018, 0, 1),

('MOB046',
 'Nokia smartphone with clean Android experience.',
 199.99, 'Nokia 6.1', 2018, 2, 0),

('MOB047',
 'Nokia smartphone with dual camera and Android One.',
 249.99, 'Nokia 7.2', 2019, 4, 0),

('MOB048',
 'Nokia smartphone with 5G support and modern design.',
 349.99, 'Nokia 8.3', 2020, 3, 0),

/* ------------------------------------------------------------
   Huawei
   ------------------------------------------------------------ */
('MOB049',
 'Huawei smartphone with premium metal design and Leica camera.',
 399.99, 'Huawei P9', 2016, 0, 1),

('MOB050',
 'Huawei smartphone with edge-to-edge display and dual camera.',
 549.99, 'Huawei P20', 2018, 0, 1),

('MOB051',
 'Huawei smartphone with advanced triple camera system.',
 699.99, 'Huawei P30', 2019, 3, 0),

('MOB052',
 'Huawei flagship smartphone with powerful processor and camera.',
 799.99, 'Huawei P40', 2020, 4, 0),

/* ------------------------------------------------------------
   Sony
   ------------------------------------------------------------ */
('MOB053',
 'Sony smartphone with compact design and high quality display.',
 299.99, 'Xperia Z3', 2014, 0, 1),

('MOB054',
 'Sony smartphone with premium camera and water resistance.',
 399.99, 'Xperia XZ', 2016, 0,1),

('MOB055',
 'Sony smartphone with 4K HDR display and premium camera.',
 699.99, 'Xperia 1', 2019, 2, 0),

('MOB056',
 'Sony smartphone designed for multimedia and photography.',
 899.99, 'Xperia 1 II', 2020, 3, 0),

/* ------------------------------------------------------------
   Google
   ------------------------------------------------------------ */
('MOB057',
 'Google smartphone with pure Android experience and excellent camera.',
 699.99, 'Pixel 3', 2018, 0, 1),

('MOB058',
 'Google smartphone with advanced computational photography.',
 699.99, 'Pixel 4', 2019, 2, 0),

('MOB059',
 'Google smartphone with Tensor-powered features and excellent camera.',
 599.99, 'Pixel 6', 2021, 5, 0),

('MOB060',
 'Google smartphone with advanced AI camera and clean Android.',
 699.99, 'Pixel 7', 2022, 7, 0),

('MOB061',
 'Google smartphone with Tensor G3 processor and AI features.',
 799.99, 'Pixel 8', 2023, 8, 0),

('MOB062',
 'Google smartphone with advanced AI features and premium camera.',
 799.99, 'Pixel 9', 2024, 10,0),

/* ------------------------------------------------------------
   OnePlus
   ------------------------------------------------------------ */
('MOB063',
 'OnePlus smartphone focused on performance and fast charging.',
 399.99, 'OnePlus 6', 2018, 0, 1),

('MOB064',
 'OnePlus smartphone with flagship performance and AMOLED display.',
 499.99, 'OnePlus 7', 2019, 3, 0),

('MOB065',
 'OnePlus smartphone with 5G support and high refresh rate display.',
 599.99, 'OnePlus 8', 2020, 5, 0),

('MOB066',
 'OnePlus smartphone with powerful processor and fast charging.',
 699.99, 'OnePlus 10', 2022, 6, 0),

('MOB067',
 'OnePlus flagship smartphone with premium display and camera.',
 799.99, 'OnePlus 11', 2023, 8, 0),

('MOB068',
 'OnePlus flagship smartphone with latest generation performance.',
 799.99, 'OnePlus 13', 2025, 9, 0);
GO


/* ============================================================
   7. Verify data
   ============================================================ */

SELECT
    [role],
    COUNT(*) AS NumberOfUsers
FROM dbo.[User]
GROUP BY [role]
ORDER BY [role];
GO

SELECT COUNT(*) AS TotalUsers
FROM dbo.[User];
GO

SELECT COUNT(*) AS TotalMobiles
FROM dbo.Mobile;
GO

SELECT
    MIN(yearOfProduction) AS OldestYear,
    MAX(yearOfProduction) AS NewestYear
FROM dbo.Mobile;
GO

SELECT
    outOfStock,
    COUNT(*) AS NumberOfProducts
FROM dbo.Mobile
GROUP BY outOfStock;
GO

SELECT *
FROM dbo.[User]
ORDER BY [role], [user];
GO

SELECT *
FROM dbo.Mobile
ORDER BY mobileId;
GO