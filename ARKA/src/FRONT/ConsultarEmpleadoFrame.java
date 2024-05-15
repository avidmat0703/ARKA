package FRONT;

import BACK.Class.LecturaYEscrituraDeFicheros;

import javax.swing.*;

public class ConsultarEmpleadoFrame extends JFrame {
    private String info = "";
    public ConsultarEmpleadoFrame() {
        setTitle("Consultar empleados");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[][]s = LecturaYEscrituraDeFicheros.listarEmpleados ();
    }
}
