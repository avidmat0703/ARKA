package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
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

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        btnConsultarInventario.setPreferredSize(buttonSize);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsultarInventarioFrame frame = new ConsultarInventarioFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });
        panel.add(btnConsultarInventario, gbc);

        gbc.gridy = 1;
        JButton btnConsultarVentas = new JButton("Consultar ventas");
        btnConsultarVentas.setPreferredSize(buttonSize);
        btnConsultarVentas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsultarVentasFrame frame = new ConsultarVentasFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });
        panel.add(btnConsultarVentas, gbc);

        gbc.gridy = 2;
        JButton btnGestionarEmpleados = new JButton("Gestión de empleados");
        btnGestionarEmpleados.setPreferredSize(buttonSize);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionarEmpleadosFrame frame = new GestionarEmpleadosFrame();
                frame.pack();
                frame.setVisible(true);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = screenSize.width - frame.getWidth();
                int y = 0;
                frame.setLocation(x, y);
            }
        });
        panel.add(btnGestionarEmpleados, gbc);

        gbc.gridy = 3;
        JButton btnGestionProductos = new JButton("Gestión de productos");
        btnGestionProductos.setPreferredSize(buttonSize);
        btnGestionProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GestionProductosFrame frame = new GestionProductosFrame();
                frame.pack();
                frame.setVisible(true);
                frame.setLocation(0, 0);
            }
        });
        panel.add(btnGestionProductos, gbc);

        gbc.gridy = 4;
        JButton btnRealizarVenta = new JButton("Realizar venta");
        btnRealizarVenta.setPreferredSize(buttonSize);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RealizarVentaFrame frame = new RealizarVentaFrame();
                frame.pack();
                frame.setVisible(true);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - frame.getWidth()) / 2;
                int y = 0;
                frame.setLocation(x, y);
            }
        });
        panel.add(btnRealizarVenta, gbc);

        pack();
        setMinimumSize(new Dimension(400, 260));
        setLocationRelativeTo(null);
        if (LecturaYEscrituraDeFicheros.stock() != null) {
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/ojito.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(Menu.this, LecturaYEscrituraDeFicheros.stock(), "Se recomienda reponer este stock", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
        }
    }

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}