package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.ProductoDAO;
import BACK.DAO.VentaDAO;

import javax.swing.*;
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

                    JOptionPane.showMessageDialog(BajaProductosFrame.this, "El campo ID debe estar completo.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    info = id;

                    LecturaYEscrituraDeFicheros.eliminarProductos(info);

                    ProductoDAO p = new ProductoDAO();
                    p.eliminar();

                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        JOptionPane.showMessageDialog(BajaProductosFrame.this, "Producto eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(BajaProductosFrame.this, LecturaYEscrituraDeFicheros.error());
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }

                    dispose();
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
