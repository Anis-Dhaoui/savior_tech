package com.saviortech.models;

import java.util.Date;

/**
 *
 * @author SOMRANI
 */
public class Reponse {
    private String id;
    private String message;
    private String idQuestion;
    private String idUser;
    private Date createdAt;
    private Date updatedAt;

    public Reponse( String message,String id) {
        this.message = message;
        this.id = id;
        
    }

    public Reponse(String id) {
        this.id = id;
    }

    public Reponse(String id, String message, String idQuestion, String idUser, Date createdAt, Date updatedAt) {
        this.id = id;
        this.message = message;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

   
    public Reponse(String message, String idQuestion, String idUser) {
        this.message = message;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
    }

    public Reponse(String id,String message, String idUser, Date createdAt) {
        this.id = id;
        this.message = message;
        this.idUser = idUser;
        this.createdAt = createdAt;
    }

    public Reponse(String id, String message, String idQuestion, String idUser, Date createdAt) {
        this.id = id;
        this.message = message;
        this.idQuestion = idQuestion;
        this.idUser = idUser;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", message=" + message + ", idQuestion=" + idQuestion + ", idUser=" + idUser + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    
}
