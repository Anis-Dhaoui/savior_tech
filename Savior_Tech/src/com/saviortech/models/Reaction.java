/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

/**
 *
 * @author Marwen
 */
public class Reaction {
    private String reaction ;
    private int idUt ;
    private int idPub;

    public Reaction(String reaction, int idUt, int idPub) {
        this.reaction = reaction;
        this.idUt = idUt;
        this.idPub = idPub;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    public int getIdUt() {
        return idUt;
    }

    public void setIdUt(int idUt) {
        this.idUt = idUt;
    }


   

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
    
    
}
