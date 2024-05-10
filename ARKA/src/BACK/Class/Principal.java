package BACK.Class;

import java.io.*;
import java.sql.*;

public class Principal {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Tienda_de_ropa";

        String archivo = "ARKA/src/Ficheros/Usuario.txt";
        String username = null;
        String password = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            username = reader.readLine();
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (username != null && password != null) {
            System.out.println("Usuario leído del archivo: " + username);
            System.out.println("Contraseña leída del archivo: " + password);
        } else {
            System.out.println("No se pudo leer el archivo correctamente.");
        }
    }
}
