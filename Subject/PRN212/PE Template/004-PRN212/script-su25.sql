CREATE DATABASE EmployeeManagementDB;
GO

USE EmployeeManagementDB;
GO

DROP TABLE IF EXISTS Employee_Skills;
DROP TABLE IF EXISTS Employee_Projects;
DROP TABLE IF EXISTS Projects;
DROP TABLE IF EXISTS Skills;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Departments;
GO

-- =========================
-- 1. Departments
-- =========================
CREATE TABLE Departments (
    DepartmentID INT IDENTITY(1,1) PRIMARY KEY,
    DepartmentName NVARCHAR(100) NOT NULL UNIQUE,
    ManagerID INT NULL
);
GO

-- =========================
-- 2. Employees
-- =========================
CREATE TABLE Employees (
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    DOB DATE NOT NULL,
    DepartmentID INT NOT NULL,
    Position NVARCHAR(100) NOT NULL,
    HireDate DATE NOT NULL,

    CONSTRAINT FK_Employees_Departments
        FOREIGN KEY (DepartmentID)
        REFERENCES Departments(DepartmentID)
);
GO

ALTER TABLE Departments
ADD CONSTRAINT FK_Departments_Manager
FOREIGN KEY (ManagerID)
REFERENCES Employees(EmployeeID);
GO

-- =========================
-- 3. Projects
-- =========================
CREATE TABLE Projects (
    ProjectID INT IDENTITY(1,1) PRIMARY KEY,
    ProjectName NVARCHAR(100) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NULL,
    Budget DECIMAL(18,2) NOT NULL
);
GO

-- =========================
-- 4. Skills
-- =========================
CREATE TABLE Skills (
    SkillID INT IDENTITY(1,1) PRIMARY KEY,
    SkillName NVARCHAR(100) NOT NULL UNIQUE,
    Description NVARCHAR(255) NULL
);
GO

-- =========================
-- 5. Employee_Projects
-- =========================
CREATE TABLE Employee_Projects (
    EmployeeID INT NOT NULL,
    ProjectID INT NOT NULL,
    Role NVARCHAR(100) NOT NULL,
    JoinDate DATE NOT NULL,
    LeaveDate DATE NULL,

    CONSTRAINT PK_Employee_Projects
        PRIMARY KEY (EmployeeID, ProjectID),

    CONSTRAINT FK_EmployeeProjects_Employees
        FOREIGN KEY (EmployeeID)
        REFERENCES Employees(EmployeeID),

    CONSTRAINT FK_EmployeeProjects_Projects
        FOREIGN KEY (ProjectID)
        REFERENCES Projects(ProjectID)
);
GO

-- =========================
-- 6. Employee_Skills
-- =========================
CREATE TABLE Employee_Skills (
    EmployeeID INT NOT NULL,
    SkillID INT NOT NULL,
    ProficiencyLevel NVARCHAR(50) NOT NULL,
    AcquiredDate DATE NOT NULL,

    CONSTRAINT PK_Employee_Skills
        PRIMARY KEY (EmployeeID, SkillID),

    CONSTRAINT FK_EmployeeSkills_Employees
        FOREIGN KEY (EmployeeID)
        REFERENCES Employees(EmployeeID),

    CONSTRAINT FK_EmployeeSkills_Skills
        FOREIGN KEY (SkillID)
        REFERENCES Skills(SkillID)
);
GO

-- =========================
-- INSERT SAMPLE DATA
-- =========================

INSERT INTO Departments (DepartmentName)
VALUES
(N'Software Development'),
(N'Human Resources'),
(N'Finance'),
(N'Marketing'),
(N'Sales');
GO

INSERT INTO Employees (Name, DOB, DepartmentID, Position, HireDate)
VALUES
(N'Nguyen Van An', '1995-02-17', 1, N'Software Engineer', '2024-02-17'),
(N'Tran Thi Binh', '1992-06-10', 1, N'Senior Developer', '2023-01-15'),
(N'Le Van Cuong', '1990-09-20', 2, N'HR Manager', '2022-05-01'),
(N'Pham Thi Dung', '1996-12-05', 3, N'Accountant', '2024-03-10'),
(N'Hoang Van Em', '1994-04-25', 4, N'Marketing Executive', '2023-09-12');
GO

UPDATE Departments SET ManagerID = 2 WHERE DepartmentID = 1;
UPDATE Departments SET ManagerID = 3 WHERE DepartmentID = 2;
UPDATE Departments SET ManagerID = 4 WHERE DepartmentID = 3;
UPDATE Departments SET ManagerID = 5 WHERE DepartmentID = 4;
GO

INSERT INTO Skills (SkillName, Description)
VALUES
(N'Java', N'Java programming language'),
(N'Python', N'Python programming language'),
(N'SQL', N'Database query language'),
(N'Project Management', N'Ability to manage software projects'),
(N'Communication', N'Communication and teamwork skill');
GO

INSERT INTO Projects (ProjectName, StartDate, EndDate, Budget)
VALUES
(N'Employee Management System', '2024-01-01', '2024-06-30', 50000),
(N'Online Sales Platform', '2024-02-15', '2024-12-31', 120000),
(N'HR Portal', '2024-03-01', NULL, 75000);
GO

INSERT INTO Employee_Projects (EmployeeID, ProjectID, Role, JoinDate, LeaveDate)
VALUES
(1, 1, N'Developer', '2024-01-10', NULL),
(2, 1, N'Team Leader', '2024-01-01', NULL),
(3, 3, N'HR Consultant', '2024-03-05', NULL),
(1, 2, N'Backend Developer', '2024-02-20', NULL),
(5, 2, N'Marketing Support', '2024-02-25', NULL);
GO

INSERT INTO Employee_Skills (EmployeeID, SkillID, ProficiencyLevel, AcquiredDate)
VALUES
(1, 1, N'Intermediate', '2022-01-01'),
(1, 2, N'Intermediate', '2022-06-01'),
(1, 3, N'Advanced', '2023-01-01'),
(2, 1, N'Advanced', '2020-01-01'),
(2, 4, N'Advanced', '2021-05-01'),
(3, 5, N'Advanced', '2019-03-01'),
(4, 3, N'Intermediate', '2022-08-01'),
(5, 5, N'Intermediate', '2021-10-01');
GO

-- Kiểm tra dữ liệu
SELECT * FROM Departments;
SELECT * FROM Employees;
SELECT * FROM Skills;
SELECT * FROM Projects;
SELECT * FROM Employee_Skills;
SELECT * FROM Employee_Projects;
GO