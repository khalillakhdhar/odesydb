// Classe pour la table "Enfants_Etudes"
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnfantsEtudesForm extends JFrame {

    private JTextField txtMales;
    private JTextField txtFemelles;
    private JButton btnAjouter;
    private int idEmp;

    public EnfantsEtudesForm(final int idEmp) {
        this.idEmp = idEmp;

        setTitle("إضافة أطفال الدراسة");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        txtMales = new JTextField(20);
        txtFemelles = new JTextField(20);
        btnAjouter = new JButton("إضافة");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("عدد الذكور:"));
        panel.add(txtMales);
        panel.add(new JLabel("عدد الإناث:"));
        panel.add(txtFemelles);
        panel.add(btnAjouter);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int males = Integer.parseInt(txtMales.getText());
                int femelles = Integer.parseInt(txtFemelles.getText());

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agro", "root", "");
                    String sql = "INSERT INTO enfants_etudes (id_emp, males, femelles) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, idEmp);
                    statement.setInt(2, males);
                    statement.setInt(3, femelles);
                    statement.executeUpdate();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(EnfantsEtudesForm.this, "تمت إضافة أطفال الدراسة بنجاح.");
                dispose();
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        int idEmp = 1; // Remplacez par l'ID réel de l'employé

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EnfantsEtudesForm form = new EnfantsEtudesForm(idEmp);
                form.setVisible(true);
            }
        });
    }
}
