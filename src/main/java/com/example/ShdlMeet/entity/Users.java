package com.example.ShdlMeet.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Document(collection = "Users")
public class Users {

    @NotBlank(message = "Enter Password")
    private String password;

    @NotBlank(message = "Name is Mandatory")
    private String name;

    @NotBlank(message = "Email is Mandatory")
    private String email;
    private String address;
    private Integer phone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eID;
    private List<Timing> timings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer geteID() {
        return eID;
    }

    public void seteID(Integer eID) {
        this.eID = eID;
    }

    public List<Timing> getTimings() {
        return timings;
    }

    public void setTimings(List<Timing> timings) {
        this.timings = timings;
    }
}