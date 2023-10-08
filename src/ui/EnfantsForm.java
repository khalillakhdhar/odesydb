/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Classe pour la table "Enfants"
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnfantsForm extends JFrame {

    private JTextField txt6_18;
    private JTextField txtMoins6;
    private JTextField txt18_40;
    private JTextField txtBesoinSpecifique;
    private JButton btnAjouter;
    private int idPersonne;

    public EnfantsForm(final int idPersonne) {
        this.idPersonne = idPersonne;

        setTitle("إضافة أطفال");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txt6_18 = new JTextField(20);
        txtMoins6 = new JTextField(20);
        txt18_40 = new JTextField(20);
        txtBesoinSpecifique = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("من 6 إلى 18 سنة:"));
        panel.add(txt6_18);
        panel.add(new JLabel("أقل من 6 سنوات:"));
        panel.add(txtMoins6);
        panel.add(new JLabel("من 18 إلى 40 سنة:"));
        panel.add(txt18_40);
        panel.add(new JLabel("احتياجات خاصة:"));
        panel.add(txtBesoinSpecifique);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int _6_18 = Integer.parseInt(txt6_18.getText());
                int moins6 = Integer.parseInt(txtMoins6.getText());
                int _18_40 = Integer.parseInt(txt18_40.getText());
                int besoinSpecifique = Integer.parseInt(txtBesoinSpecifique.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO enfants (id_personne, 6_18, moins_6, 18_40, besoin_specifique) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, idPersonne);
                    statement.setInt(2, _6_18);
                    statement.setInt(3, moins6);
                    statement.setInt(4, _18_40);
                    statement.setInt(5, besoinSpecifique);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(EnfantsForm.this, "تمت إضافة الأطفال بنجاح.");
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
                EnfantsForm form = new EnfantsForm(idPersonne);
                form.setVisible(true);
            }
        });
    }
}
