package com.example.demo.model;

import java.util.Date;

public class Staff {
    private String id;
    private String fullname;
    private String photo = "photo.jpg";
    private Boolean gender = true;
    private Date birthday = new Date();
    private Double salary = 12345.6789;
    private Integer level = 0;

    // Constructor không tham số
    public Staff() {
    }

    // Constructor đầy đủ tham số
    public Staff(String id, String fullname, String photo, Boolean gender, Date birthday, Double salary, Integer level) {
        this.id = id;
        this.fullname = fullname;
        this.photo = photo;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
        this.level = level;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}