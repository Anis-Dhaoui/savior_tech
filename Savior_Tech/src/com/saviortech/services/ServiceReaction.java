/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Reaction;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marwen
 */
public class ServiceReaction implements InterfaceServiceR<Reaction> {

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
    public List<Reaction> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
