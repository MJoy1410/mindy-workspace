SELECT
    l.LocationID,
    l.Name AS LocationName,
    p.ProductID,
    p.Name AS ProductName,
    pi.Quantity
FROM ProductInventory AS pi
INNER JOIN Location AS l
    ON pi.LocationID = l.LocationID
INNER JOIN Product AS p
    ON pi.ProductID = p.ProductID
WHERE pi.Quantity =
(
    SELECT MAX(pi2.Quantity)
    FROM ProductInventory AS pi2
    WHERE pi2.LocationID = pi.LocationID
)
ORDER BY
    l.Name ASC,
    p.Name DESC;