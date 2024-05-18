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
                AltaEmpleadoFrame altaFrame = new AltaEmpleadoFrame();
                altaFrame.setVisible(true);
                setWindowPositionTopRight(altaFrame);
            }
        });
        panel.add(btnAltaEmpleado, gbc);

        JButton btnBajaEmpleado = new JButton("Baja de empleado");
        btnBajaEmpleado.setPreferredSize(buttonSize);
        btnBajaEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BajaEmpleadoFrame bajaFrame = new BajaEmpleadoFrame();
                bajaFrame.setVisible(true);
                setWindowPositionTopRight(bajaFrame);
            }
        });
        panel.add(btnBajaEmpleado, gbc);

        JButton btnModificarEmpleado = new JButton("Modificar empleado");
        btnModificarEmpleado.setPreferredSize(buttonSize);
        btnModificarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificarEmpleadoFrame modificarFrame = new ModificarEmpleadoFrame();
                modificarFrame.setVisible(true);
                setWindowPositionTopRight(modificarFrame);
            }
        });
        panel.add(btnModificarEmpleado, gbc);

        pack();
        setMinimumSize(new Dimension(380, 200));
        setLocationRelativeTo(null);
    }

    private void setWindowPositionTopRight(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width - frame.getWidth();
        int y = 0;
        frame.setLocation(x, y);
    }
}