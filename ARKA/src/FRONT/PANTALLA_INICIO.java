package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PANTALLA_INICIO extends JFrame {
    // Constructor
    public PANTALLA_INICIO() {
        // Configuración de la ventana principal
        setTitle("Pantalla Principal");
        setSize(400, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnAltaBaja = new JButton("Alta y Baja de productos");
        btnAltaBaja.setBounds(50, 20, 300, 30);
        btnAltaBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaBajaProductosFrame().setVisible(true);
            }
        });
        add(btnAltaBaja);

        JButton btnModificar = new JButton("Modificar producto");
        btnModificar.setBounds(50, 60, 300, 30);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarProductoFrame().setVisible(true);
            }
        });
        add(btnModificar);

        JButton btnConsultarInventario = new JButton("Consultar inventario");
        btnConsultarInventario.setBounds(50, 100, 300, 30);
        btnConsultarInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsultarInventarioFrame().setVisible(true);
            }
        });
        add(btnConsultarInventario);

        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setBounds(50, 140, 300, 30);
        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RealizarVentaFrame().setVisible(true);
            }
        });
        add(btnRealizarVenta);

        JButton btnGestionarEmpleados = new JButton("Gestionar empleados");
        btnGestionarEmpleados.setBounds(50, 180, 300, 30);
        btnGestionarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GestionarEmpleadosFrame().setVisible(true);
            }
        });
        add(btnGestionarEmpleados);
    }

    public static void main(String[] args) {
        PANTALLA_INICIO pantallaInicio = new PANTALLA_INICIO();
        pantallaInicio.setVisible(true);
    }
}

class AltaBajaProductosFrame extends JFrame {
    public AltaBajaProductosFrame() {
        setTitle("Alta y Baja de Productos");
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