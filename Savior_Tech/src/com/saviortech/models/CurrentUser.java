/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.models;

import com.saviortech.services.ServiceUtilisateur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CurrentUser {
    public static List<Utilisateur> userInfo= new ArrayList<>();

    public CurrentUser() {
    }

    
    public void setUserInfo(List<Utilisateur> userInfo) {
        this.userInfo = userInfo;
    }

    public List<Utilisateur> getUserInfo() {
        return userInfo;
    }
    
    
    
    
    
}
