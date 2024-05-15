package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.VentaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarVentasFrame extends JFrame {
    private VentaDAO ventaDAO;
    private JTable tablaEmpleados;

    public ConsultarVentasFrame() {
        setTitle("Consultar inventario");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ventaDAO = new VentaDAO();
        tablaEmpleados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane, BorderLayout.CENTER);
        cargarDatosEmpleados();
    }

    private void cargarDatosEmpleados() {
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

        tablaEmpleados.setModel(modeloTabla);
    }
}