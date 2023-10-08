package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurfaceGlobaleForm extends JFrame {

    private JTextField txtType;
    private JTextField txtValeur;
    private JTextField txtPotableAutre;
    private JTextField txtPotableCollectif;
    private JTextField txtPotableIndividuelle;
    private JTextField txtCiterne;
    private JButton btnAjouter;
    private int idPersonne;

    public SurfaceGlobaleForm(final int idPersonne) {
        this.idPersonne = idPersonne;

        setTitle("إضافة سطح عام");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtType = new JTextField(20);
        txtValeur = new JTextField(20);
        txtPotableAutre = new JTextField(20);
        txtPotableCollectif = new JTextField(20);
        txtPotableIndividuelle = new JTextField(20);
        txtCiterne = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.add(new JLabel("النوع:"));
        panel.add(txtType);
        panel.add(new JLabel("القيمة:"));
        panel.add(txtValeur);
        panel.add(new JLabel("مياه الشرب (أخرى):"));
        panel.add(txtPotableAutre);
        panel.add(new JLabel("مياه الشرب (جماعية):"));
        panel.add(txtPotableCollectif);
        panel.add(new JLabel("مياه الشرب (فردية):"));
        panel.add(txtPotableIndividuelle);
        panel.add(new JLabel("السيتيرن:"));
        panel.add(txtCiterne);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = txtType.getText();
                int valeur = Integer.parseInt(txtValeur.getText());
                int potableAutre = Integer.parseInt(txtPotableAutre.getText());
                int potableCollectif = Integer.parseInt(txtPotableCollectif.getText());
                int potableIndividuelle = Integer.parseInt(txtPotableIndividuelle.getText());
                int citerne = Integer.parseInt(txtCiterne.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO surfaceglobale (type, valeur, id_user, potable_autre, potable_collectif, potable_individuelle, citerne) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, type);
                    statement.setInt(2, valeur);
                    statement.setInt(3, idPersonne);
                    statement.setInt(4, potableAutre);
                    statement.setInt(5, potableCollectif);
                    statement.setInt(6, potableIndividuelle);
                    statement.setInt(7, citerne);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(SurfaceGlobaleForm.this, "تمت إضافة السطح العام بنجاح.");
                dispose();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        int idPersonne = 1;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SurfaceGlobaleForm form = new SurfaceGlobaleForm(idPersonne);
                form.setVisible(true);
            }
        });
    }
}

