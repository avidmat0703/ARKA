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
            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
            int nuevoAncho = 70;
            int nuevoAlto = 70;
            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            JOptionPane.showMessageDialog(ConsultarInventarioFrame.this, LecturaYEscrituraDeFicheros.error (),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
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
