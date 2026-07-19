CREATE TRIGGER tr_insert_Product
ON Product
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT
        i.ProductID,
        i.Name AS ProductName,
        i.ModelID,
        pm.Name AS ModelName
    FROM inserted AS i
    LEFT JOIN ProductModel AS pm
        ON i.ModelID = pm.ModelID;
END;
GO