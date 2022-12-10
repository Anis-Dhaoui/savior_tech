/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.AimeQuestion;
import com.saviortech.models.Question;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SOMRANI
 */
public class AimeService implements QrService<AimeQuestion>{
 private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(AimeQuestion o) {
         try {
                String req = "INSERT INTO aimes (idUser,idQuestion) VALUES ('"+ o.getIdUser()+"','"+o.getIdQuestion()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("J'aime ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }

    @Override
    public List<AimeQuestion> afficher() {
     List<AimeQuestion> AimeQuestion = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM aimes";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                AimeQuestion.add(new AimeQuestion(res.getString(1),res.getString(2),res.getString(3)));
            }
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return AimeQuestion; 
    }
    
    public List<AimeQuestion> afficher(String idQuestion ,String iduser) {
            List<AimeQuestion> AimeQuestion = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM aimes where idQuestion="+idQuestion+" AND idUser="+iduser+"";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                AimeQuestion.add(new AimeQuestion(res.getString(1),res.getString(2),res.getString(3)));
            }
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return AimeQuestion; }

    @Override
    public void modifier(AimeQuestion o) {
}
    @Override
    public void supprimer(AimeQuestion o) {  
     try {
           String req = "DELETE FROM aimes where  idUser=? and idQuestion =?";
          PreparedStatement pst = cnx.prepareStatement(req);
          pst.setString(1, o.getIdUser());
           pst.setString(2, o.getIdQuestion());
           
          pst.executeUpdate();
          System.out.println("Jaime supprimée !");
    } catch (SQLException ex) {
         System.out.println(ex.getMessage());
   }
    }

    @Override
    public List<AimeQuestion> afficher(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
