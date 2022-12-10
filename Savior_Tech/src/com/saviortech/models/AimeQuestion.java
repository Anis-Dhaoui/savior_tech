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
    private String id;
    private String idQuestion;
    private String IdUser;

    public AimeQuestion( String IdUser,String idQuestion) {
        this.IdUser = IdUser;
        this.idQuestion = idQuestion;
    }

    public AimeQuestion(String id, String IdUser, String idQuestion) {
        this.id = id;
         this.IdUser = IdUser;
        this.idQuestion = idQuestion;
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "AimeQuestion{" + "id=" + id + ", idQuestion=" + idQuestion + ", IdUser=" + IdUser + '}';
    }

}
