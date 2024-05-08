package PantallaPrb;

import javax.swing.*;
import java.awt.*;

public class PantallaPrb extends JFrame {
    public PantallaPrb() {
        setTitle("Tabla de Elementos de Ropa");

        String[][] datos = {
                {"Camiseta", "10", "S"},
                {"Pantalones", "20", "M"},
                {"Sudaderas", "15", "L"},
                {"Calcetines", "5", "Única"},
                {"Zapatos", "25", "42"},
                {"Cinturones", "8", "M"},
                {"Bañadoress", "12", "L"}
        };

        String[] columnas = {"Prenda", "Stock", "Talla"};

        JTable tabla = new JTable(datos, columnas);

        JScrollPane scrollPane = new JScrollPane(tabla);

        scrollPane.setPreferredSize(new Dimension(400, 200));

        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PantallaPrb formulario = new PantallaPrb();
        formulario.setVisible(true);
    }
}