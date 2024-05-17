package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.EmpleadoDAO;
import BACK.DAO.ProductoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarProductoFrame extends JFrame {
    private String info = "";
    private JTextField idField;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField stockField;
    private JTextField tallaField;
    private JTextField descripcionField;
    private JTextField colorField;
    private JTextField marcaField;
    private JTextField precioField;

    private JCheckBox chkCodigo;
    private JCheckBox chkNombre;
    private JCheckBox chkStock;
    private JCheckBox chkTalla;
    private JCheckBox chkDescripcion;
    private JCheckBox chkColor;
    private JCheckBox chkMarca;
    private JCheckBox chkPrecio;

    public ModificarProductoFrame() {
        setTitle("Modificar producto");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("ID del Producto:", idField = new JTextField(20));
        addFieldWithMargin("Código en tienda:", codigoField = new JTextField(20), chkCodigo = new JCheckBox());
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20), chkNombre = new JCheckBox());
        addFieldWithMargin("Stock:", stockField = new JTextField(20), chkStock = new JCheckBox());
        addFieldWithMargin("Talla:", tallaField = new JTextField(20), chkTalla = new JCheckBox());
        addFieldWithMargin("Descripción:", descripcionField = new JTextField(20), chkDescripcion = new JCheckBox());
        addFieldWithMargin("Color:", colorField = new JTextField(20), chkColor = new JCheckBox());
        addFieldWithMargin("Marca:", marcaField = new JTextField(20), chkMarca = new JCheckBox());
        addFieldWithMargin("Precio:", precioField = new JTextField(20), chkPrecio = new JCheckBox());

        JButton listarButton = new JButton("Listar todos los productos");
        listarButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });

        JButton modificarButton = new JButton("   Modificar este producto   ");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cont = 0;
                JCheckBox[] checks = {chkCodigo, chkNombre, chkStock, chkTalla, chkDescripcion, chkColor, chkMarca, chkPrecio};
                for(JCheckBox check : checks)
                {
                    if(check.isSelected ())
                    {
                        cont++;
                    }
                }
                boolean empty = false;
                info = String.valueOf ( cont + "," + idField.getText());
                if(idField.getText ().isEmpty ()) {
                    JOptionPane.showMessageDialog ( ModificarProductoFrame.this, "Debe introducir el ID de un producto.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else{
                    StringBuilder cambios = new StringBuilder("Cambios realizados:\n");
                    if (chkCodigo.isSelected()) {
                        cambios.append(" - Código en tienda modificado: ").append(codigoField.getText()).append("\n");
                        info += "," + "codigo";
                        info += "," + codigoField.getText();
                        if(codigoField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            codigoField.setText ( "" );
                        }
                    }
                    if (chkNombre.isSelected()) {
                        cambios.append(" - Nombre modificado: ").append(nombreField.getText()).append("\n");
                        info += "," + "Tipo_producto";
                        info += "," + nombreField.getText();
                        if(nombreField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            nombreField.setText ( "" );
                        }
                    }
                    if (chkStock.isSelected()) {
                        cambios.append(" - Stock modificado: ").append(stockField.getText()).append("\n");
                        info += "," + "stock";
                        info += "," + stockField.getText();
                        if(stockField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            stockField.setText ( "" );
                        }
                    }
                    if (chkTalla.isSelected()) {
                        cambios.append(" - Talla modificada: ").append(tallaField.getText()).append("\n");
                        info += "," + "talla";
                        info += "," + tallaField.getText();
                        if(tallaField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            tallaField.setText ( "" );
                        }
                    }
                    if (chkDescripcion.isSelected()) {
                        cambios.append(" - Descripción modificada: ").append(descripcionField.getText()).append("\n");
                        info += "," + "descripcion";
                        info += "," + descripcionField.getText();
                        if(descripcionField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            descripcionField.setText ( "" );
                        }
                    }
                    if (chkColor.isSelected()) {
                        cambios.append(" - Color modificado: ").append(colorField.getText()).append("\n");
                        info += "," + "color";
                        info += "," + colorField.getText();
                        if(colorField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                           colorField.setText ( "" );
                        }
                    }
                    if (chkMarca.isSelected()) {
                        cambios.append(" - Marca modificada: ").append(marcaField.getText()).append("\n");
                        info += "," + "marca";
                        info += "," + marcaField.getText();
                        if(marcaField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            marcaField.setText ( "" );
                        }
                    }
                    if (chkPrecio.isSelected()) {
                        cambios.append(" - Precio modificado: ").append(precioField.getText()).append("\n");
                        info += "," + "precio";
                        info += "," + precioField.getText();
                        if(precioField.getText ().isEmpty ())
                        {
                            empty=true;
                        }
                        else{
                            precioField.setText ( "" );
                        }
                    }
                    if(empty){
                        JOptionPane.showMessageDialog(ModificarProductoFrame.this, "Los campos seleccionados no deben estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        LecturaYEscrituraDeFicheros.modificarProducto(info);
                        if(LecturaYEscrituraDeFicheros.error () == null)
                        {
                            JOptionPane.showMessageDialog(ModificarProductoFrame.this, cambios.toString());
                            idField.setText ( "" );
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(ModificarProductoFrame.this, LecturaYEscrituraDeFicheros.error ());
                            LecturaYEscrituraDeFicheros.escribirError ( "" );
                        }
                    }
                }

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(listarButton);
        buttonPanel.add(Box.createVerticalStrut(15));
        buttonPanel.add(modificarButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(buttonPanel);
    }

    private void addFieldWithMargin(String label, JTextField field, JCheckBox checkBox) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(checkBox);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(new JLabel(label));
        panel.add(Box.createHorizontalStrut(10));
        panel.add(field);
        add(panel);
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
