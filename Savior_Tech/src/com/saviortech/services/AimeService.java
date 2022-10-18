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
                String req = "INSERT INTO aime (idUser,idQuestion) VALUES ('"+ o.getIdUser()+"','"+o.getIdQuestion()+"')";
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
            String req = "SELECT * FROM aime";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                AimeQuestion.add(new AimeQuestion(res.getInt(1),res.getInt(2),res.getInt(3)));
            }
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return AimeQuestion; 
    }
    
    public List<AimeQuestion> afficher(int idQuestion ,int iduser) {
            List<AimeQuestion> AimeQuestion = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM aime where idQuestion="+idQuestion+" AND idUser="+iduser+"";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                AimeQuestion.add(new AimeQuestion(res.getInt(1),res.getInt(2),res.getInt(3)));
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
           String req = "DELETE FROM aime where  idUser=? and idQuestion =?";
          PreparedStatement pst = cnx.prepareStatement(req);
          pst.setInt(1, o.getIdUser());
           pst.setInt(2, o.getIdQuestion());
           
          pst.executeUpdate();
          System.out.println("Jaime supprimée !");
    } catch (SQLException ex) {
         System.out.println(ex.getMessage());
   }
    }

    @Override
    public List<AimeQuestion> afficher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
