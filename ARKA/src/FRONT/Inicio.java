package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import java.awt.*;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("Usuario:", usuarioField = new JTextField(20));
        addFieldWithMargin("Contraseña:", contraseñaField = new JTextField(20));

        JButton btnPantallaInicio = new JButton("Acceder");
        btnPantallaInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = new String(contraseñaField.getText());
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog(null, "Rellene los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                }
                else {
                    info = usuario + "," + contrasena;
                    LecturaYEscrituraDeFicheros.Login(info);
                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        dispose();
                        new Menu().setVisible(true);
                    }
                    else {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(Inicio.this, LecturaYEscrituraDeFicheros.error(), "Aviso", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnPantallaInicio);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(buttonPanel);
        pack();
        setLocationRelativeTo(null);
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