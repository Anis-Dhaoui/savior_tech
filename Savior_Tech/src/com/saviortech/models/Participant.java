/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

/**
 *
 * @author freec
 */
public class Participant {
    private int user_id;
    private String user_name;
    private String user_lastname;
    private String user_email;

    public Participant(int user_id, String user_name, String user_lastname, String user_email) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
    }

    public Participant() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "Participant{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_lastname=" + user_lastname + ", user_email=" + user_email + ", event_id=" + '}';
    }

    
}
