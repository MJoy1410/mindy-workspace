SELECT
    p.ProductID,
    p.Name AS ProductName,
    p.Color,
    p.Cost,
    p.Price,
    pi.LocationID,
    l.Name AS LocationName,
    pi.Shelf,
    pi.Bin,
    pi.Quantity
FROM Product AS p
LEFT JOIN ProductInventory AS pi
    ON p.ProductID = pi.ProductID
LEFT JOIN Location AS l
    ON pi.LocationID = l.LocationID
WHERE p.Color = N'Yellow'
      AND p.Cost < 400
ORDER BY
    p.ProductID ASC,
    pi.LocationID ASC;