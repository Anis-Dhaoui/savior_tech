/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

/**
 *
 * @author LENOVO
 */
public class Utilisateur {

    private String id;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String role;
    private String domain;
    private String interest;
    private String speciality;
    private Byte admin;

    public Byte isAdmin() {
        return admin;
    }

    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Utilisateur(String fullname, String username, String email, String password, String role, String domain, String interest, String speciality) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.domain = domain;
        this.interest = interest;
        this.speciality = speciality;
    }

    public Utilisateur(String id, String fullname, String username, String email, String password, String role, String domain, String interest, String speciality) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.domain = domain;
        this.interest = interest;
        this.speciality = speciality;
    }

    public Utilisateur(String fullname, String role, String speciality) {
        this.fullname = fullname;
        this.role = role;
        this.speciality = speciality;
    }

    public Utilisateur(String id, String fullname, String username, String email, String role, String domain, String interest, String speciality, Byte admin) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.role = role;
        this.domain = domain;
        this.interest = interest;
        this.speciality = speciality;
        this.admin = admin;

    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", fullname=" + fullname + ", username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + ", domain=" + domain + ", interest=" + interest + ", speciality=" + speciality + ", admin= " + admin + "}\n";
    }

}
