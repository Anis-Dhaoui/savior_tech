/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Publications;

import com.saviortech.models.Reactions;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marwen
 */
public class ServiceReaction implements InterfaceServiceReaction<Reactions> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reactions o) {

        try {
            String req = "INSERT INTO reactions(REACTION,IDUTILISATEUR, IDPUBLICATION) "
                    
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, o.getReaction());
          
            ps.executeUpdate();
            System.out.println("ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reactions> afficher(String id) {
        List<Reactions> pub = new ArrayList<>();
        try {

            String req = "SELECT * FROM `reactions` WHERE reactions.PublicationId = ? ";
                    
                   
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
//               pub.add(new Reactions(res.getString(1)));
              pub.add(new Reactions(null,res.getString(1)));
                
            }

            System.out.println("Reaction récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pub;
    }
}


