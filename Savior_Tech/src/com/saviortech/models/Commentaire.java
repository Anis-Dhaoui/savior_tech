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
public class Commentaire {

    private int idCommnetaire;
    private String description;
    private String date ;
    private int idUtilisateur;
    private String nom;
    private int idPublication; 

    public Commentaire(String description, String date, String nom) {
        
        this.description = description;
        this.date = date;
      
        this.nom = nom;
        
    }

    
    public Commentaire(int idCommnetaire, String description) {
        this.idCommnetaire = idCommnetaire;
        this.description = description;
    }

    public Commentaire(String description,String date ,int idUtilisateur , int idPublication) {
        this.description = description;
        this.date = date;
        this.idPublication = idPublication;
        this.idUtilisateur = idUtilisateur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCommnetaire() {
        return idCommnetaire;
    }

    public void setIdCommnetaire(int idCommnetaire) {
        this.idCommnetaire = idCommnetaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "description=" + description + ", date=" + date + ", nom=" + nom + '}';
    }

  
}
