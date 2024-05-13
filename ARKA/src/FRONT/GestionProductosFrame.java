package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProductosFrame extends JFrame {
    public GestionProductosFrame() {
        setTitle("Gestión de productos");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnAlta = new JButton("Alta de producto");
        btnAlta.setBounds(50, 20, 300, 30);
        btnAlta.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                new AltaProductosFrame().setVisible(true);
            }
        });
        add(btnAlta);

        JButton btnBaja = new JButton("Baja de producto");
        btnBaja.setBounds(50, 60, 300, 30);
        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BajaProductosFrame().setVisible(true);
            }
        });
        add(btnBaja);

        JButton btnModificar = new JButton("Modificar producto");
        btnModificar.setBounds(50, 100, 300, 30);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarProductoFrame().setVisible(true);
            }
        });
        add(btnModificar);
    }
}
