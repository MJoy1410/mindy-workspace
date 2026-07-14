
USE master;
GO

IF EXISTS (SELECT name FROM sys.databases WHERE name = N'EmployeeDB')
    DROP DATABASE EmployeeDB;
GO

CREATE DATABASE EmployeeDB;
GO

USE EmployeeDB;
GO

CREATE TABLE Employee (
    Id       INT IDENTITY(1,1) PRIMARY KEY,
    Name     NVARCHAR(100)     NOT NULL,
    Sex      NVARCHAR(10)      NOT NULL,       -- 'Male' / 'Female'
    Dob      DATE              NOT NULL,
    Position NVARCHAR(50)      NOT NULL        -- 'Developer','Leader','Manager','Tester'
);
GO

INSERT INTO Employee (Name, Sex, Dob, Position) VALUES
('Tran Bao Han',    'Female', '1980-09-12', 'Developer'),
('Quach Phu Thanh', 'Male',   '1987-01-19', 'Developer'),
('Chu Thanh Quang', 'Male',   '1984-05-23', 'Leader'),
('Trinh Tien Dung', 'Male',   '1990-06-14', 'Developer'),
('Phan Thu Thao',   'Female', '1990-03-12', 'Tester'),
('Nguyen Xuan Quang','Male',  '1987-01-19', 'Leader'),
('Trinh Thu Hang',  'Female', '2000-05-12', 'Developer'),
('Tran Hong Quan',  'Male',   '1998-04-16', 'Leader'),
('Pham The Tung',   'Male',   '1984-09-12', 'Manager'),
('Tran Manh Chien', 'Male',   '1983-10-21', 'Manager');
GO

SELECT * FROM Employee;
GO
