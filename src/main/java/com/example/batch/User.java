package com.example.batch;

public class User {
    private Integer id;
    private String username;
    private String address;
    private String gender;

    @Override
    public String toString() {
        return "User:{Id:" + id
                + ", Username:" + username
                + ", Address:" + address
                + ", Gender:" + gender
                + "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
