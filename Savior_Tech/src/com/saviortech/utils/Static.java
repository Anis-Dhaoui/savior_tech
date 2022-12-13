/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

import com.saviortech.models.CurrentUser;

/**
 *
 * @author SOMRANI
 */
public class Static {
    private static String id;
    private static String img;
    private static String recherche;
    private static String iduser;
    public static String getImg() {
        return img;
    }

    public static void setImg(String img) {
        Static.img = img;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Static.id = id;
    }

    public static String getRecherche() {
        return recherche;
    }

    public static void setRecherche(String recherche) {
        Static.recherche = recherche;
    }

    public static String getIduser() {
        return iduser;
    }

    public static void setIduser(String iduser) {
        Static.iduser = CurrentUser.userInfo.get(0).getId();
    }
    
}
