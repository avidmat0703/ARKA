package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarVentasFrame extends JFrame {
    private JTable tablaVentas;

    public ConsultarVentasFrame() {
        setTitle("Consultar inventario");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaVentas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        add(scrollPane, BorderLayout.CENTER);
        cargarDatosVentas();
        if(LecturaYEscrituraDeFicheros.error () == null)
        {
            cargarDatosVentas();
        }
        else {
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(ConsultarVentasFrame.this, LecturaYEscrituraDeFicheros.error (),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
            LecturaYEscrituraDeFicheros.escribirError ( "" );
        }
    }

    private void cargarDatosVentas() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID de Venta");
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Unidades");
        modeloTabla.addColumn("Precio unidad");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Fecha");

        for (String[] ventas : LecturaYEscrituraDeFicheros.listarVentas()) {
            modeloTabla.addRow(ventas);
        }

        tablaVentas.setModel(modeloTabla);
    }
}