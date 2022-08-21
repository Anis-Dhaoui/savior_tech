/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;


import com.saviortech.models.Utilisateur;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aissa
 */
public class ServiceUtilisateur implements IService<Utilisateur> {

    private final Connection cnx = DataSource.getIstance().getCnx();

    @Override
    public void ajouter(Utilisateur o) {
        try {
            String req = "INSERT INTO utilisateur(fullname, username, email, password, role, domain, interest, speciality) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, o.getFullname());
            pst.setString(2, o.getUsername());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getPassword());
            pst.setString(5, o.getRole());
            pst.setString(6, o.getDomain());
            pst.setString(7, o.getInterest());
            pst.setString(8, o.getSpeciality());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur o) {
        try {
            String req = "UPDATE utilisateur SET fullname=?, username=?, email=?, password=?, role=?, domain=?, interest=?, speciality=? where id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, o.getFullname());
            pst.setString(2, o.getUsername());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getPassword());
            pst.setString(5, o.getRole());
            pst.setString(6, o.getDomain());
            pst.setString(7, o.getInterest());
            pst.setString(8, o.getSpeciality());
            pst.setInt(9, o.getId());
            pst.executeUpdate();
            System.out.println("Personne modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur o) {
        try {
            String req = "DELETE FROM utilisateur where id=" + o.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Utilisateur> afficher() {
        ObservableList<Utilisateur> userList = FXCollections.observableArrayList();

        try {
            String req = "SELECT * FROM utilisateur";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                userList.add(new Utilisateur(res.getInt("id"), res.getString("fullname"), res.getString("username"), res.getString("email"), res.getString("password"), res.getString("role"), res.getString("domain"), res.getString(8), res.getString("speciality")));
            }
            System.out.println("Personnes récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }

}
