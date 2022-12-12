/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marwen
 */
public class Publications {

    private String id;
    private String titre;
    private String description;
    private String image;
    private String statut;
    private String createdAt;
    private String fullName;

    public Publications(String id, String titre, String description, String image, String createdAt, String fullName) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.createdAt = createdAt;
        this.fullName = fullName;
    }

    public Publications(String titre, String description, String image, String statut) {
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.statut = statut;

    }

    public void affichier(String titre, String description, String image, String createdAt, String fullNAme) {
        this.titre = titre;
        this.description = description;
        this.image = image;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getStatut() {
        return statut;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", image=" + image + ", statut=" + statut + '}';
    }
}
