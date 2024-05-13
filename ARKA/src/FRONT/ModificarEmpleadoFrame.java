package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarEmpleadoFrame extends JFrame {

    private String info = "";
    private JTextField DNIField;
    private JTextField nombreField;
    private JTextField apellido1Field;
    private JTextField apellido2Field;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField puestoField;

    private JCheckBox chkNombre;
    private JCheckBox chkApellido1;
    private JCheckBox chkApellido2;
    private JCheckBox chkEmail;
    private JCheckBox chkTelefono;
    private JCheckBox chkPuesto;

    public ModificarEmpleadoFrame() {
        setTitle("Modificar empleado");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addFieldWithMargin("DNI:", DNIField = new JTextField(20));
        addFieldWithMargin("Nombre:", nombreField = new JTextField(20), chkNombre = new JCheckBox());
        addFieldWithMargin("Primer apellido:", apellido1Field = new JTextField(20), chkApellido1 = new JCheckBox());
        addFieldWithMargin("Segundo apellido:", apellido2Field = new JTextField(20), chkApellido2 = new JCheckBox());
        addFieldWithMargin("Email:", emailField = new JTextField(20), chkEmail = new JCheckBox());
        addFieldWithMargin("Número de teléfono:", telefonoField = new JTextField(20), chkTelefono = new JCheckBox());
        addFieldWithMargin("Puesto:", puestoField = new JTextField(20), chkPuesto = new JCheckBox());

        JButton listarButton = new JButton("Listar todos los empleados");
        listarButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConsultarEmpleadoFrame().setVisible(true);
            }
        });

        JButton modificarButton = new JButton("   Modificar este empleado   ");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                info = DNIField.getText() + ", " + nombreField.getText() + ", " + apellido1Field.getText() + ", " +
                        apellido2Field.getText() + ", " + emailField.getText() + ", " + telefonoField.getText() + ", " +
                        puestoField.getText();
                LecturaYEscrituraDeFicheros.modificarEmpleado(info);

                StringBuilder cambios = new StringBuilder("Cambios realizados:\n");
                if (chkNombre.isSelected()) {
                    cambios.append(" - Nombre modificado: ").append(nombreField.getText()).append("\n");
                }
                if (chkApellido1.isSelected()) {
                    cambios.append(" - Primer apellido modificado: ").append(apellido1Field.getText()).append("\n");
                }
                if (chkApellido2.isSelected()) {
                    cambios.append(" - Segundo apellido modificado: ").append(apellido2Field.getText()).append("\n");
                }
                if (chkEmail.isSelected()) {
                    cambios.append(" - Email modificado: ").append(emailField.getText()).append("\n");
                }
                if (chkTelefono.isSelected()) {
                    cambios.append(" - Teléfono modificado: ").append(telefonoField.getText()).append("\n");
                }
                if (chkPuesto.isSelected()) {
                    cambios.append(" - Puesto modificado: ").append(puestoField.getText()).append("\n");
                }
                JOptionPane.showMessageDialog(ModificarEmpleadoFrame.this, cambios.toString());
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
