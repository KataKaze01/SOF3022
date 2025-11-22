package com.example.TS01135_java5OnTap2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieID; // Đổi tên từ id

    @Column(name = "Title", nullable = false, length = 200) // Ánh xạ cột Title, không null
    private String title;

    @Column(name = "Director", length = 100) // Ánh xạ cột Director
    private String director;

    @Column(name = "ReleaseYear") // Ánh xạ cột ReleaseYear
    private Integer releaseYear; // Đổi kiểu dữ liệu

    @Column(name = "Genre", length = 50) // Ánh xạ cột Genre
    private String genre;

    // Constructors
    public Movie() {
    }

    public Movie(String title, String director, Integer releaseYear, String genre) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    // Getters and Setters
    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

