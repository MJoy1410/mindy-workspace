;WITH LocationProductCount AS
(
    SELECT
        l.LocationID,
        l.Name AS LocationName,
        COUNT(DISTINCT pi.ProductID) AS NumberOfProducts
    FROM Location AS l
    INNER JOIN ProductInventory AS pi
        ON l.LocationID = pi.LocationID
    GROUP BY
        l.LocationID,
        l.Name
)
SELECT
    LocationID,
    LocationName,
    NumberOfProducts
FROM LocationProductCount
WHERE NumberOfProducts =
(
    SELECT MIN(NumberOfProducts)
    FROM LocationProductCount
)