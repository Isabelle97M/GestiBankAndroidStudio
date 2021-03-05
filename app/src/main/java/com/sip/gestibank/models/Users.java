package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("password")
    @Expose
    private String password;

    public Users(){
    };

    public Users(String firstname, String name,
                 String tel, String email,
                 String role, String password)
    {
        this.firstname = firstname;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
