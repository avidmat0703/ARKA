package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.ProductoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarInventarioFrame extends JFrame {
    private ProductoDAO productoDAO;
    private JTable tablaEmpleados;

    public ConsultarInventarioFrame() {
        setTitle("Consultar inventario");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        productoDAO = new ProductoDAO();
        tablaEmpleados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane, BorderLayout.CENTER);
        cargarDatosEmpleados();
    }

    private void cargarDatosEmpleados() {
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

        tablaEmpleados.setModel(modeloTabla);
    }
}
