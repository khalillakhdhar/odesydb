// Classe pour la table "Logement"
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogementForm extends JFrame {

    private JTextField txtChambres;
    private JTextField txtTraditionnel;
    private JTextField txtCiment;
    private JButton btnAjouter;
    private int idPersonne;

    public LogementForm(final int idPersonne) {
        this.idPersonne = idPersonne;

        setTitle("إضافة سكن");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtChambres = new JTextField(20);
        txtTraditionnel = new JTextField(20);
        txtCiment = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("عدد الغرف:"));
        panel.add(txtChambres);
        panel.add(new JLabel("تقليدي:"));
        panel.add(txtTraditionnel);
        panel.add(new JLabel("سسمنت:"));
        panel.add(txtCiment);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chambres = Integer.parseInt(txtChambres.getText());
                int traditionnel = Integer.parseInt(txtTraditionnel.getText());
                int ciment = Integer.parseInt(txtCiment.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO logement (id_personne, chambres, traditionnel, ciment) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, idPersonne);
                    statement.setInt(2, chambres);
                    statement.setInt(3, traditionnel);
                    statement.setInt(4, ciment);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(LogementForm.this, "تمت إضافة السكن بنجاح.");
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
                LogementForm form = new LogementForm(idPersonne);
                form.setVisible(true);
            }
        });
    }
}
