package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

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

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("password")
    @Expose
    private String password;

    public Customer(){

    };

    public Customer(String firstname, String name, String email, String tel)
    {
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.role = "CUSTOMER";
        this.status = "WAITING";
        this.password = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
