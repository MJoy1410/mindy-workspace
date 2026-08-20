USE [master]
GO
-- 0. Xóa Database RentalDB nếu đã tồn tại trong DBMS --------------------
IF EXISTS (
    SELECT name 
    FROM sys.databases 
    WHERE name = N'human'
)
BEGIN
    -- Tùy chọn: đưa DB về SINGLE_USER để tránh lỗi đang có kết nối
    ALTER DATABASE [human] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    
    -- Xóa database
    DROP DATABASE [human];
END
GO
/****** Object:  Database [human]   *****/
CREATE DATABASE [human] 
GO

USE [human]
GO

create table HumanType(
   typeId int primary key not null,
   typeName nvarchar(35) not null
);
go
create table Human(
   humanId int primary key not null,
   humanName nvarchar(28) not null,
   dob datetime default '1900/1/1',
   gender bit default 1,
   typeId int references HumanType(typeId) not null,
   userHuman varchar(50) unique not null,
   passHuman varchar(250) not null, 
   role varchar(20) default 'mem',				-- role = 'adm' => Administrator; role = 'mem' => member
   isActive bit default 0						-- Active or Block account 
)
go
insert into HumanType values(1,'Teacher')
insert into HumanType values(2,'Student')
insert into HumanType values(3,'Worker')
go
insert into Human values(1,'Steve','1965/3/21',1,1,'leader','111111','adm',1)
insert into Human values(2,N'Nguyễn Thị Hồng Hạnh','2002/4/11',0,1,'mem1','111111','mem',1)
insert into Human values(3,N'Trần Quang Hải','1999/12/23',1,2,'cust01','111111','mem',0)
insert into Human values(4,N'Nguyễn Công Ngọc Diệp','1970/08/25',1,1,'mem2','111111','mem',1)
insert into Human values(5,'Elton musk','1970/1/29',1,3,'cust02','111111','adm',1)
go