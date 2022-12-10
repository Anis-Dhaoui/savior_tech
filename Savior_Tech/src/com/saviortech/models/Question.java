package com.saviortech.models;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.sql.Date;
import javafx.scene.control.TextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SOMRANI
 */
public class Question {
    private String id;
    private String IdUser;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private String titre;
    private String image;
    private String status;
    
    public Question(String id) {
        this.id = id;
    }

   
 public Question( String description,  String titre, String image, String id) {
        this.description = description;
        this.titre = titre;
        this.image = image;
        this.id=id;
    }
 public Question( String description,  String titre, String id) {
        this.description = description;
        this.titre = titre;
        this.id=id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", IdUser=" + IdUser + ", description=" + description + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", titre=" + titre + ", image=" + image + '}';
    }

    public Question(String id, String description, String titre, String image, String status, Date createdAt, Date updatedAt, String IdUser) {
        this.id = id;        
        this.description = description;
        this.titre = titre;
        this.image = image;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.IdUser = IdUser;
    }

    
}
