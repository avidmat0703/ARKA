package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarInventarioFrame extends JFrame {
    private JTable tablaProductos;

    public ConsultarInventarioFrame() {
        setTitle("Consultar inventario");
        setSize(1200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tablaProductos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosProductos();

        if (LecturaYEscrituraDeFicheros.error() == null) {
            cargarDatosProductos();
        }
        else {
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(ConsultarInventarioFrame.this, LecturaYEscrituraDeFicheros.error(), "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
            LecturaYEscrituraDeFicheros.escribirError("");
        }

        JButton botonActualizar = new JButton("Actualizar la tabla");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ConsultarInventarioFrame frame = new ConsultarInventarioFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonActualizar);

        add(panelBoton, BorderLayout.SOUTH);
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

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}