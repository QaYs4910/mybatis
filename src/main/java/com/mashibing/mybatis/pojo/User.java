package com.mashibing.mybatis.pojo;

public class User {

    private Integer id;
    private String username;
    private String address;
    private String gender;

    public User() {
    }

    public User(String username, String address, String gender) {
        this.username = username;
        this.address = address;
        this.gender = gender;
    }

    public User(Integer id, String username, String address, String gender) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
