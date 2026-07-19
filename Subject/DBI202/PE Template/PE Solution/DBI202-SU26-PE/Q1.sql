CREATE TABLE Departments (
    DeptID varchar(20) PRIMARY KEY,
    name nvarchar(200),
    office nvarchar(100)
)

CREATE TABLE Employees (
    EmpCode varchar(20) PRIMARY KEY,
    Name nvarchar(50),
    BirthDate date,
    DeptID varchar(20),

    FOREIGN KEY (DeptID) REFERENCES Departments(DeptID)
)

CREATE TABLE Dependants (
    EmpCode varchar(20),
    Number int,
    Name nvarchar(50),
    BirthDate date,
    Role nvarchar(30),

    PRIMARY KEY (EmpCode, Number),
    FOREIGN KEY (EmpCode) REFERENCES Employees(EmpCode)
)