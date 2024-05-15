package FRONT;

import BACK.Class.Empleado;
import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.DAO.EmpleadoDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaEmpleadoFrame extends JFrame {

    private String info = "";
    private JTextField DNIField;
    private JTextField nombreField;
    private JTextField apellido1Field;
    private JTextField apellido2Field;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField puestoField;
    private JTextField contrasenaField;

    public AltaEmpleadoFrame() {
        setTitle("Alta de empleados");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("DNI:", DNIField = new JTextField(20));
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20));
        addFieldWithMargin("Primer apellido:", apellido1Field = new JTextField(20));
        addFieldWithMargin("Segundo apellido:", apellido2Field = new JTextField(20));
        addFieldWithMargin("Email:", emailField = new JTextField(20));
        addFieldWithMargin("Número de teléfono:", telefonoField = new JTextField(20));
        addFieldWithMargin("Puesto:", puestoField = new JTextField(20));
        addFieldWithMargin("Contraseña:", contrasenaField = new JTextField(20));

        JButton altaButton = new JButton("Dar de alta este empleado");
        altaButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                info = DNIField.getText() + "," + nombreField.getText() + "," + apellido1Field.getText() + "," +
                        apellido2Field.getText() + "," + emailField.getText() + "," + telefonoField.getText() + "," +
                        puestoField.getText() + "," + contrasenaField.getText ();
                LecturaYEscrituraDeFicheros.insertEmpleados(info);
                EmpleadoDAO ee = new EmpleadoDAO ();
                    ee.crear ();
                    if(LecturaYEscrituraDeFicheros.error () == null)
                    {
                        JOptionPane.showMessageDialog(AltaEmpleadoFrame.this,"Empleado creado correctamente.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(AltaEmpleadoFrame.this,LecturaYEscrituraDeFicheros.error ());
                        LecturaYEscrituraDeFicheros.escribirError ( "" );
                    }

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
