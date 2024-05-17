package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarEmpleadoFrame extends JFrame {
    private JTable tablaEmpleados;

    public ConsultarEmpleadoFrame() {
        setTitle("Consultar empleados");
        setSize(1200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaEmpleados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane, BorderLayout.CENTER);
        cargarDatosEmpleados();
        if(LecturaYEscrituraDeFicheros.error () == null)
        {
            cargarDatosEmpleados();
        }
        else {
            JOptionPane.showMessageDialog(ConsultarEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error (),"Error", JOptionPane.ERROR_MESSAGE);
            LecturaYEscrituraDeFicheros.escribirError ( "" );
        }
    }

    private void cargarDatosEmpleados() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Primer apellido");
        modeloTabla.addColumn("Segundo apellido");
        modeloTabla.addColumn("Email");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Puesto");

        for (String[] empleado : LecturaYEscrituraDeFicheros.listarEmpleados()) {
            modeloTabla.addRow(empleado);
        }

        tablaEmpleados.setModel(modeloTabla);
    }
}