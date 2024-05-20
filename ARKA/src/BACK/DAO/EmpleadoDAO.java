package BACK.DAO;

import BACK.Class.Empleado;
import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.Interfaz.UtilesDAO;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmpleadoDAO implements UtilesDAO {
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
                Connection connection = UtilesDAO.conectar ();
                if(connection != null) {
                    try {
                        PreparedStatement sentencia = connection.prepareStatement ( sql );
                        sentencia.setString ( 1, dni );
                        sentencia.setString ( 2, nombre );
                        sentencia.setString ( 3, apellido );
                        sentencia.setString ( 4, apellido2 );
                        sentencia.setString ( 5, email );
                        sentencia.setInt ( 6, telefono );
                        sentencia.setString ( 7, puesto );
                        sentencia.setString ( 8, contrasena );
                        sentencia.executeUpdate ();
                        connection.close ();
                    } catch (SQLException e) {
                        LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
                        crear = false;
                    }
                }
                else{
                    crear = false;
                }
                return crear;

        }
        catch (IOException e)
        {
            crear = false;
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
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
                String sql = "CALL existe_empleado(?)";
                String sql2 = "DELETE FROM Empleado where dni = ?";
                Connection connection = UtilesDAO.conectar ();
                if(connection != null) {
                    try {
                        PreparedStatement sentencia = connection.prepareStatement ( sql );
                        sentencia.setString ( 1, id );
                        sentencia.executeUpdate ();
                        connection.close ();
                    } catch (SQLException ex) {
                        LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                        eliminar = false;
                    }
                }
                if(eliminar) {
                    Connection con = UtilesDAO.conectar ();
                    if (con != null) {
                        try {
                            PreparedStatement sentencia = con.prepareStatement ( sql2 );
                            sentencia.setString ( 1, id );
                            sentencia.executeUpdate ();
                            con.close ();
                        } catch (SQLException ex) {
                            LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                            eliminar = false;
                        }
                    } else {
                        eliminar = false;
                    }
                }
        }
        catch (IOException e)
        {
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
            eliminar = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
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
                    String sql2 = "CALL existe_empleado(?)";
                    Connection connection = UtilesDAO.conectar ();
                    if(connection != null) {
                        try {
                            PreparedStatement sentencia = connection.prepareStatement ( sql );
                            PreparedStatement sentencia2 = connection.prepareStatement ( sql2 );
                            sentencia2.setString ( 1, dni );
                            sentencia.setString ( 1, valor );
                            sentencia.setString ( 2, dni );
                            sentencia.executeUpdate ();
                            sentencia2.executeUpdate ();
                            connection.close ();
                        } catch (SQLException ex) {
                            LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                            modificar = false;
                        }
                    }
                    else {
                        modificar = false;
                    }
                }
        }
        catch (IOException e)
        {
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
            modificar = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                modificar = false;
            }
        }
        return modificar;
    }

    @Override
    public boolean listar() {
        boolean listar = true;
        List<Empleado> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM empleado";

        Connection connection = UtilesDAO.conectar ();
        if(connection != null){
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
                    LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
                    listar = false;
                }
                finally{
                    try{
                        bw.close ();
                    }
                    catch(IOException ex)
                    {
                        ex.getMessage ();
                        LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                        listar=false;
                    }
                }
            } catch (SQLException e) {
                LecturaYEscrituraDeFicheros.escribirError( e.getMessage () );
                listar=false;
            }
        }
        else{
            listar = false;
        }
        return listar;
    }
    public boolean existeYContrasenaCorrecta() {
        boolean existe = true;
        BufferedReader br = null;
        try{
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/Login.txt" ) );
            String usuario = br.readLine ();
            String contrasena = br.readLine ();
                String sql = "CALL existe_empleado(?)";
                String sql2 = "CALL contrasena(?, ?)";
                Connection connection = UtilesDAO.conectar ();
                if(connection != null) {
                    try {
                        PreparedStatement sentencia = connection.prepareStatement ( sql );
                        sentencia.setString ( 1, usuario );
                        sentencia.executeUpdate ();
                        connection.close ();
                    } catch (SQLException ex) {
                        LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                        existe = false;
                    }
                }
                else {
                    existe = false;
                }
                if(existe)
                {
                    Connection con = UtilesDAO.conectar ();
                    if(con != null) {
                        try {
                            PreparedStatement sentencia2 = con.prepareStatement ( sql2 );
                            sentencia2.setString ( 1, usuario );
                            sentencia2.setString ( 2, contrasena );
                            sentencia2.executeUpdate ();
                            con.close ();
                        } catch (SQLException ex) {
                            LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                            existe = false;
                        }
                    }
                }
                else{
                    existe=false;
                }
        }
        catch (IOException e)
        {
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
            existe = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                existe = false;
            }
        }
        return existe;
    }
}