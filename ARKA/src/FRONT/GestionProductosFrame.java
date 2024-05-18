package FRONT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProductosFrame extends JFrame {
    public GestionProductosFrame() {
        setTitle("Gestión de productos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Dimension buttonSize = new Dimension(300, 30);

        JButton btnAlta = new JButton("Alta de producto");
        btnAlta.setPreferredSize(buttonSize);
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaProductosFrame().setVisible(true);
            }
        });
        panel.add(btnAlta, gbc);

        JButton btnBaja = new JButton("Baja de producto");
        btnBaja.setPreferredSize(buttonSize);
        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BajaProductosFrame().setVisible(true);
            }
        });
        panel.add(btnBaja, gbc);

        JButton btnModificar = new JButton("Modificar producto");
        btnModificar.setPreferredSize(buttonSize);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarProductoFrame().setVisible(true);
            }
        });
        panel.add(btnModificar, gbc);

        pack();
        setMinimumSize(new Dimension(380, 200));
        setLocationRelativeTo(null);
    }
}