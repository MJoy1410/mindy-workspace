SELECT
    ps.SubcategoryID,
    ps.Name AS SubcategoryName,
    ps.Category,
    COUNT(DISTINCT p.ProductID) AS NumberOfProducts
FROM ProductSubcategory AS ps
LEFT JOIN Product AS p
    ON ps.SubcategoryID = p.SubcategoryID
GROUP BY
    ps.SubcategoryID,
    ps.Name,
    ps.Category
ORDER BY
    ps.Category ASC,
    COUNT(DISTINCT p.ProductID) DESC,
    ps.Name ASC;