/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Events;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freec
 */
public class EventService implements InterfaceService<Events> {
        private Connection cnx = DataSource.getIstance().getCnx();

    @Override
    public void ajouter(Events o) {
        try {
            String req = "INSERT INTO events ("
                + "event_title, event_image, event_category, event_description, event_start_date, event_end_date,"
                + "event_status, event_location, event_price,event_orgoniser, event_nb_participant, event_max_participant) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, o.getEvent_title());
            pst.setString(2, o.getEvent_image());
            pst.setString(3, o.getEvent_category());
            pst.setString(4, o.getEvent_description());
            pst.setDate(5, o.getEvent_start_date());
            pst.setDate(6, o.getEvent_end_date());
            pst.setString(7, o.getEvent_status());
            pst.setString(8, o.getEvent_location());
            pst.setInt(9, o.getEvent_price());
            pst.setString(10, o.getEvent_orgoniser());
            pst.setInt(11, o.getEvent_nb_participant());
            pst.setInt(12, o.getEvent_max_participant());
            
            pst.executeUpdate();
            System.out.println("Event ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    @Override
//    public void modifier(Events o) {
//        try {
//            String req = "UPDATE personne SET nom=?,prenom=? where id=?";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setString(1, o.getNom());
//            pst.setString(2, o.getPrenom());
//            pst.setInt(3, o.getId());
//            pst.executeUpdate();
//            System.out.println("Personne modifiée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @Override
//    public void supprimer(Events o) {
//        try {
//            String req = "DELETE FROM personne where id=?";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(1, o.getId());
//            pst.executeUpdate();
//            System.out.println("Personne supprimée !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @Override
//    public List<Events> afficher() {
//        List<Events> personnes = new ArrayList<>();
//        
//        try {
//            String req = "SELECT * FROM personne";
//            PreparedStatement pst = cnx.prepareStatement(req);
//            ResultSet res = pst.executeQuery();
//            while(res.next()) {
//                personnes.add(new Events(res.getInt(1), res.getString(2), res.getString("prenom")));
//            }
//            System.out.println("Personnes récupérées !");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        return personnes;
//    }
}
