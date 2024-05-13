package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PANTALLA_INICIO extends JFrame {

    private String info = "";
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            PANTALLA_INICIO pantallaInicio = new PANTALLA_INICIO();
            pantallaInicio.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PANTALLA_INICIO() {
        setTitle("Pantalla Principal");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnGestionProductos = new JButton("Gestión de productos");
        btnGestionProductos.setBounds(50, 100, 300, 30);
        btnGestionProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionProductosFrame().setVisible(true);
            }
        });
        add(btnGestionProductos);

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        btnConsultarInventario.setBounds(50, 20, 300, 30);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });
        add(btnConsultarInventario);

        JButton btnRealizarVenta = new JButton("Realizar venta");
        btnRealizarVenta.setBounds(50, 180, 300, 30);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarVentaFrame().setVisible(true);
            }
        });
        add(btnRealizarVenta);

        JButton btnGestionarEmpleados = new JButton("Gestión de empleados");
        btnGestionarEmpleados.setBounds(50, 140, 300, 30);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionarEmpleadosFrame().setVisible(true);
            }
        });
        add(btnGestionarEmpleados);

        JButton btnConsultarVentas = new JButton("Consultar las ventas");
        btnConsultarVentas.setBounds(50, 60, 300, 30);
        btnConsultarVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarVentasFrame().setVisible(true);
            }
        });
        add(btnConsultarVentas);
    }
}


