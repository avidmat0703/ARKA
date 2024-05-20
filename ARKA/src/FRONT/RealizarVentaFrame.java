package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.Interfaz.UtilesFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarVentaFrame extends JFrame {
    private String info = "";
    private JTextField codigoField;
    private JTextField cantidadField;

    public RealizarVentaFrame() {
        setTitle("Realizar venta");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("ID:", codigoField = new JTextField(20));
        addFieldWithMargin("Cantidad:", cantidadField = new JTextField(20));

        JButton ventaButton = new JButton("Realizar venta");
        ventaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                String cantidad = cantidadField.getText();
                if (codigo.isEmpty() || cantidad.isEmpty()) {
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog(RealizarVentaFrame.this, "No deben haber campos vacíos.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                }
                else if(!UtilesFrame.EsInt ( codigo ) || !UtilesFrame.EsInt ( cantidad )){
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog(RealizarVentaFrame.this, "Los campos deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                }
                else {
                    info = codigo + "," + cantidad;
                    LecturaYEscrituraDeFicheros.insertVentas(info);
                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        info = "1," + codigo + ",stock,stock-" + cantidad;
                        LecturaYEscrituraDeFicheros.modificarProducto ( info );
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/bien.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(RealizarVentaFrame.this, "Venta realizada correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                    }
                    else {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(RealizarVentaFrame.this, LecturaYEscrituraDeFicheros.error(),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ventaButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(buttonPanel);
    }

    private void addFieldWithMargin(String label, JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(new JLabel(label));
        panel.add(Box.createHorizontalStrut(10));
        panel.add(field);
        add(panel);
    }
}