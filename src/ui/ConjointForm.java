package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConjointForm extends JFrame {

    private JTextField txtCompetences;
    private JTextField txtActivite;
    private JTextField txtSexe;
    private JTextField txtNaissance;
    private JButton btnAjouter;
    private JTextField txtidp;

    public ConjointForm(final int idPersonne) {
        setTitle("إضافة الزوج");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtCompetences = new JTextField(20);
        txtActivite = new JTextField(20);
        txtSexe = new JTextField(20);
        txtNaissance = new JTextField(20);
        btnAjouter = new JButton("إضافة");
        txtidp = new JTextField(Integer.toString(idPersonne)); // Conversion de l'ID en chaîne

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("المهارات:"));
        panel.add(txtCompetences);
        panel.add(new JLabel("النشاط:"));
        panel.add(txtActivite);
        panel.add(new JLabel("الجنس:"));
        panel.add(txtSexe);
        panel.add(new JLabel("تاريخ الميلاد (سنة-شهر-يوم):"));
        panel.add(txtNaissance);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPersonne = Integer.parseInt(txtidp.getText());
                int competences = Integer.parseInt(txtCompetences.getText());
                int activite = Integer.parseInt(txtActivite.getText());
                int sexe = Integer.parseInt(txtSexe.getText());
                String naissance = txtNaissance.getText();

                // Insérer le conjoint dans la base de données (vous devez configurer votre propre connexion)
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO conjoint (id_personne, competences, activite, sexe, naissance) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, idPersonne);
                    statement.setInt(2, competences);
                    statement.setInt(3, activite);
                    statement.setInt(4, sexe);
                    statement.setString(5, naissance);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // Après avoir inséré le conjoint, vous pouvez afficher un message de confirmation.
                JOptionPane.showMessageDialog(ConjointForm.this, "تمت إضافة الزوج بنجاح.");
SurfaceForm surfaceForm = new SurfaceForm(idPersonne);
surfaceForm.setVisible(true);

                // Fermer la fenêtre après l'ajout du conjoint
                dispose();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConjointForm conjointForm = new ConjointForm(1); // Remplacez 1 par l'ID de la personne
                conjointForm.setVisible(true);
            }
        });
    }
}
