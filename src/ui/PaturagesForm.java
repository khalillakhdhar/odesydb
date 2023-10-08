/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Classe pour la table "Pâturages"
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaturagesForm extends JFrame {

    private JTextField txtNom;
    private JTextField txtDuree;
    private JButton btnAjouter;
    private int idPersonne;

    public PaturagesForm(final int idPersonne) {
        this.idPersonne = idPersonne;

        setTitle("إضافة مرعى");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtNom = new JTextField(20);
        txtDuree = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("الاسم:"));
        panel.add(txtNom);
        panel.add(new JLabel("المدة:"));
        panel.add(txtDuree);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = txtNom.getText();
                int duree = Integer.parseInt(txtDuree.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO pâturages (nom, id_personne, duree) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, nom);
                    statement.setInt(2, idPersonne);
                    statement.setInt(3, duree);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(PaturagesForm.this, "تمت إضافة المرعى بنجاح.");
                dispose();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        int idPersonne = 1; // Remplacez par l'ID réel de la personne

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaturagesForm form = new PaturagesForm(idPersonne);
                form.setVisible(true);
            }
        });
    }
}
