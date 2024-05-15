package BACK.DAO;

import BACK.Class.Empleado;
import BACK.Interfaz.Utiles;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EmpleadoDAO implements Utiles {
    @Override
    public boolean crear() {
        boolean crear = true;
        BufferedReader br = null;
        try{
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/InsertEmpleados.txt" ) );
            String dni = br.readLine ();
            String nombre = br.readLine ();
            String apellido = br.readLine ();
            String apellido2 = br.readLine ();
            String email = br.readLine ();
            int telefono = Integer.valueOf ( br.readLine ());
            String puesto = br.readLine ();
            String contrasena = br.readLine ();
            String sql = "INSERT INTO Empleado VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            Connection connection = Utiles.conectar ();
            try {
                PreparedStatement sentencia = connection.prepareStatement(sql);
                sentencia.setString(1, dni);
                sentencia.setString(2, nombre);
                sentencia.setString(3, apellido);
                sentencia.setString(4, apellido2);
                sentencia.setString(5, email);
                sentencia.setInt(6, telefono);
                sentencia.setString(7, puesto);
                sentencia.setString(8, contrasena);
                sentencia.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al insertar");
                crear = false;
            }
            return crear;
        }
        catch (IOException e)
        {
            System.out.println (e.getMessage ());
            crear = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                System.out.println (ex.getMessage ());
                crear = false;
            }
        }
        return crear;
    }

    @Override
    public boolean eliminar() {
        boolean eliminar = true;
        BufferedReader br = null;
        try{
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/DeleteEmpleados.txt" ) );
            String id =br.readLine ();
            String sql = "DELETE FROM Empleado WHERE dni = ?";
            Connection connection = Utiles.conectar ();
            try {
                PreparedStatement sentencia = connection.prepareStatement(sql);
                sentencia.setString(1, id);
                sentencia.executeUpdate();
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error al eliminar");
                eliminar = false;
            }
        }
        catch (IOException e)
        {
            System.out.println (e.getMessage ());
            eliminar = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                System.out.println (ex.getMessage ());
                eliminar = false;
            }
        }
        return eliminar;
    }

    @Override
    public boolean modificar() {
        boolean modificar = true;
        BufferedReader br = null;
        try{

            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/UpdateEmpleados.txt" ) );
            int n = Integer.valueOf ( br.readLine () );
            String dni = br.readLine ();
            for(int i=0;i<n;i++) {
                String campo = br.readLine ();
                String valor = br.readLine ();
                String sql = "UPDATE Empleado SET " + campo + " = ? WHERE dni = ?";
                Connection connection = Utiles.conectar ();
                try {
                    PreparedStatement sentencia = connection.prepareStatement ( sql );
                    sentencia.setString ( 1, valor );
                    sentencia.setString ( 2, dni );
                    sentencia.executeUpdate ();
                    connection.close ();
                } catch (SQLException ex) {
                    System.out.println ( "Error al modificar." );
                    modificar = false;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println (e.getMessage ());
            modificar = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                System.out.println (ex.getMessage ());
                modificar = false;
            }
        }
        return modificar;
    }

    @Override
    public List<Object> listar() {
        List<Empleado> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM empleado";
        Connection connection = Utiles.conectar ();
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
                String contrasena = resultSet.getString ( "contrasena" );
                    Empleado e = new Empleado ( dni, nombre, apellido, apellido2, email, telefono, puesto, contrasena);
                    resultado.add ( e );
            }
            try{
                bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/SelectEmpleados.txt", false ));
                Iterator<Empleado> it = resultado.iterator ();
                bw.write ( String.valueOf ( resultado.size () ));
                bw.newLine ();
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