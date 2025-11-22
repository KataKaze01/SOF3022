CREATE TABLE Movies (
    MovieID INT PRIMARY KEY IDENTITY(1,1), -- Thêm IDENTITY(1,1)
    Title NVARCHAR(200) NOT NULL,
    Director NVARCHAR(100),
    ReleaseYear INT, -- Đảm bảo tên cột khớp (có thể là [Release Year])
    Genre NVARCHAR(50)
);

drop TABLE Movies