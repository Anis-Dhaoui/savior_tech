/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Publication;
import com.mysql.cj.x.protobuf.Mysqlx;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.saviortech.utils.DataSource;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

public class ServicePublication implements IServicePublication<Publication> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Publication o) {
        Date actuelle = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);

        String dc = date;
        System.err.println(dc);
        try {
            String req = "INSERT INTO publication (titre,description,image,DATE,IDUTILISATEUR) values (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getDescription());
            ps.setString(3, o.getImage());
            ps.setString(4, dc);
            ps.setInt(5, o.getIdUt());
            ps.executeUpdate();
            System.out.println("Ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publication o) {

        try {
            String req = "UPDATE publication SET description=? where idPublication=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, o.getDescription());
            

            ps.setInt(2, o.getIdPublication());
            ps.executeUpdate();
            System.out.println("Modifiée!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Publication o) {
        try {
            String req = "DELETE FROM publication where idPublication=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, o.getIdPublication());
            ps.executeUpdate();
            System.out.println("supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Publication> afficher() {
        List<Publication> pub = new ArrayList<>();
        try {

            String req = "SELECT TITRE,DESCRIPTION,IMAGE,DATE,FULLNAME,IDPUBLICATION\n"
                    + "FROM publication,utilisateur\n"
                    + "WHERE utilisateur.id = publication.IDUTILISATEUR";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet res = ps.executeQuery();
        

            while (res.next()) {
                pub.add(new Publication(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6)));

            }

            System.out.println("Puplication récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pub;
    }

}
