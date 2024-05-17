package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.ProductoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaProductosFrame extends JFrame {

    private String info = "";

    private JRadioButton accesorioRadioButton;
    private JRadioButton prendaRadioButton;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField stockField;
    private JTextField tallaField;
    private JTextField colorField;
    private JTextField marcaField;
    private JTextField precioField;

    public AltaProductosFrame() {
        setTitle("Alta de producto");
        setSize(450, 460);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        accesorioRadioButton = new JRadioButton("Accesorio");
        prendaRadioButton = new JRadioButton("Prenda");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(accesorioRadioButton);
        buttonGroup.add(prendaRadioButton);

        JPanel radioPanel = new JPanel();
        radioPanel.add(accesorioRadioButton);
        radioPanel.add(prendaRadioButton);
        add(radioPanel);

        addFieldWithMargin("Código:", codigoField = new JTextField(20));
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20));
        addFieldWithMargin("Stock:", stockField = new JTextField(20));
        addFieldWithMargin("Talla:", tallaField = new JTextField(20));
        addFieldWithMargin("Color:", colorField = new JTextField(20));
        addFieldWithMargin("Marca:", marcaField = new JTextField(20));
        addFieldWithMargin("Precio:", precioField = new JTextField(20));


        JButton altaButton = new JButton("Dar de alta este producto");
        altaButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText ();
                String nombre = nombreField.getText ();
                String stock = stockField.getText ();
                String talla = tallaField.getText ();
                String color = colorField.getText ();
                String marca = marcaField.getText ();
                String precio = precioField.getText ();

                info = codigoField.getText() + "," + nombreField.getText() + "," + stockField.getText() + "," + tallaField.getText() +  "," + colorField.getText() + "," + marcaField.getText() + "," +
                        precioField.getText();
                if(accesorioRadioButton.isSelected ())
                {
                    info += ",Accesorio";
                }
                if(prendaRadioButton.isSelected ())
                {
                    info += ",Prenda";
                }
                LecturaYEscrituraDeFicheros.insertProductos(info);

                if(LecturaYEscrituraDeFicheros.error () == null )
                {
                    if(codigo.isEmpty () || nombre.isEmpty () || stock.isEmpty () || talla.isEmpty () || color.isEmpty () || marca.isEmpty () || precio.isEmpty ())
                    {
                        JOptionPane.showMessageDialog(AltaProductosFrame.this, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(AltaProductosFrame.this, "Producto añadido correctamente");
                        codigoField.setText("");
                        nombreField.setText("");
                        stockField.setText("");
                        tallaField.setText("");
                        colorField.setText("");
                        marcaField.setText("");
                        precioField.setText("");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(AltaProductosFrame.this, LecturaYEscrituraDeFicheros.error ());
                    LecturaYEscrituraDeFicheros.escribirError( "" );
                }
            }
        });
            /*altaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String codigo = codigoField.getText();
                    String nombre = nombreField.getText();
                    String stock = stockField.getText();
                    String talla = tallaField.getText();
                    String color = colorField.getText();
                    String marca = marcaField.getText();
                    String precio = precioField.getText();


                    else {

                        info = codigo + "," + nombre + "," + stock + "," + talla + "," + color + "," + marca + "," + precio;

                        if (accesorioRadioButton.isSelected()) {
                            info += ",Accesorio";
                        } else if (prendaRadioButton.isSelected()) {
                            info += ",Prenda";
                        }

                        LecturaYEscrituraDeFicheros.insertProductos(info);

                        ProductoDAO p = new ProductoDAO();
                        p.crear();

                        if (LecturaYEscrituraDeFicheros.error() == null) {
                            JOptionPane.showMessageDialog(AltaProductosFrame.this, "Producto añadido correctamente");
                        } else {
                            JOptionPane.showMessageDialog(AltaProductosFrame.this, LecturaYEscrituraDeFicheros.error());
                            LecturaYEscrituraDeFicheros.escribirError("");
                        }

                        dispose();
                    }
                }
            });*/


            JPanel buttonPanel = new JPanel();
        buttonPanel.add(altaButton);
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
