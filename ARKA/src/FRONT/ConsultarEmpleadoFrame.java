package FRONT;

import BACK.DAO.ProductoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarEmpleadoFrame extends JFrame {
    private ProductoDAO productoDAO; // Suponiendo que tienes un DAO para manejar los empleados
    private JTable tablaEmpleados;

    public ConsultarEmpleadoFrame() {
        setTitle("Consultar empleados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Inicializar el DAO
        productoDAO = new ProductoDAO();

        // Crear la tabla de empleados
        tablaEmpleados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane, BorderLayout.CENTER);

        // Cargar los datos de los empleados en la tabla
        cargarDatosEmpleados();
    }

    private void cargarDatosEmpleados() {
        // Obtener la lista de empleados desde la base de datos
        List<Object> empleados = productoDAO.listar();

        // Crear el modelo de la tabla
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

        // Llenar el modelo de la tabla con los datos de los empleados
        for (Object empleado : empleados) {
            Object[] fila = (Object[]) empleado;
            modeloTabla.addRow(fila);
        }

        // Asignar el modelo de la tabla al JTable
        tablaEmpleados.setModel(modeloTabla);
    }
}

