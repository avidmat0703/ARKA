package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PANTALLA_INICIO extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            PANTALLA_INICIO pantallaInicio = new PANTALLA_INICIO();
            pantallaInicio.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PANTALLA_INICIO() {
        setTitle("Pantalla Principal");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnGestionProductos = new JButton("Gestión de productos");
        btnGestionProductos.setBounds(50, 20, 300, 30);
        btnGestionProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionProductosFrame().setVisible(true);
            }
        });
        add(btnGestionProductos);

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        btnConsultarInventario.setBounds(50, 60, 300, 30);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });
        add(btnConsultarInventario);

        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setBounds(50, 100, 300, 30);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarVentaFrame().setVisible(true);
            }
        });
        add(btnRealizarVenta);

        JButton btnGestionarEmpleados = new JButton("Gestión de empleados");
        btnGestionarEmpleados.setBounds(50, 140, 300, 30);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionarEmpleadosFrame().setVisible(true);
            }
        });
        add(btnGestionarEmpleados);
    }
}

class GestionProductosFrame extends JFrame {
    public GestionProductosFrame() {
        setTitle("Gestión de productos");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnAlta = new JButton("Alta de producto");
        btnAlta.setBounds(50, 20, 300, 30);
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaProductosFrame().setVisible(true);
            }
        });
        add(btnAlta);

        JButton btnBaja = new JButton("Baja de producto");
        btnBaja.setBounds(50, 60, 300, 30);
        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BajaProductosFrame().setVisible(true);
            }
        });
        add(btnBaja);

        JButton btnModificar = new JButton("Modificar producto");
        btnModificar.setBounds(50, 100, 300, 30);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarProductoFrame().setVisible(true);
            }
        });
        add(btnModificar);
    }
}

class AltaProductosFrame extends JFrame {
    private JRadioButton accesorioRadioButton;
    private JRadioButton prendaRadioButton;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField stockField;
    private JTextField tallaField;
    private JTextField descripcionField;
    private JTextField colorField;
    private JTextField marcaField;
    private JTextField precioField;

    public AltaProductosFrame() {
        setTitle("Alta de Producto");
        setSize(450, 500);
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

        addFieldWithMargin("Código en tienda:", codigoField = new JTextField(20));
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20));
        addFieldWithMargin("Stock:", stockField = new JTextField(20));
        addFieldWithMargin("Talla:", tallaField = new JTextField(20));
        addFieldWithMargin("Descripción:", descripcionField = new JTextField(20));
        addFieldWithMargin("Color:", colorField = new JTextField(20));
        addFieldWithMargin("Marca:", marcaField = new JTextField(20));
        addFieldWithMargin("Precio:", precioField = new JTextField(20));


        JButton altaButton = new JButton("Dar de alta este producto");
        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AltaProductosFrame.this, "Producto añadido correctamente");
                dispose();
            }
        });

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

class BajaProductosFrame extends JFrame {
    private JTextField idField;

    public BajaProductosFrame() {
        setTitle("Baja de Producto");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("ID del producto:", idField = new JTextField(20));

        JButton listarButton = new JButton("Listar todos los productos");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });

        JButton bajaButton = new JButton("Dar de baja este producto");
        bajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BajaProductosFrame.this, "Producto eliminado correctamente");
                dispose();
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

class ModificarProductoFrame extends JFrame {
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
        setTitle("Modificar Producto");
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
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });

        JButton modificarButton = new JButton("   Modificar este producto   ");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder cambios = new StringBuilder("Cambios realizados:\n");
                if (chkCodigo.isSelected()) {
                    cambios.append(" - Código en tienda modificado: ").append(codigoField.getText()).append("\n");
                }
                if (chkNombre.isSelected()) {
                    cambios.append(" - Nombre modificado: ").append(nombreField.getText()).append("\n");
                }
                if (chkStock.isSelected()) {
                    cambios.append(" - Stock modificado: ").append(stockField.getText()).append("\n");
                }
                if (chkTalla.isSelected()) {
                    cambios.append(" - Talla modificada: ").append(tallaField.getText()).append("\n");
                }
                if (chkDescripcion.isSelected()) {
                    cambios.append(" - Descripción modificada: ").append(descripcionField.getText()).append("\n");
                }
                if (chkColor.isSelected()) {
                    cambios.append(" - Color modificado: ").append(colorField.getText()).append("\n");
                }
                if (chkMarca.isSelected()) {
                    cambios.append(" - Marca modificada: ").append(marcaField.getText()).append("\n");
                }
                if (chkPrecio.isSelected()) {
                    cambios.append(" - Precio modificado: ").append(precioField.getText()).append("\n");
                }
                JOptionPane.showMessageDialog(ModificarProductoFrame.this, cambios.toString());
                dispose();
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

class ConsultarInventarioFrame extends JFrame {
    public ConsultarInventarioFrame() {
        setTitle("Consultar Inventario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class RealizarVentaFrame extends JFrame {
    private JTextField codigoField;
    private JTextField cantidadField;
    private JTextField clienteIdField;

    public RealizarVentaFrame() {
        setTitle("Realizar Venta");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("Código en tienda:", codigoField = new JTextField(20));
        addFieldWithMargin("Cantidad:", cantidadField = new JTextField(20));

        JButton ventaButton = new JButton("Realizar Venta");
        ventaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

class GestionarEmpleadosFrame extends JFrame {
    public GestionarEmpleadosFrame() {
        setTitle("Gestión de empleados");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnAltaEmpleado = new JButton("Alta de empleado");
        btnAltaEmpleado.setBounds(50, 20, 300, 30);
        btnAltaEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaEmpleadoFrame().setVisible(true);
            }
        });
        add(btnAltaEmpleado);

        JButton btnBajaEmpleado = new JButton("Baja de empleado");
        btnBajaEmpleado.setBounds(50, 60, 300, 30);
        btnBajaEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BajaEmpleadoFrame().setVisible(true);
            }
        });
        add(btnBajaEmpleado);

        JButton btnModificarEmpleado = new JButton("Modificar empleado");
        btnModificarEmpleado.setBounds(50, 100, 300, 30);
        btnModificarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarEmpleadoFrame().setVisible(true);
            }
        });
        add(btnModificarEmpleado);
    }
}

class AltaEmpleadoFrame extends JFrame {
    public AltaEmpleadoFrame() {

    }
}

class BajaEmpleadoFrame extends JFrame {
    public BajaEmpleadoFrame() {

    }
}

class ModificarEmpleadoFrame extends JFrame {
    public ModificarEmpleadoFrame() {

    }
}