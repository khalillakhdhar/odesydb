package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainForm extends JFrame {

    private JTextField txtNomComplet;
    private JTextField txtGouvernorat;
    private JTextField txtDelegation;
    private JTextField txtSecteur;
    private JTextField txtSexe;
    private JTextField txtNaissance;
    private JTextField txtCin;
    private JTextField txtScolarite;
    private JTextField txtPrincipale;
    private JTextField txtSecondaire;
    private JTextField txtCasSociale;
    private JTextField txtExploitation;
    private JTextField txtPresence;
    private JTextField txtMiniProjet;
    private JButton btnSuivant;

    public MainForm() {
        setTitle("إضافة شخص");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des composants Swing pour le formulaire de la personne
        txtNomComplet = new JTextField(20);
        txtGouvernorat = new JTextField(20);
        txtDelegation = new JTextField(20);
        txtSecteur = new JTextField(20);
        txtSexe = new JTextField(20);
        txtNaissance = new JTextField(20);
        txtCin = new JTextField(20);
        txtScolarite = new JTextField(20);
        txtPrincipale = new JTextField(20);
        txtSecondaire = new JTextField(20);
        txtCasSociale = new JTextField(20);
        txtExploitation = new JTextField(20);
        txtPresence = new JTextField(20);
        txtMiniProjet = new JTextField(20);
        btnSuivant = new JButton("التالي");

        // Création d'un panneau pour organiser les composants
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15, 2));
        panel.add(new JLabel("الاسم الكامل:"));
        panel.add(txtNomComplet);
        panel.add(new JLabel("المعتمدية:"));
        panel.add(txtGouvernorat);
        panel.add(new JLabel("المعتمدية:"));
        panel.add(txtDelegation);
        panel.add(new JLabel("القطاع:"));
        panel.add(txtSecteur);
        panel.add(new JLabel("الجنس:"));
        panel.add(txtSexe);
        panel.add(new JLabel("تاريخ الميلاد (سنة-شهر-يوم):"));
        panel.add(txtNaissance);
        panel.add(new JLabel("رقم البطاقة الوطنية:"));
        panel.add(txtCin);
        panel.add(new JLabel("المستوى الدراسي:"));
        panel.add(txtScolarite);
        panel.add(new JLabel("سنوات التعليم الأساسي:"));
        panel.add(txtPrincipale);
        panel.add(new JLabel("سنوات التعليم الثانوي:"));
        panel.add(txtSecondaire);
        panel.add(new JLabel("الحالة الاجتماعية:"));
        panel.add(txtCasSociale);
        panel.add(new JLabel("الاستغلال:"));
        panel.add(txtExploitation);
        panel.add(new JLabel("الحضور:"));
        panel.add(txtPresence);
        panel.add(new JLabel("المشروع الصغير:"));
        panel.add(txtMiniProjet);
        panel.add(btnSuivant);

        // Gestionnaire d'événements pour le bouton "Suivant"
        btnSuivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupération des données du formulaire de la personne
                String nomComplet = txtNomComplet.getText();
                String gouvernorat = txtGouvernorat.getText();
                String delegation = txtDelegation.getText();
                String secteur = txtSecteur.getText();
                String sexe = txtSexe.getText();
                String naissance = txtNaissance.getText();
                String cin = txtCin.getText();
                String scolarite = txtScolarite.getText();
                int principale = Integer.parseInt(txtPrincipale.getText());
                int secondaire = Integer.parseInt(txtSecondaire.getText());
                String casSociale = txtCasSociale.getText();
                int exploitation = Integer.parseInt(txtExploitation.getText());
                int presence = Integer.parseInt(txtPresence.getText());
                int miniProjet = Integer.parseInt(txtMiniProjet.getText());

                // Insérer la personne dans la base de données et récupérer l'ID généré
                int idPersonne = -1; // Initialisation de l'ID à une valeur impossible
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO personne (nom_complet, gouvernorat, delegation, secteur, sexe, naissance, Cin, scolarite, principale, secondaire, cas_sociale, exploitation, presence, mini_projet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    statement.setString(1, nomComplet);
                    statement.setString(2, gouvernorat);
                    statement.setString(3, delegation);
                    statement.setString(4, secteur);
                    statement.setString(5, sexe);
                    statement.setString(6, naissance);
                    statement.setString(7, cin);
                    statement.setString(8, scolarite);
                    statement.setInt(9, principale);
                    statement.setInt(10, secondaire);
                    statement.setString(11, casSociale);
                    statement.setInt(12, exploitation);
                    statement.setInt(13, presence);
                    statement.setInt(14, miniProjet);
                    statement.executeUpdate();

                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        idPersonne = generatedKeys.getInt(1); // Récupération de l'ID généré
                    }

                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                if (idPersonne != -1) {
                    // Si l'ID de la personne est valide, créer une instance de ConjointForm
                    ConjointForm conjointForm = new ConjointForm(idPersonne);
                    conjointForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(MainForm.this, "Erreur lors de l'ajout de la personne.");
                }

                // Réinitialisation du formulaire
                txtNomComplet.setText("");
                txtGouvernorat.setText("");
                txtDelegation.setText("");
                txtSecteur.setText("");
                txtSexe.setText("");
                txtNaissance.setText("");
                txtCin.setText("");
                txtScolarite.setText("");
                txtPrincipale.setText("");
                txtSecondaire.setText("");
                txtCasSociale.setText("");
                txtExploitation.setText("");
                txtPresence.setText("");
                txtMiniProjet.setText("");
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainForm form = new MainForm();
                form.setVisible(true);
            }
        });
    }
}
