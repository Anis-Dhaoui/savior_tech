/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LENOVO
 */
public class ControlSaisie {

    public boolean controlEmail(String email) {
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(masque);
        //CharSequence laSaisieDeLutilisateur = null;
        Matcher controler = pattern.matcher(email);
        return controler.matches();

    }
     public boolean controlPassword(String pass) {
        String masque = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
        Pattern pattern = Pattern.compile(masque);
        //CharSequence laSaisieDeLutilisateur = null;
        Matcher controler = pattern.matcher(pass);
        return controler.matches();

    }
     

}
