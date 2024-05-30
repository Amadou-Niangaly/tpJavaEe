package com.mycontact.dao;

import com.mycontact.classe.Contact;
import com.mycontact.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String competence = rs.getString("competence");
                contacts.add(new Contact(id, nom, prenom, competence));
            }
        }

        return contacts;
    }

    public void addContact(Contact contact) throws SQLException {
        String query = "INSERT INTO contacts (nom, prenom, competence) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, contact.getNom());
            pstmt.setString(2, contact.getPrenom());
            pstmt.setString(3, contact.getCompetence());
            pstmt.executeUpdate();
        }
    }

    public void updateContact(Contact contact) throws SQLException {
        String query = "UPDATE contacts SET nom = ?, prenom = ?, competence = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, contact.getNom());
            pstmt.setString(2, contact.getPrenom());
            pstmt.setString(3, contact.getCompetence());
            pstmt.setInt(4, contact.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteContact(int id) throws SQLException {
        String query = "DELETE FROM contacts WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public Contact getContactById(int id) throws SQLException {
        String query = "SELECT * FROM contacts WHERE id = ?";
        Contact contact = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String competence = rs.getString("competence");
                    contact = new Contact(id, nom, prenom, competence);
                }
            }
        }

        return contact;
    }
}
