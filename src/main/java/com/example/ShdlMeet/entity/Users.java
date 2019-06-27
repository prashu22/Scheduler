package com.example.ShdlMeet.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String phone;

    @Id
    ObjectId _id;

    private List<ObjectId> meetings;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public List<ObjectId> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<ObjectId> meeting) {
        this.meetings = meeting;
    }
}
