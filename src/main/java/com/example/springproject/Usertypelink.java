package com.example.springproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertypelinks")
public class Usertypelink {
    @Id
    @Column(name = "userid", nullable = false, length = 20)
    private String userid;

    @Column(name = "username", length = 40)
    private String username;

    @Column(name = "type", length = 40)
    private String type;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}