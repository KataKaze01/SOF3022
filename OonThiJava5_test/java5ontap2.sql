create database Java5_ontap2;
use Java5_ontap2;
CREATE TABLE Movies (
    MovieID INT PRIMARY KEY,              -- Column name from image, INT type, NOT NULL inferred from PK and unchecked box
    Title NVARCHAR(200) NULL,           -- Column name, NVARCHAR(200) type, NULL allowed
    Director NVARCHAR(100) NULL,         -- Column name, NVARCHAR(100) type, NULL allowed
    ReleaseYear INT NULL,               -- Column name, INT type, NULL allowed
    Genre NVARCHAR(50) NOT NULL         -- Column name, NVARCHAR(50) type, NOT NULL (Allow Nulls unchecked)
);