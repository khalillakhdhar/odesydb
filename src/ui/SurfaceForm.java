package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ui.SurfaceGlobaleForm;

public class SurfaceForm extends JFrame {

    private JTextField txtPreri;
    private JTextField txtArbre;
    private JTextField txtPleuvial;
    private JTextField txtIrrigue;
    private JButton btnAjouter;
    private int idPersonne; // Pour stocker l'ID de la personne

    public SurfaceForm(final int idPersonne) {
        this.idPersonne = idPersonne; // Stockez l'ID de la personne

        setTitle("إضافة سطح");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtPreri = new JTextField(20);
        txtArbre = new JTextField(20);
        txtPleuvial = new JTextField(20);
        txtIrrigue = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("السطح البري:"));
        panel.add(txtPreri);
        panel.add(new JLabel("السطح المحاط بالأشجار:"));
        panel.add(txtArbre);
        panel.add(new JLabel("السطح المستفيد من مياه الأمطار:"));
        panel.add(txtPleuvial);
        panel.add(new JLabel("السطح المستفيد من الري:"));
        panel.add(txtIrrigue);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int preri = Integer.parseInt(txtPreri.getText());
                int arbre = Integer.parseInt(txtArbre.getText());
                int pleuvial = Integer.parseInt(txtPleuvial.getText());
                int irrigue = Integer.parseInt(txtIrrigue.getText());

                // Insérer les informations de la surface dans la base de données
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO surfaces (preri, arbre, pleuvial, irrigué, id_user) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, preri);
                    statement.setInt(2, arbre);
                    statement.setInt(3, pleuvial);
                    statement.setInt(4, irrigue);
                    statement.setInt(5, idPersonne); // Utilisez l'ID de la personne
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // Après avoir inséré la surface, vous pouvez afficher un message de confirmation.
                JOptionPane.showMessageDialog(SurfaceForm.this, "تمت إضافة السطح بنجاح.");

                // Fermer la fenêtre après l'ajout de la surface
                dispose();
                    SurfaceGlobaleForm surfaceGlobaleForm = new SurfaceGlobaleForm(idPersonne);
        surfaceGlobaleForm.setVisible(true);
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Vous pouvez passer l'ID de la personne en tant qu'argument ici
                int idPersonne = 1; // Remplacez 1 par l'ID de la personne
                SurfaceForm surfaceForm = new SurfaceForm(idPersonne);
                surfaceForm.setVisible(true);
            }
        });
    }
}
