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

    private String user_id;
    private String event_id;

    public Participant() {
    }

    public Participant(String user_id, String event_id) {
        this.user_id = user_id;
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "Participant{user_id=" + user_id + ", event_id=" + event_id + '}';
    }
}
