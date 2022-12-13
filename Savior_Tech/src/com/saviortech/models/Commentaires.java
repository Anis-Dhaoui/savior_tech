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
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public Commentaires(String id, String description, String fullName) {
        this.id = id;
        this.description = description;
       
        this.fullName = fullName;
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
        return "Commentaires{" + "id=" + id + ", description=" + description + ", fullName=" + fullName + '}';
    }

   
}
