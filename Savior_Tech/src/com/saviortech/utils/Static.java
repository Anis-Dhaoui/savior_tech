/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

/**
 *
 * @author SOMRANI
 */
public class Static {
    private static int id;
    private static String img;
    private static String recherche;
    private static int iduser=7;
    public static String getImg() {
        return img;
    }

    public static void setImg(String img) {
        Static.img = img;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Static.id = id;
    }

    public static String getRecherche() {
        return recherche;
    }

    public static void setRecherche(String recherche) {
        Static.recherche = recherche;
    }

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        Static.iduser = iduser;
    }
    
}
