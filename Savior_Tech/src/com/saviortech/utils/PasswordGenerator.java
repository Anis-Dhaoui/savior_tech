/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

/**
 *
 * @author freec
 */
public class PasswordGenerator {

    // function to generate a random string of length n
    public static String getRandomPassword() {
        final int PASWORDLENGTH = 8;
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(PASWORDLENGTH);

        for (int i = 0; i < PASWORDLENGTH; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int) (AlphaNumericString.length()
                * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                .charAt(index));
        }

        return sb.toString();
    }

}
