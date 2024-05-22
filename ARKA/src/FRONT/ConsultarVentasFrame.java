package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import java.awt.*;

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

        if (LecturaYEscrituraDeFicheros.error() != null) {
            mostrarError(LecturaYEscrituraDeFicheros.error());
            LecturaYEscrituraDeFicheros.escribirError("");
        }

        JButton botonActualizar = new JButton("Actualizar la tabla");
        botonActualizar.addActionListener(e -> {
            dispose();
            ConsultarVentasFrame frame = new ConsultarVentasFrame();
            frame.setVisible(true);
            centerFrameOnTop(frame);
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void cargarDatosVentas() {
        String[] columnNames = {"ID de Venta", "ID Producto", "Unidades", "Precio unidad", "Total", "Fecha"};
        NonEditableTableModel modeloTabla = new NonEditableTableModel(columnNames, 0);

        for (String[] ventas : LecturaYEscrituraDeFicheros.listarVentas()) {
            modeloTabla.addRow(ventas);
        }

        tablaVentas.setModel(modeloTabla);
    }

    private void mostrarError(String mensaje) {
        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
        int nuevoAncho = 70;
        int nuevoAlto = 70;
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
    }

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}