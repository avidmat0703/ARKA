package FRONT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarEmpleadosFrame extends JFrame {
    public GestionarEmpleadosFrame() {
        setTitle("Gestión de empleados");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton btnAltaEmpleado = new JButton("Alta de empleado");
        btnAltaEmpleado.setBounds(50, 20, 300, 30);
        btnAltaEmpleado.addActionListener(new ActionListener () {
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
