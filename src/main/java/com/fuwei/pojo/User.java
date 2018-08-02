package com.fuwei.pojo;

public class User {

    private  Integer id;
    private String name;
    private String pwd;
    private String salt;
    private String despwd;
    private String phone;
    private String head_photo;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDespwd() {
        return despwd;
    }

    public void setDespwd(String despwd) {
        this.despwd = despwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead_photo() {
        return head_photo;
    }

    public void setHead_photo(String head_photo) {
        this.head_photo = head_photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", despwd='" + despwd + '\'' +
                ", phone='" + phone + '\'' +
                ", head_photo='" + head_photo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
