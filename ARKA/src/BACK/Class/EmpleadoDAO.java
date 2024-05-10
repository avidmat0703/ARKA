package BACK.Class;

import BACK.Class.Producto;
import BACK.Interfaz.Utiles;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmpleadoDAO  implements Utiles{
    public static Connection conectar() {
        String usuario=null;
        String contrasena=null;
        BufferedReader br = null;
        try{
            br=new BufferedReader(new FileReader ( "ARKA/src/Ficheros/Usuario.txt" ));
            usuario=br.readLine ();
            contrasena=br.readLine ();
        }
        catch(IOException e){
            System.out.println (e.getMessage ());
        }
        finally{
            try{
                br.close ();
            }
            catch(IOException ex)
            {
                ex.getMessage ();
            }
        }
        Connection con = null;

        String url = "jdbc:mysql://localhost/Tienda";
        try {
            con = DriverManager.getConnection ( url, usuario, contrasena);
        }
        catch (SQLException ex) {
            System.out.println ( "Error al conectar al SGBD." );
        }
        return con;
    }

    @Override
    public boolean darAlta() {
        return false;
    }

    @Override
    public boolean darBaja() {
        return false;
    }

    @Override
    public boolean modificar() {
        return false;
    }

    @Override
    public List<Object> listar() {
        List<Empleado> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM empleado";
        Connection connection = conectar ();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter bw = null;
            while (resultSet.next()) {

                String dni = resultSet.getString ( "DNI" );
                String nombre = resultSet.getString ( "nombre" );
                String  apellido = resultSet.getString ( "apellido" );
                String apellido2 = resultSet.getString ( "apellido2" );
                String email = resultSet.getString ( "email" );
                int telefono = resultSet.getInt ( "telefono" );
                String puesto = resultSet.getString ( "puesto" );
                    Empleado e = new Empleado ( dni, nombre, apellido, apellido2, email, telefono, puesto);
                    resultado.add ( e );
            }
            try{
                bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/Empleados.txt", false ));
                Iterator<Empleado> it = resultado.iterator ();
                while (it.hasNext ())
                {
                    Empleado e = it.next ();
                    bw.write ( e.getDni () );
                    bw.newLine ();
                    bw.write ( e.getNombre () );
                    bw.newLine ();
                    bw.write ( e.getApellido1 () );
                    bw.newLine ();
                    bw.write ( e.getApellido2 () );
                    bw.newLine ();
                    bw.write ( e.getEmail () );
                    bw.newLine ();
                    bw.write ( String.valueOf(e.getTlf () ));
                    bw.newLine ();
                    bw.write ( e.getPuesto () );
                    bw.newLine ();
                }
            }
            catch(IOException e){
                System.out.println (e.getMessage ());
            }
            finally{
                try{
                    bw.close ();
                }
                catch(IOException ex)
                {
                    ex.getMessage ();
                }
            }
        } catch (SQLException e) {
            System.out.println ("Error al listar empleados.");
        }
        return Collections.singletonList ( resultado );
    }
}