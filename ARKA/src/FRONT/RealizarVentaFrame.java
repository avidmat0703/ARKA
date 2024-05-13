package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.VentaDAO;

import javax.swing.*;
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

        addFieldWithMargin("Código en tienda:", codigoField = new JTextField(20));
        addFieldWithMargin("Cantidad:", cantidadField = new JTextField(20));

        JButton ventaButton = new JButton("Realizar venta");
        ventaButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                info = codigoField.getText() + "," + cantidadField.getText();
                LecturaYEscrituraDeFicheros.insertVentas(info);
                VentaDAO v = new VentaDAO();
                v.crear();
                JOptionPane.showMessageDialog(RealizarVentaFrame.this, "Venta realizada correctamente");
                dispose();
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
