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
        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = DNIField.getText();
                String nombre = nombreField.getText();
                String apellido1 = apellido1Field.getText();
                String apellido2 = apellido2Field.getText();
                String email = emailField.getText();
                String telefono = telefonoField.getText();
                String puesto = puestoField.getText();
                String contrasena = contrasenaField.getText();
                if(!(dni.isEmpty ()||nombre.isEmpty ()||apellido1.isEmpty ()||apellido2.isEmpty ()||email.isEmpty ()||telefono.isEmpty ()||puesto.isEmpty ()||contrasena.isEmpty ()))
                {
                    info=dni + "," + nombre + "," + apellido1 + "," + apellido2 + "," + email + "," + telefono + "," + puesto + "," + contrasena;
                    LecturaYEscrituraDeFicheros.insertEmpleados ( info );
                    if(LecturaYEscrituraDeFicheros.error () == null)
                    {
                        JOptionPane.showMessageDialog(AltaEmpleadoFrame.this,"Empleado creado correctamente.");
                        DNIField.setText("");
                        nombreField.setText("");
                        apellido1Field.setText("");
                        apellido2Field.setText("");
                        emailField.setText("");
                        telefonoField.setText("");
                        puestoField.setText("");
                        contrasenaField.setText ( "" );
                    }
                    else {
                        JOptionPane.showMessageDialog ( AltaEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error () );
                        LecturaYEscrituraDeFicheros.escribirError ( "" );
                    }
                }
                else{
                    JOptionPane.showMessageDialog ( AltaEmpleadoFrame.this,"No pueden haber campos vacíos.","Error", JOptionPane.ERROR_MESSAGE );
                }

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
