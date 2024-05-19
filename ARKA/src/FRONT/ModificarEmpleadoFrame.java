package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.Interfaz.UtilesFrame;

import javax.swing.*;
import java.awt.*;
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
                ConsultarEmpleadoFrame frame = new ConsultarEmpleadoFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JButton modificarButton = new JButton("   Modificar este empleado   ");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cont = 0;
                JCheckBox[] checks = {chkNombre, chkApellido1, chkApellido2, chkEmail, chkTelefono, chkPuesto};
                for(JCheckBox check : checks) {
                    if(check.isSelected ()) {
                        cont++;
                    }
                }
                boolean empty=false;
                boolean string = false;
                    info = String.valueOf ( cont + "," + DNIField.getText());
                    if(DNIField.getText ().isEmpty ()) {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog ( ModificarEmpleadoFrame.this, "Debe introducir el DNI de un empleado", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                    }
                    else if(cont ==0){
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog ( ModificarEmpleadoFrame.this, "Debe marcar alguna casilla para hacer cambios.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                    }
                    else {
                    StringBuilder cambios = new StringBuilder("Cambios realizados:\n");
                        if (chkNombre.isSelected()) {
                            cambios.append(" - Nombre modificado: ").append(nombreField.getText()).append("\n");
                            info += "," + "nombre";
                            info += "," + nombreField.getText();
                            if(nombreField.getText ().isEmpty ()) {
                                empty=true;
                            }
                        }
                        if (chkApellido1.isSelected()) {
                            cambios.append(" - Primer apellido modificado: ").append(apellido1Field.getText()).append("\n");
                            info += "," + "apellido";
                            info+= "," + apellido1Field.getText();
                            if(apellido1Field.getText ().isEmpty ()) {
                                empty=true;
                            }
                        }
                        if (chkApellido2.isSelected()) {
                            cambios.append(" - Segundo apellido modificado: ").append(apellido2Field.getText()).append("\n");
                            info += "," + "apellido2";
                            info+= "," + apellido2Field.getText();
                            if(apellido2Field.getText ().isEmpty ()) {
                                empty=true;
                            }
                        }
                        if (chkEmail.isSelected()) {
                            cambios.append(" - Email modificado: ").append(emailField.getText()).append("\n");
                            info += "," + "email";
                            info+= "," + emailField.getText();
                            if(emailField.getText ().isEmpty ()) {
                                empty=true;
                            }
                        }
                        if (chkTelefono.isSelected()) {
                            cambios.append ( " - Teléfono modificado: " ).append ( telefonoField.getText () ).append ( "\n" );
                            info += "," + "telefono";
                            info += "," + telefonoField.getText ();
                            if (telefonoField.getText ().isEmpty ()) {
                                empty = true;
                            }
                            else if(!UtilesFrame.EsInt ( telefonoField.getText () )){
                                string = true;
                            }
                        }
                        if (chkPuesto.isSelected()) {
                            cambios.append(" - Puesto modificado: ").append(puestoField.getText()).append("\n");
                            info += "," + "puesto";
                            info += "," + puestoField.getText();
                            if(puestoField.getText ().isEmpty ()) {
                                empty=true;
                            }
                        }
                        if(empty) {
                            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                            int nuevoAncho = 70;
                            int nuevoAlto = 70;
                            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                            JOptionPane.showMessageDialog(ModificarEmpleadoFrame.this, "Los campos seleccionados no deben estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        }
                        else if(string){
                            ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                            int nuevoAncho = 70;
                            int nuevoAlto = 70;
                            Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                            JOptionPane.showMessageDialog(ModificarEmpleadoFrame.this, "El campo 'Teléfono' debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        }
                        else {
                            LecturaYEscrituraDeFicheros.modificarEmpleado(info);
                            if(LecturaYEscrituraDeFicheros.error () == null) {
                                ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/bien.jpg"));
                                int nuevoAncho = 70;
                                int nuevoAlto = 70;
                                Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                                ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                                JOptionPane.showMessageDialog(ModificarEmpleadoFrame.this, cambios.toString(), "Mensaje", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                                DNIField.setText ( "" );
                                nombreField.setText ( "" );
                                apellido1Field.setText ( "" );
                                apellido2Field.setText ( "" );
                                emailField.setText ( "" );
                                telefonoField.setText ( "" );
                                puestoField.setText ( "" );
                            }
                            else {
                                ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                                int nuevoAncho = 70;
                                int nuevoAlto = 70;
                                Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                                ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                                JOptionPane.showMessageDialog(ModificarEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error (),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                                LecturaYEscrituraDeFicheros.escribirError ( "" );
                            }
                        }
                    }
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

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}