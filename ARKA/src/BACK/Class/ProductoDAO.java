package BACK.Class;

import BACK.Class.Producto;
import BACK.Interfaz.Utiles;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoDAO  implements Utiles{
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
        List<Producto> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM producto";
        Connection connection = conectar ();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter bw = null;
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String tipoProducto = resultSet.getString("tipo_producto");
                int stock = resultSet.getInt("stock");
                String talla = resultSet.getString("talla");
                String color = resultSet.getString("color");
                String marca = resultSet.getString("marca");
                String descripcion = resultSet.getString("descripcion");
                try{
                    bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/producto.txt", true ));
                    bw.write ( String.valueOf ( id ) );
                    bw.newLine ();
                    bw.write ( tipoProducto );
                    bw.newLine ();
                    bw.write ( String.valueOf ( stock ));
                    bw.newLine ();
                    bw.write ( talla );
                    bw.newLine ();
                    bw.write ( color );
                    bw.newLine ();
                    bw.write ( marca );
                    bw.newLine ();
                    bw.write ( descripcion );
                    bw.newLine ();
                    if(descripcion.equals ( "Accesorio" ))
                    {
                        Accesorio a = new Accesorio ( id, tipoProducto, stock, talla, color, marca);
                        resultado.add ( a );
                    }
                    else
                    {
                        Prenda p = new Prenda ( id, tipoProducto, stock, talla, color, marca);
                        resultado.add ( p );
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
            }
        } catch (SQLException e) {
            System.out.println ("Error al listar productos.");
        }
        return Collections.singletonList ( resultado );
    }
}