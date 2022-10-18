package com.saviortech.models;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.util.Date;
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
    private int idQuestion;
    private int iduser;
    private String description;
    private Date date;
    private String titre;
    private String image;

    public Question(int idQuestion) {
        this.idQuestion = idQuestion;
    }

   
 public Question( String description,  String titre, String image, int idQuestion) {
        this.description = description;
        this.titre = titre;
        this.image = image;
        this.idQuestion=idQuestion;
    }
 public Question( String description,  String titre, int idQuestion) {
        this.description = description;
        this.titre = titre;
        this.idQuestion=idQuestion;
    }

 

    
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
   


    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "Question{" + "idQuestion=" + idQuestion + ", description=" + description + ", date=" + date + ", titre=" + titre + ", image=" + image + '}';
    }

    public Question(int iduser, String description,  String titre, String image) {
        this.iduser=iduser;
        this.description = description;
        this.titre = titre;
        this.image = image;
    }
       public Question(int iduser, String description,  String titre) {
        this.iduser=iduser;
        this.description = description;
        this.titre = titre;
    }

    public Question(int idQuestion, int iduser, String description, Date date, String titre, String image) {
        this.idQuestion = idQuestion;
        this.iduser = iduser;
        this.description = description;
        this.date = date;
        this.titre = titre;
        this.image = image;
    }
    
}
