package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StatistiquesApp extends JFrame {
    private JTable table1;

    private JComboBox<String> comboBoxWilaya;
    private JComboBox<String> comboBoxMutamadiya;
    private JComboBox<String> comboBoxImada;

    public StatistiquesApp() {
        setTitle("Statistiques");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Connexion à la base de données
        String url = "jdbc:mysql://127.0.0.1/agro";
        String utilisateur = "root";
        String motDePasse = "";

        // Créer les combobox pour sélectionner les paramètres
        comboBoxWilaya = new JComboBox<>();
        comboBoxMutamadiya = new JComboBox<>();
        comboBoxImada = new JComboBox<>();

        // Créer les boutons pour exécuter la recherche
        JButton rechercherButton = new JButton("Rechercher");
        rechercherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wilaya = comboBoxWilaya.getSelectedItem().toString();
                String mutamadiya = comboBoxMutamadiya.getSelectedItem().toString();
                String imada = comboBoxImada.getSelectedItem().toString();

                // Exécuter la requête SQL avec les paramètres sélectionnés
                try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
                    String query = "SELECT * FROM personne WHERE gouvernorat = ? AND delegation = ? AND secteur = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, wilaya);
                    preparedStatement.setString(2, mutamadiya);
                    preparedStatement.setString(3, imada);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    // Créer le modèle de table pour afficher les résultats
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Nom Complet");
                    model.addColumn("Sexe");
                    model.addColumn("Naissance");

                    while (resultSet.next()) {
                        String nomComplet = resultSet.getString("nom_complet");
                        String sexe = resultSet.getString("sexe");
                        String naissance = resultSet.getString("naissance");

                        model.addRow(new Object[]{nomComplet, sexe, naissance});
                    }

                    // Mettre à jour la JTable avec les résultats
                    table1.setModel(model);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Créer la première JTable pour afficher les résultats
        table1 = new JTable();
        JScrollPane scrollPane1 = new JScrollPane(table1);

        // Créer un panneau pour les combobox et le bouton
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("الولاية: "));
        inputPanel.add(comboBoxWilaya);
        inputPanel.add(new JLabel("المعتمدية: "));
        inputPanel.add(comboBoxMutamadiya);
        inputPanel.add(new JLabel("العمادة: "));
        inputPanel.add(comboBoxImada);
        inputPanel.add(rechercherButton);

        // Créer un panneau principal pour le design
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane1, BorderLayout.CENTER);

        add(mainPanel);

        setLocationRelativeTo(null); // Centrez la fenêtre
        setVisible(true);

        // Charger les données dans les combobox au démarrage
        chargerDonneesCombobox();
    }

    private void chargerDonneesCombobox() {
        // Charger les données des combobox à partir de la base de données
        String url = "jdbc:mysql://127.0.0.1/agro";
        String utilisateur = "root";
        String motDePasse = "";
comboBoxWilaya.addItem("-----");
comboBoxMutamadiya.addItem("-----");
comboBoxImada.addItem("-----");
        try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
            String queryWilaya = "SELECT DISTINCT gouvernorat FROM personne";
            String queryMutamadiya = "SELECT DISTINCT delegation FROM personne";
            String queryImada = "SELECT DISTINCT secteur FROM personne";

            PreparedStatement preparedStatementWilaya = connection.prepareStatement(queryWilaya);
            PreparedStatement preparedStatementMutamadiya = connection.prepareStatement(queryMutamadiya);
            PreparedStatement preparedStatementImada = connection.prepareStatement(queryImada);

            ResultSet resultSetWilaya = preparedStatementWilaya.executeQuery();
            ResultSet resultSetMutamadiya = preparedStatementMutamadiya.executeQuery();
            ResultSet resultSetImada = preparedStatementImada.executeQuery();

            while (resultSetWilaya.next()) {
                comboBoxWilaya.addItem(resultSetWilaya.getString("gouvernorat"));
            }

            while (resultSetMutamadiya.next()) {
                comboBoxMutamadiya.addItem(resultSetMutamadiya.getString("delegation"));
            }

            while (resultSetImada.next()) {
                comboBoxImada.addItem(resultSetImada.getString("secteur"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StatistiquesApp());
    }
}
