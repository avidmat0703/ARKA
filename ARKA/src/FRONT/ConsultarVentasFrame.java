package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.VentaDAO;
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
            JOptionPane.showMessageDialog(ConsultarVentasFrame.this, LecturaYEscrituraDeFicheros.error ());
            LecturaYEscrituraDeFicheros.escribirError ( "" );
        }
    }

    private void cargarDatosVentas() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("ID-Producto");
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