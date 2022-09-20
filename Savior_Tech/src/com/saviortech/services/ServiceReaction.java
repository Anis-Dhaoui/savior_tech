/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Publication;
import com.saviortech.models.Reaction;
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
public class ServiceReaction implements InterfaceServiceReaction<Reaction> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Reaction o) {

        try {
            String req = "INSERT INTO reaction(REACTION,IDUTILISATEUR, IDPUBLICATION) "
                    
                    + "VALUES (?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, o.getReaction());
            ps.setInt(2, o.getIdUt());
            ps.setInt(3, o.getIdPub());

            ps.executeUpdate();
            System.out.println("ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Reaction> afficher(int id) {
        List<Reaction> pub = new ArrayList<>();
        try {

            String req = "SELECT REACTION FROM `reaction` WHERE reaction.IDPUBLICATION = ?; ";
                    
                   
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                pub.add(new Reaction(res.getString(1)));

            }

            System.out.println("Reaction récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pub;
    }
}

