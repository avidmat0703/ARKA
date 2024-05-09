package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PANTALLA_INICIO extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            PANTALLA_INICIO pantallaInicio = new PANTALLA_INICIO();
            pantallaInicio.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PANTALLA_INICIO() {
        setTitle("Pantalla Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnAlta = new JButton("Alta de productos");
        btnAlta.setBounds(50, 20, 300, 30);
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaProductosFrame().setVisible(true);
            }
        });
        add(btnAlta);

        JButton btnBaja = new JButton("Baja de productos");
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

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        btnConsultarInventario.setBounds(50, 140, 300, 30);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });
        add(btnConsultarInventario);

        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setBounds(50, 180, 300, 30);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarVentaFrame().setVisible(true);
            }
        });
        add(btnRealizarVenta);

        JButton btnGestionarEmpleados = new JButton("Gestionar empleados");
        btnGestionarEmpleados.setBounds(50, 220, 300, 30);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionarEmpleadosFrame().setVisible(true);
            }
        });
        add(btnGestionarEmpleados);
    }
}

class AltaProductosFrame extends JFrame {
    public AltaProductosFrame() {
        setTitle("Alta de Productos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class BajaProductosFrame extends JFrame {
    public BajaProductosFrame() {
        setTitle("Baja de Productos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class ModificarProductoFrame extends JFrame {
    public ModificarProductoFrame() {
        setTitle("Modificar Producto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public RealizarVentaFrame() {
        setTitle("Realizar Venta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());
        JButton btnCerrar = new JButton("Cerrar Ventana");
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCerrar);
    }
}

class GestionarEmpleadosFrame extends JFrame {
    public GestionarEmpleadosFrame() {
        setTitle("Gestionar Empleados");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}