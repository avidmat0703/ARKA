package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarVentasFrame extends JFrame {
    private JTable tablaVentas;

    public ConsultarVentasFrame() {
        setTitle("Consultar ventas");
        setSize(1200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tablaVentas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosVentas();

        if (LecturaYEscrituraDeFicheros.error() == null) {
            cargarDatosVentas();
        }
        else {
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(ConsultarVentasFrame.this, LecturaYEscrituraDeFicheros.error(), "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
            LecturaYEscrituraDeFicheros.escribirError("");
        }

        JButton botonActualizar = new JButton("Actualizar la tabla");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConsultarVentasFrame frame = new ConsultarVentasFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);

        add(panelBoton, BorderLayout.SOUTH);
    }

    private void cargarDatosVentas() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID de Venta");
        modeloTabla.addColumn("ID Producto");
        modeloTabla.addColumn("Unidades");
        modeloTabla.addColumn("Precio unidad");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Fecha");

        for (String[] ventas : LecturaYEscrituraDeFicheros.listarVentas()) {
            modeloTabla.addRow(ventas);
        }

        tablaVentas.setModel(modeloTabla);
    }

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}