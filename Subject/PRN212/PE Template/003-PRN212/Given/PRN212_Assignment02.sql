USE [master]
GO

IF DB_ID(N'BookDB') IS NOT NULL
BEGIN
    ALTER DATABASE [BookDB] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE [BookDB];
END
GO

CREATE DATABASE [BookDB]
GO

USE [BookDB]
GO

CREATE TABLE [dbo].[Books]
(
    [BookID] INT NOT NULL,
    [Title] NVARCHAR(255) NOT NULL,
    [Publisher] NVARCHAR(255) NULL,
    [PublicationYear] INT NULL,
    CONSTRAINT [PK_Books] PRIMARY KEY ([BookID])
)
GO

INSERT INTO [dbo].[Books] ([BookID], [Title], [Publisher], [PublicationYear]) VALUES
(1, N'1984', N'Secker & Warburg', 1949),
(2, N'Harry Potter and the Philosopher''s Stone', N'Bloomsbury', 1997),
(3, N'The Hobbit', N'George Allen & Unwin', 1937),
(4, N'Murder on the Orient Express', N'Collins Crime Club', 1934),
(5, N'Foundation', N'Gnome Press', 1951),
(6, N'Animal Farm', N'Secker & Warburg', 1945),
(7, N'Harry Potter and the Chamber of Secrets', N'Bloomsbury', 1998)
GO