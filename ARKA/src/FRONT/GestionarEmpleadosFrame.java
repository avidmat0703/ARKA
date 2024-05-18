package FRONT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarEmpleadosFrame extends JFrame {
    public GestionarEmpleadosFrame() {
        setTitle("Gestión de empleados");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        Dimension buttonSize = new Dimension(300, 30);

        JButton btnAltaEmpleado = new JButton("Alta de empleado");
        btnAltaEmpleado.setPreferredSize(buttonSize);
        btnAltaEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AltaEmpleadoFrame().setVisible(true);
            }
        });
        panel.add(btnAltaEmpleado, gbc);

        JButton btnBajaEmpleado = new JButton("Baja de empleado");
        btnBajaEmpleado.setPreferredSize(buttonSize);
        btnBajaEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BajaEmpleadoFrame().setVisible(true);
            }
        });
        panel.add(btnBajaEmpleado, gbc);

        JButton btnModificarEmpleado = new JButton("Modificar empleado");
        btnModificarEmpleado.setPreferredSize(buttonSize);
        btnModificarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ModificarEmpleadoFrame().setVisible(true);
            }
        });
        panel.add(btnModificarEmpleado, gbc);

        pack();
        setMinimumSize(new Dimension(380, 200));
        setLocationRelativeTo(null);
    }
}