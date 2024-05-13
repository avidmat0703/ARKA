package BACK.Class;

import FRONT.BajaEmpleadoFrame;
import FRONT.PANTALLA_INICIO;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaYEscrituraDeFicheros {
    public String eliminarEmpleados(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/DeleteEmpleados.txt"));
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return "";
    }
}
