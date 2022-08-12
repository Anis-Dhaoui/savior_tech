/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

import java.sql.Date;

/**
 *
 * @author freec
 */
public class Events {

    private int event_id;
    private String event_title;
    private String event_image;
    private String event_category;
    private String event_description;
    private Date event_start_date;
    private Date event_end_date;
    private String event_status;
    private String event_location;
    private int event_price;
    private String event_orgoniser;
    private int event_nb_participant;
    private int event_max_participant;

    public Events(String event_title, String event_image, String event_category, String event_description, Date event_start_date, Date event_end_date, String event_status, String event_location, int event_price, String event_orgoniser, int event_nb_participant, int event_max_participant) {
        this.event_title = event_title;
        this.event_image = event_image;
        this.event_category = event_category;
        this.event_description = event_description;
        this.event_start_date = event_start_date;
        this.event_end_date = event_end_date;
        this.event_status = event_status;
        this.event_location = event_location;
        this.event_price = event_price;
        this.event_orgoniser = event_orgoniser;
        this.event_nb_participant = event_nb_participant;
        this.event_max_participant = event_max_participant;
    }

    public Events(int event_id, String event_title, String event_image, String event_category, String event_description, Date event_start_date, Date event_end_date, String event_status, String event_location, int event_price, String event_orgoniser, int event_nb_participant, int event_max_participant) {
        this.event_id = event_id;
        this.event_title = event_title;
        this.event_image = event_image;
        this.event_category = event_category;
        this.event_description = event_description;
        this.event_start_date = event_start_date;
        this.event_end_date = event_end_date;
        this.event_status = event_status;
        this.event_location = event_location;
        this.event_price = event_price;
        this.event_orgoniser = event_orgoniser;
        this.event_nb_participant = event_nb_participant;
        this.event_max_participant = event_max_participant;
    }

    public Events() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_category() {
        return event_category;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public Date getEvent_start_date() {
        return event_start_date;
    }

    public void setEvent_start_date(Date event_start_date) {
        this.event_start_date = event_start_date;
    }

    public Date getEvent_end_date() {
        return event_end_date;
    }

    public void setEvent_end_date(Date event_end_date) {
        this.event_end_date = event_end_date;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public String getEvent_location() {
        return event_location;
    }

    public void setEvent_location(String event_location) {
        this.event_location = event_location;
    }

    public int getEvent_price() {
        return event_price;
    }

    public void setEvent_price(int event_price) {
        this.event_price = event_price;
    }

    public String getEvent_orgoniser() {
        return event_orgoniser;
    }

    public void setEvent_orgoniser(String event_orgoniser) {
        this.event_orgoniser = event_orgoniser;
    }

    public int getEvent_nb_participant() {
        return event_nb_participant;
    }

    public void setEvent_nb_participant(int event_nb_participant) {
        this.event_nb_participant = event_nb_participant;
    }

    public int getEvent_max_participant() {
        return event_max_participant;
    }

    public void setEvent_max_participant(int event_max_participant) {
        this.event_max_participant = event_max_participant;
    }

    @Override
    public String toString() {
        return "Events{" + "event_id=" + event_id + ", event_title=" + event_title + ", event_image=" + event_image + ", event_category=" + event_category + ", event_description=" + event_description + ", event_start_date=" + event_start_date + ", event_end_date=" + event_end_date + ", event_status=" + event_status + ", event_location=" + event_location + ", event_price=" + event_price + ", event_orgoniser=" + event_orgoniser + ", event_nb_participant=" + event_nb_participant + ", event_max_participant=" + event_max_participant + '}'+"\n";
    }

    public Events get(int j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
