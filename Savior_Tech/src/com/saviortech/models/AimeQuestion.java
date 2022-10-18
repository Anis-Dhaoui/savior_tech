/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

/**
 *
 * @author SOMRANI
 */
public class AimeQuestion {
    private int idAime;
    private int idQuestion;
    private int idUser;

    public AimeQuestion( int idUser,int idQuestion) {
        this.idUser = idUser;
        this.idQuestion = idQuestion;
    }

    public AimeQuestion(int idAime, int idUser, int idQuestion) {
        this.idAime = idAime;
         this.idUser = idUser;
        this.idQuestion = idQuestion;
       
    }

    public AimeQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdAime() {
        return idAime;
    }

    public void setIdAime(int idAime) {
        this.idAime = idAime;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "AimeQuestion{" + "idAime=" + idAime + ", idQuestion=" + idQuestion + ", idUser=" + idUser + '}';
    }
    
}
