/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.CurrentUser;
import com.saviortech.models.Question;
import static com.saviortech.services.ReponseService.cu;
import com.saviortech.utils.DataSource;
import com.saviortech.utils.UUIDGenerator;
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
        static CurrentUser cu = new CurrentUser();

    @Override
    public List<Question> afficher() {
         List<Question> question = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM questions Order by createdAt desc";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            
            while(res.next()) {
                question.add(new Question(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6),res.getDate(7) , res.getString(8)));

            }
            
            System.out.println("Question récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return question;
    }
        @Override
     public List<Question> afficher(String id) {
         List<Question> question = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM questions where id="+id+"";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                question.add(new Question(res.getString(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getDate(7), res.getString(8)));
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
            String req = "SELECT * FROM questions where description LIKE '%"+recherche+"%'";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                question.add(new Question(res.getString(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getDate(7), res.getString(8)));
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
                req = "INSERT INTO questions (id,description,titre,image,status,createdAt,updatedAt,UserId ) VALUES ('"+ new UUIDGenerator().getUuid().toString()+"','"+o.getDescription()+"','"+o.getTitre()+"','"+o.getImage()+"','actif','"+date+"',,'"+date+"','"+cu.getUserInfo().get(0).getId()+"')";
                }
                else{
                  req = "INSERT INTO questions (id,description,titre,image,status,createdAt,updatedAt,UserId) VALUES ('"+new UUIDGenerator().getUuid().toString()+"','"+o.getDescription()+"','"+o.getTitre()+"','null','actif','"+date+"',,'"+date+"','"+cu.getUserInfo().get(0).getId()+"')";
                  
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
           String req = "DELETE FROM questions where id=?";
           String req1 = "DELETE FROM reponses where idQuestion=?";
           String req2 = "DELETE FROM aimes where idQuestion=?";
          PreparedStatement pst = cnx.prepareStatement(req);
          PreparedStatement pst1 = cnx.prepareStatement(req1);
          PreparedStatement pst2 = cnx.prepareStatement(req2);
           pst.setString(1, o.getId());
           pst1.setString(1, o.getId());
           pst2.setString(1, o.getId());
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
                   
                        String req = "UPDATE questions SET description=?,titre=?,image=? where id =?";
                        pst = cnx.prepareStatement(req);
                        pst.setString(1, o.getDescription());
                        pst.setString(2, o.getTitre());
                        pst.setString(3, o.getImage());
                        pst.setString(4, o.getId());
                   
                }
                else{
                    
                        String req = "UPDATE question SET description=?,titre=? where idQuestion =?";
                        pst = cnx.prepareStatement(req);
                        pst.setString(1, o.getDescription());
                        pst.setString(2, o.getTitre());
                        pst.setString(3, o.getId());
                   
                }
                
                pst.executeUpdate();
                System.out.println("Question modifiée !");
            } catch (SQLException ex) {
                Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

    
}
