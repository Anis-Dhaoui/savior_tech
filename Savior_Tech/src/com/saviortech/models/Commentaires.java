/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

import java.util.Date;

/**
 *
 * @author Marwen
 */
public class Commentaires {

    private String id;
    private String description;
    private String createdAt;

    public Commentaires(String id, String description, String createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Commentaires{" + "id=" + id + ", description=" + description + ", date=" + '}';
    }

}
