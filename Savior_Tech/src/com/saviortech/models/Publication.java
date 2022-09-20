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
public class Publication {

    private int idPublication;
    private String titre;
    private String description;
    private String image;
    private String date;
    private int idUt;
    private String nomPrenom;

    public Publication(String titre, String description, String image, String date, String nomPrenom,int idPublication) {

        this.titre = titre;
        this.description = description;
        this.image = image;
        this.date = date;
        this.idUt = idUt;
        this.nomPrenom = nomPrenom;
        this.idPublication = idPublication;
    }

    public Publication(int idPublication, String titre, String description, String image, int idUt) {
        this.idPublication = idPublication;
        this.titre = titre;
        this.description = description;
        this.image = image;
   
        this.idUt = idUt;

    }

    public Publication(String titre, String description, String image,  int idUt) {
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.date = date;
        this.idUt = idUt;

    }

    public Publication(int idPublication) {
        this.idPublication = idPublication;
    }
        public Publication(int idPublication , String description) {
        this.idPublication = idPublication;
        this.description = description;
    }
    

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

    public int getIdUt() {
        return idUt;
    }

    public void setIdUt(int idUt) {
        this.idUt = idUt;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Publication{" + "titre=" + titre
                + ", description=" + description
                + ", image=" + image + ", date=" + date + ", nom= " + nomPrenom + '}' + "\n";
    }

}
