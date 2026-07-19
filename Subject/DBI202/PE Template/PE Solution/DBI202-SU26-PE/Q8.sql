CREATE PROCEDURE proc_product_model
    @modelID INT,
    @numberOfProducts INT OUTPUT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT
        @numberOfProducts = COUNT(DISTINCT ProductID)
    FROM Product
    WHERE ModelID = @modelID;
END;
GO