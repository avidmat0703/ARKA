package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;
import javax.swing.*;
import java.awt.*;
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
                ConsultarEmpleadoFrame frame = new ConsultarEmpleadoFrame();
                frame.setVisible(true);
                centerFrameOnTop(frame);
            }
        });

        JButton bajaButton = new JButton("   Eliminar este empleado   ");
        bajaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dni = DNIField.getText();

                if (!dni.isEmpty()) {
                    info = dni;
                    LecturaYEscrituraDeFicheros.eliminarEmpleados(info);
                    if (LecturaYEscrituraDeFicheros.error() == null) {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/bien.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, "Empleado eliminado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
                    }
                    else {
                        ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                        int nuevoAncho = 70;
                        int nuevoAlto = 70;
                        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                        JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, LecturaYEscrituraDeFicheros.error(),"Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
                        LecturaYEscrituraDeFicheros.escribirError("");
                    }
                }
                else {
                    ImageIcon imagenOriginal = new ImageIcon(Menu.class.getResource("/FRONT/libr/V.jpg"));
                    int nuevoAncho = 70;
                    int nuevoAlto = 70;
                    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
                    ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
                    JOptionPane.showMessageDialog(BajaEmpleadoFrame.this, "Debe introducir el DNI de un empleado.", "Error", JOptionPane.ERROR_MESSAGE, iconoRedimensionado);
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

    private void centerFrameOnTop(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = 0;
        frame.setLocation(x, y);
    }
}