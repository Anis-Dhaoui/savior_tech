package com.saviortech.services;

import com.saviortech.models.Reponse;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SOMRANI
 */
public class ReponseService implements QrService<Reponse> {
 private Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Reponse o) {
    try {
        java.util.Date d=new java.util.Date();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
                String strDate = dateFormat.format(d);
                String date=strDate;
                String req = "INSERT INTO reponses (message,idQuestion,idUser,date) VALUES ('"+ o.getMessage()+"','"+o.getIdQuestion()+"','"+o.getIdUser()+"','"+date+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Reponse ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}

 @Override
    public List<Reponse> afficher(String id) {
          List<Reponse> reponse = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM reponses where idQuestion="+id+"";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while(res.next()) {
                reponse.add(new Reponse(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getDate(5)));
            }
            System.out.println("Reponse récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reponse; }

    @Override
    public List<Reponse> afficher() {
     return null;
   }

    @Override
    public void supprimer(Reponse o) {
      try {
           String req = "DELETE FROM reponses where id=?";
          PreparedStatement pst = cnx.prepareStatement(req);
           pst.setString(1, o.getId());
          pst.executeUpdate();
          System.out.println("Reponse Supprimée !");
    } catch (SQLException ex) {
         System.out.println(ex.getMessage());
   }}

    @Override
    public void modifier(Reponse o) {
         try {
            String req = "UPDATE reponses SET message=? where id=?";
           PreparedStatement pst = cnx.prepareStatement(req);
           pst.setString(1, o.getMessage());
           pst.setString(2, o.getId());
           pst.executeUpdate();
          System.out.println("Réponse modifiée !");
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
