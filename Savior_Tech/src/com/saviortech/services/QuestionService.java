/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Question;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOMRANI
 */
public class QuestionService implements QrService<Question> {
        private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public List<Question> afficher() {
         List<Question> question = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM question Order by idQuestion desc";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            
            while(res.next()) {
                question.add(new Question(res.getInt(1),res.getInt(2), res.getString(3), res.getDate(4), res.getString(5), res.getString(6)));

            }
            
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return question;
    }
        @Override
     public List<Question> afficher(int id) {
         List<Question> question = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM question where idQuestion="+id+"";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                question.add(new Question(res.getInt(1),res.getInt(2), res.getString(3), res.getDate(4), res.getString(5), res.getString(6)));
            }
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return question;
    }
     
     public List<Question> recherche(String recherche) {
         List<Question> question = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM question where description LIKE '%"+recherche+"%'";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                question.add(new Question(res.getInt(1),res.getInt(2), res.getString(3), res.getDate(4), res.getString(5), res.getString(6)));
            }
            System.out.println("recherche récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return question;
    }

    @Override
    public void ajouter(Question o) {
    try {
        java.util.Date d=new java.util.Date();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
                String strDate = dateFormat.format(d);
                String date=strDate;
                String req;
                if(o.getImage()!=null){
                req = "INSERT INTO question (idUser,description,date,titre,image) VALUES ('"+ o.getIduser()+"','"+o.getDescription()+"','"+date+"','"+o.getTitre()+"','"+o.getImage()+"')";
                }
                else{
                  req = "INSERT INTO question (idUser,description,date,titre) VALUES ('"+ o.getIduser()+"','"+o.getDescription()+"','"+date+"','"+o.getTitre()+"')";
                  
                }
                Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Question ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            }

    @Override
    public void supprimer(Question o) {

     try {
           String req = "DELETE FROM question where idQuestion=?";
           String req1 = "DELETE FROM reponse where idQuestion=?";
           String req2 = "DELETE FROM aime where idQuestion=?";
          PreparedStatement pst = cnx.prepareStatement(req);
          PreparedStatement pst1 = cnx.prepareStatement(req1);
          PreparedStatement pst2 = cnx.prepareStatement(req2);
           pst.setInt(1, o.getIdQuestion());
           pst1.setInt(1, o.getIdQuestion());
           pst2.setInt(1, o.getIdQuestion());
           pst1.executeUpdate();
          pst2.executeUpdate();
          pst.executeUpdate();
          
          System.out.println("Question supprimée !");
    } catch (SQLException ex) {
         System.out.println(ex.getMessage());
   }
    } 

    @Override
    public void modifier(Question o) {
            try {
                PreparedStatement pst = null;
                if(o.getImage()!=null){
                   
                        String req = "UPDATE question SET description=?,titre=?,image=? where idQuestion =?";
                        pst = cnx.prepareStatement(req);
                        pst.setString(1, o.getDescription());
                        pst.setString(2, o.getTitre());
                        pst.setString(3, o.getImage());
                        pst.setInt(4, o.getIdQuestion());
                   
                }
                else{
                    
                        String req = "UPDATE question SET description=?,titre=? where idQuestion =?";
                        pst = cnx.prepareStatement(req);
                        pst.setString(1, o.getDescription());
                        pst.setString(2, o.getTitre());
                        pst.setInt(3, o.getIdQuestion());
                   
                }
                
                pst.executeUpdate();
                System.out.println("Question modifiée !");
            } catch (SQLException ex) {
                Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    
}
