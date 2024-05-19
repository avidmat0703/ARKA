package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        if (LecturaYEscrituraDeFicheros.error() == null) {
            cargarDatosEmpleados();
        }
        else {
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(ConsultarEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error(), "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
            LecturaYEscrituraDeFicheros.escribirError("");
        }

        JButton botonActualizar = new JButton("Actualizar la tabla");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConsultarEmpleadoFrame frame = new ConsultarEmpleadoFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);

        add(panelBoton, BorderLayout.SOUTH);
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

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}