package com.springboot.restservice.entity;

import javax.persistence.*;

/*
@Author : Yogesh Deshmukh
*/

@Entity(name="user")
//@Table(name="user", schema = "FIB_OWNER") When table name is different than entity name, thta time will use @Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "USER_NAME", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "FIRST_NAME", length = 20, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 20, nullable = false)
    private String lastname;

    @Column(name = "EMAIL", length = 20, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 20, nullable = false)
    private String role;

    @Column(name = "SSN", length = 20, nullable = false, unique = true)
    private String ssn;

//No - args constructor
    public User() {
    }
    //Args constructor
    public User(long id, String username, String firstname, String lastname, String email, String role, String ssn) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
