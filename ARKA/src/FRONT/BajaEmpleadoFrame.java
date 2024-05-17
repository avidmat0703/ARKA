package FRONT;

import BACK.Class.Empleado;
import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.EmpleadoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajaEmpleadoFrame extends JFrame {
    private String info = "";
    private JTextField DNIField;

    public BajaEmpleadoFrame() {
        setTitle("Baja de empleado");
        setSize(350, 170);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("DNI del empleado:", DNIField = new JTextField(20));

        JButton listarButton = new JButton("Listar todos los empleados");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new ConsultarEmpleadoFrame().setVisible(true);
            }
        });

        JButton bajaButton = new JButton("   Eliminar este empleado   ");
        bajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor del campo DNI
                String dni = DNIField.getText();

                if (dni.isEmpty()) {

                    JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, "El campo DNI debe estar completo.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    info = dni;

                    LecturaYEscrituraDeFicheros.eliminarEmpleados(info);

                    EmpleadoDAO em = new EmpleadoDAO();
                    em.eliminar();

                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, "Empleado eliminado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error());
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }

                    dispose();
                }
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
