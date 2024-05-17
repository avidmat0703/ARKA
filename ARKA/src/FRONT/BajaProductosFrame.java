package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaProductosFrame extends JFrame {
    private JTextField idField;
    private String info = "";

    public BajaProductosFrame() {
        setTitle("Baja de producto");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("ID del producto:", idField = new JTextField(20));

        JButton listarButton = new JButton("Listar todos los productos");
        listarButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });

        JButton bajaButton = new JButton("Dar de baja este producto");
        bajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (id.isEmpty()) {
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog(BajaProductosFrame.this, "Debe introducir el ID de un producto.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                }
                else {
                    info = idField.getText ();
                    LecturaYEscrituraDeFicheros.eliminarProductos(info);
                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/bien.jpg"));
                        int nuevoAncho = 100;
                        int nuevoAlto = 100;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(BajaProductosFrame.this, "Producto eliminado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                    }
                    else {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(BajaProductosFrame.this, LecturaYEscrituraDeFicheros.error(),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(listarButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(bajaButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
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