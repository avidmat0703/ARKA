package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.ProductoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarInventarioFrame extends JFrame {
    private JTable tablaProductos;

    public ConsultarInventarioFrame() {
        setTitle("Consultar inventario");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaProductos = new JTable();
        JScrollPane scrollPane = new JScrollPane( tablaProductos );
        add(scrollPane, BorderLayout.CENTER);
        cargarDatosProductos();
        if(LecturaYEscrituraDeFicheros.error () == null)
        {
            cargarDatosProductos();
        }
        else {
            JOptionPane.showMessageDialog(ConsultarInventarioFrame.this, LecturaYEscrituraDeFicheros.error (),"Error", JOptionPane.ERROR_MESSAGE);
            LecturaYEscrituraDeFicheros.escribirError ( "" );
        }
    }

    private void cargarDatosProductos() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("Talla");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Precio");

        for (String[] inventario : LecturaYEscrituraDeFicheros.listarProductos()) {
            modeloTabla.addRow(inventario);
        }

        tablaProductos.setModel(modeloTabla);
    }
}
