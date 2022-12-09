/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

/**
 *
 * @author Marwen
 */
public class Reactions {
    private String id;
    private String reaction ;

    public Reactions (String id, String reaction) {
        this.id = id;
        this.reaction = reaction;
    }
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
     @Override
    public String toString() {
        return "Reaction{" + "id=" + id + ", reaction=" + reaction + '}';
    }
   
    
}
