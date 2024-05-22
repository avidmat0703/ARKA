package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConsultarEmpleadoFrame extends JFrame {
    private JTable tablaEmpleados;

    public ConsultarEmpleadoFrame() {
        setTitle("Consultar empleados");
        setSize(1200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tablaEmpleados = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosEmpleados();

        if (LecturaYEscrituraDeFicheros.error() != null) {
            mostrarError(LecturaYEscrituraDeFicheros.error());
            LecturaYEscrituraDeFicheros.escribirError("");
        }

        JButton botonActualizar = new JButton("Actualizar la tabla");
        botonActualizar.addActionListener(e -> {
            dispose();
            ConsultarEmpleadoFrame frame = new ConsultarEmpleadoFrame();
            frame.setVisible(true);
            centerFrameOnTop(frame);
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);
        add(panelBoton, BorderLayout.SOUTH);
    }

    private void cargarDatosEmpleados() {
        String[] columnNames = {"DNI", "Nombre", "Primer apellido", "Segundo apellido", "Email", "Teléfono", "Puesto"};
        NonEditableTableModel modeloTabla = new NonEditableTableModel(columnNames, 0);

        for (String[] empleado : LecturaYEscrituraDeFicheros.listarEmpleados()) {
            modeloTabla.addRow(empleado);
        }

        tablaEmpleados.setModel(modeloTabla);
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