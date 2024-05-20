package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.Interfaz.UtilesFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarProductoFrame extends JFrame {
    private String info = "";
    private JTextField idField;
    private JTextField nombreField;
    private JTextField stockField;
    private JTextField tallaField;
    private JTextField colorField;
    private JTextField marcaField;
    private JTextField precioField;

    private JCheckBox chkNombre;
    private JCheckBox chkStock;
    private JCheckBox chkTalla;
    private JCheckBox chkColor;
    private JCheckBox chkMarca;
    private JCheckBox chkPrecio;

    public ModificarProductoFrame() {
        setTitle("Modificar producto");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("ID del Producto:", idField = new JTextField(20));
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20), chkNombre = new JCheckBox());
        addFieldWithMargin("Stock:", stockField = new JTextField(20), chkStock = new JCheckBox());
        addFieldWithMargin("Talla:", tallaField = new JTextField(20), chkTalla = new JCheckBox());
        addFieldWithMargin("Color:", colorField = new JTextField(20), chkColor = new JCheckBox());
        addFieldWithMargin("Marca:", marcaField = new JTextField(20), chkMarca = new JCheckBox());
        addFieldWithMargin("Precio:", precioField = new JTextField(20), chkPrecio = new JCheckBox());

        JButton listarButton = new JButton("Listar todos los productos");
        listarButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarInventarioFrame frame = new ConsultarInventarioFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JButton modificarButton = new JButton("   Modificar este producto   ");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cont = 0;
                JCheckBox[] checks = {chkNombre, chkStock, chkTalla, chkColor, chkMarca, chkPrecio};
                for(JCheckBox check : checks) {
                    if(check.isSelected ()) {
                        cont++;
                    }
                }
                boolean empty = false;
                boolean neg = false;
                boolean string = false ;
                String msj = "";
                info = String.valueOf ( cont + "," + idField.getText());
                if(idField.getText ().isEmpty ()) {
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog ( ModificarProductoFrame.this, "Debe introducir el ID de un producto.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado );
                }
                else if(cont == 0 ){
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog ( ModificarProductoFrame.this, "Debe marcar alguna casilla para hacer cambios.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado );
                }
                else {
                    if(!UtilesFrame.EsInt ( idField.getText () )){
                        string = true;
                        msj += "El campo 'ID' debe ser numérico.\n";
                    }
                    StringBuilder cambios = new StringBuilder("Cambios realizados:\n");
                    if (chkNombre.isSelected()) {
                        cambios.append(" - Nombre modificado: ").append(nombreField.getText()).append("\n");
                        info += "," + "Tipo_producto";
                        info += "," + nombreField.getText();
                        if(nombreField.getText ().isEmpty ()) {
                            empty=true;
                        }
                    }
                    if (chkStock.isSelected()) {
                        cambios.append(" - Stock modificado: ").append(stockField.getText()).append("\n");
                        info += "," + "stock";
                        info += "," + stockField.getText();
                        if(stockField.getText ().isEmpty ()) {
                            empty=true;
                        }
                        else if(!UtilesFrame.EsInt ( stockField.getText () )){
                            string = true;
                            msj += "El campo 'Stock' debe ser numérico.\n";
                        }
                        else if(Integer.valueOf ( stockField.getText () )<0){
                            neg=true;
                        }
                    }
                    if (chkTalla.isSelected()) {
                        cambios.append(" - Talla modificada: ").append(tallaField.getText()).append("\n");
                        info += "," + "talla";
                        info += "," + tallaField.getText();
                        if(tallaField.getText ().isEmpty ()) {
                            empty=true;
                        }
                    }
                    if (chkColor.isSelected()) {
                        cambios.append(" - Color modificado: ").append(colorField.getText()).append("\n");
                        info += "," + "color";
                        info += "," + colorField.getText();
                        if(colorField.getText ().isEmpty ()) {
                            empty=true;
                        }
                    }
                    if (chkMarca.isSelected()) {
                        cambios.append(" - Marca modificada: ").append(marcaField.getText()).append("\n");
                        info += "," + "marca";
                        info += "," + marcaField.getText();
                        if(marcaField.getText ().isEmpty ()) {
                            empty=true;
                        }
                    }
                    if (chkPrecio.isSelected()) {
                        cambios.append(" - Precio modificado: ").append(precioField.getText()).append("\n");
                        info += "," + "precio";
                        info += "," + precioField.getText();
                        if(precioField.getText ().isEmpty ()) {
                            empty=true;
                        }
                        else if(!UtilesFrame.EsDouble ( precioField.getText () )){
                            string = true;
                            msj += "El campo 'Precio' debe ser numérico.\n";
                        }
                        else if(Integer.valueOf ( precioField.getText () )<0){
                            neg=true;
                        }
                    }
                    if(empty) {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(ModificarProductoFrame.this, "Los campos seleccionados no deben estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                    }
                    else if(neg){
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(ModificarProductoFrame.this, "El precio y el stock no pueden ser negativos.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                    }
                    else if( string ){
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog ( ModificarProductoFrame.this,msj,"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                    }
                    else {
                        LecturaYEscrituraDeFicheros.modificarProducto(info);
                        if(LecturaYEscrituraDeFicheros.error () == null) {
                            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/bien.jpg"));
                            int nuevoAncho = 70;
                            int nuevoAlto = 70;
                            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                            JOptionPane.showMessageDialog(ModificarProductoFrame.this, cambios.toString(), "Mensaje", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                            idField.setText ( "" );
                            nombreField.setText ( "" );
                            stockField.setText ( "" );
                            tallaField.setText ( "" );
                            colorField.setText ( "" );
                            marcaField.setText ( "" );
                            precioField.setText ( "" );
                        }
                        else {
                            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                            int nuevoAncho = 70;
                            int nuevoAlto = 70;
                            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                            JOptionPane.showMessageDialog(ModificarProductoFrame.this, LecturaYEscrituraDeFicheros.error (), "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
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

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}