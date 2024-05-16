package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.ProductoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public Menu() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);


        Dimension buttonSize = new Dimension(300, 30);

        JButton btnGestionProductos = new JButton("Gestión de productos");
        btnGestionProductos.setPreferredSize(buttonSize);
        btnGestionProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionProductosFrame().setVisible(true);
            }
        });
        panel.add(btnGestionProductos, gbc);

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        gbc.gridy = 1;
        btnConsultarInventario.setPreferredSize(buttonSize);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });
        panel.add(btnConsultarInventario, gbc);

        JButton btnRealizarVenta = new JButton("Realizar venta");
        gbc.gridy = 2;
        btnRealizarVenta.setPreferredSize(buttonSize);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarVentaFrame().setVisible(true);
            }
        });
        panel.add(btnRealizarVenta, gbc);

        JButton btnGestionarEmpleados = new JButton("Gestión de empleados");
        gbc.gridy = 3;
        btnGestionarEmpleados.setPreferredSize(buttonSize);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionarEmpleadosFrame().setVisible(true);
            }
        });
        panel.add(btnGestionarEmpleados, gbc);

        JButton btnConsultarVentas = new JButton("Consultar las ventas");
        gbc.gridy = 4;
        btnConsultarVentas.setPreferredSize(buttonSize);
        btnConsultarVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarVentasFrame().setVisible(true);
            }
        });
        panel.add(btnConsultarVentas, gbc);

        pack();
        setMinimumSize(new Dimension(400, 260));
        setLocationRelativeTo(null);
        ProductoDAO p = new ProductoDAO ();
        if(!p.stock ()){
            JOptionPane.showMessageDialog(Menu.this, LecturaYEscrituraDeFicheros.error ());
            LecturaYEscrituraDeFicheros.escribirError ( "" );
        }
    }
}