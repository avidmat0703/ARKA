package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            Inicio login = new Inicio();
            login.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String info = "";
    private JTextField usuarioField;
    private JTextField contraseñaField;

    public Inicio() {
        setTitle("Inicio");
        setSize(400, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("Usuario:", usuarioField = new JTextField(20));
        addFieldWithMargin("Contraseña:", contraseñaField = new JTextField(20));

        JButton btnPantallaInicio = new JButton("Acceder");
        btnPantallaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
            }
        });
        add(btnPantallaInicio);
    }

    private void addFieldWithMargin(String label, JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(new JLabel(label));
        panel.add(Box.createHorizontalStrut(10));
        panel.add(field);
        add(panel);
    }
}