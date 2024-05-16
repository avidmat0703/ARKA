package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;

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
        setSize(400, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("Usuario:", usuarioField = new JTextField(20));
        addFieldWithMargin("Contraseña:", contraseñaField = new JTextField(20));

        JButton btnPantallaInicio = new JButton("Acceder");
        btnPantallaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contraseña = new String(contraseñaField.getText());

                if(usuario.isEmpty() || contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(Inicio.this, "Rellene los campos");
                    LecturaYEscrituraDeFicheros.escribirError("Rellene los campos.");
                } else {
                    info = usuario + ", " + contraseña;
                    LecturaYEscrituraDeFicheros.Login(info);
                    dispose();
                    new Menu().setVisible(true);
                }
            }
        });

        add(btnPantallaInicio);
        setVisible(true);
        add(btnPantallaInicio);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnPantallaInicio);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(buttonPanel);
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