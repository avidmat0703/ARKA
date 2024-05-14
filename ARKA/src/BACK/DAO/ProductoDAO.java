package BACK.DAO;

import BACK.Class.Accesorio;
import BACK.Class.Prenda;
import BACK.Class.Producto;
import BACK.Interfaz.Utiles;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ProductoDAO  implements Utiles{

    @Override
    public boolean crear() {
        boolean crear = true;
            BufferedReader br = null;
            try{
                br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/InsertProductos.txt" ) );
                String cod = br.readLine ();
                String nombre = br.readLine ();
                int stock = Integer.valueOf(br.readLine ());
                String talla = br.readLine ();
                String color = br.readLine ();
                String marca = br.readLine ();
                String descripcion = br.readLine ();
                double precio = Double.valueOf ( br.readLine () );
                String sql = "INSERT INTO Producto (codigo, tipo_producto, stock, talla, color, marca, descripcion, precio) \n" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                
                Connection connection = Utiles.conectar ();
                if(connection == null)
                {
                    crear = false;
                }
                try {
                    PreparedStatement sentencia = connection.prepareStatement(sql);
                    sentencia.setString ( 1, cod );
                    sentencia.setString(2, nombre);
                    sentencia.setInt(3, stock);
                    sentencia.setString(4, talla);
                    sentencia.setString(5, color);
                    sentencia.setString(6, marca);
                    sentencia.setString(7, descripcion);
                    sentencia.setDouble (8, precio);
                    sentencia.executeUpdate();
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error al insertar");
                    crear = false;
                }
            }
            catch (IOException e)
            {
                System.out.println (e.getMessage ());
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
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/DeleteProductos.txt" ) );
            int id = Integer.valueOf ( br.readLine ());
            String sql = "DELETE FROM Producto WHERE id = ?";
            Connection connection = Utiles.conectar ();
            try {
                PreparedStatement sentencia = connection.prepareStatement(sql);
                sentencia.setInt(1, id);
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
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/UpdateProductos.txt" ) );
            int n = Integer.valueOf ( br.readLine () );
            String id = br.readLine ();
            for(int i=0;i<n;i++)
            {
                String campo = br.readLine ();
                String valor = br.readLine ();
                String sql = "UPDATE Producto SET " + campo  + " = ? WHERE id = ?";
                Connection connection = Utiles.conectar ();
                try {
                    PreparedStatement sentencia = connection.prepareStatement(sql);
                    sentencia.setString(1, valor);
                    sentencia.setString(2, id);
                    sentencia.executeUpdate();
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error al modificar.");
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
        List<Producto> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM producto";
        Connection connection = Utiles.conectar ();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter bw = null;
            while (resultSet.next()) {

                int id = resultSet.getInt ( "id" );
                String cod = resultSet.getString ( "codigo" );
                String tipoProducto = resultSet.getString ( "tipo_producto" );
                int stock = resultSet.getInt ( "stock" );
                String talla = resultSet.getString ( "talla" );
                String color = resultSet.getString ( "color" );
                String marca = resultSet.getString ( "marca" );
                String descripcion = resultSet.getString ( "descripcion" );
                double precio = resultSet.getDouble ( "precio" );
                if(descripcion.equals ( "Accesorio" ))
                {
                    Accesorio a = new Accesorio ( id, cod, tipoProducto, stock, talla, color, marca, precio);
                    resultado.add ( a );
                }
                else
                {
                    Prenda p = new Prenda ( id, cod, tipoProducto, stock, talla, color, marca, precio);
                    resultado.add ( p );
                }
            }
            try{
                bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/SelectProductos.txt", false ));
                Iterator<Producto> it = resultado.iterator ();
                bw.write ( String.valueOf ( resultado.size () ) );
                bw.newLine ();
                while (it.hasNext ())
                {
                    Producto p = it.next ();
                    bw.write ( String.valueOf ( p.getId () ) );
                    bw.newLine ();
                    bw.write ( p.getCodigo () );
                    bw.newLine ();
                    bw.write ( p.getNombre () );
                    bw.newLine ();
                    bw.write ( String.valueOf ( p.getStock () ));
                    bw.newLine ();
                    bw.write ( p.getTalla () );
                    bw.newLine ();
                    bw.write ( p.getColor () );
                    bw.newLine ();
                    bw.write ( p.getMarca () );
                    bw.newLine ();
                    bw.write ( p.getDescripcion () );
                    bw.newLine ();
                    bw.write ( String.valueOf ( p.getPrecio () ) );
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
            System.out.println ("Error al listar productos.");
        }
        return Collections.singletonList ( resultado );
    }
}


