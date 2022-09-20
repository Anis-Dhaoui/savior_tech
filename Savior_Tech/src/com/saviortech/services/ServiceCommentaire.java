/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Commentaire;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwen
 */
public class ServiceCommentaire implements IServicePublication<Commentaire> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Commentaire o) {
        java.util.Date actuelle = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;

        try {
            String req = "INSERT INTO commentaire (IDPUBLICATION, IDUTILISATEUR, DESCRIPTION, DATE)"
                    + " VALUES (?, ?, ?, ?)";
            // String rep = "INSERT INTO commentaire (idPublication,idUtilisateur,description,date) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, o.getIdPublication());
            ps.setInt(2, o.getIdUtilisateur());
            ps.setString(3, o.getDescription());
            ps.setString(4, dc);
            ps.executeUpdate();
            System.out.println("ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commentaire o) {

        String rep = "UPDATE Commentaire SET description = ? where idCommentaire=?";
    }

    @Override
    public void supprimer(Commentaire o) {
        try {
            String req = "DELETE FROM commentaire where IDCOMMENTAIRE=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, o.getIdCommnetaire());
            ps.executeUpdate();
            System.out.println("supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Commentaire> afficher(int id) {
        List<Commentaire> com = new ArrayList<>();
        try {

            String req = "SELECT commentaire.DESCRIPTION,commentaire.DATE,NOMPRENOM\n"
                    + "                           FROM utilisateur,commentaire \n"
                    + "                           WHERE utilisateur.IDUTILISATEUR = commentaire.IDUTILISATEUR AND commentaire.IDPUBLICATION = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                com.add(new Commentaire(res.getString(1), res.getString(2), res.getString(3)));

            }

            System.out.println("Commentaire récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return com;
    }
}
