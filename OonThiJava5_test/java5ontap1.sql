CREATE DATABASE java5_ontap;
GO
USE java5_ontap;
GO

DROP TABLE Users;

CREATE TABLE Users (
  id INT IDENTITY(1,1) PRIMARY KEY,
  name NVARCHAR(100),
  email NVARCHAR(100),
  password NVARCHAR(100),
  admin bit
  );





