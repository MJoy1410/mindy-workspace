SELECT
    SubcategoryID,
    Category,
    Name
FROM ProductSubcategory
WHERE Category = N'Accessories'
ORDER BY SubcategoryID;