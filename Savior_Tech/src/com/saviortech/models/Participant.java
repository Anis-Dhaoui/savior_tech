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
    private int part_id;
    private int event_id;
    private int user_id;

    public Participant() {
    }

    public Participant(int part_id, int event_id, int user_id) {
        this.part_id = part_id;
        this.event_id = event_id;
        this.user_id = user_id;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Participant{" + "part_id=" + part_id + ", event_id=" + event_id + ", user_id=" + user_id + '}';
    }
}
