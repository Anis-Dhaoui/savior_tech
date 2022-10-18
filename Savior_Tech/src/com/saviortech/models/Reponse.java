package com.saviortech.models;

import java.util.Date;

/**
 *
 * @author SOMRANI
 */
public class Reponse {
    private int idReponse;
    private String message;
    private int idQuestion;
    private String idUser;
    private Date date;

    public Reponse( String message,int idReponse) {
        this.message = message;
        this.idReponse = idReponse;
        
    }

    public Reponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reponse(String message, int idQuestion, String idUser) {
        this.message = message;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
    }

    public Reponse(int idReponse,String message, String idUser, Date date) {
        this.idReponse = idReponse;
        this.message = message;
        this.idUser = idUser;
        this.date = date;
    }

    public Reponse(int idReponse, String message, int idQuestion, String idUser, Date date) {
        this.idReponse = idReponse;
        this.message = message;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reponse{" + "idReponse=" + idReponse + ", message=" + message + ", idQuestion=" + idQuestion + ", idUser=" + idUser + ", date=" + date + '}';
    }
    
    
}
