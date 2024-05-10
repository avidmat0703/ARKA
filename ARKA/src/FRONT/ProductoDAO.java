package FRONT;

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
    public boolean darAlta(Object o) {
        return false;
    }

    @Override
    public boolean darBaja(Object o) {
        return false;
    }

    @Override
    public boolean modificar(Object o) {
        return false;
    }

    @Override
    public List<Object> listar(Object o) {
        List<Producto> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM producto";
        Connection connection = conectar ();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter writer = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipoProducto = resultSet.getString("tipo_producto");
                int stock = resultSet.getInt("stock");
                String talla = resultSet.getString("talla");
                String color = resultSet.getString("color");
                String marca = resultSet.getString("marca");
                String linea = String.format("ID: %d, Tipo de Producto: %s, Stock: %d, Talla: %s, Color: %s, Marca: %s%n", id, tipoProducto, stock, talla, color, marca);
                try{
                    bw=new BufferedReader(new FileReader ( "ARKA/src/Ficheros/Usuario.txt" ));
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
                writer.write(linea);
            }
            writer.close();
            System.out.println("Se ha escrito la información de los productos en el archivo productos.txt");
        } catch (SQLException e) {
            System.out.println ("Error al listar productos.");
        }
        return Collections.singletonList ( resultado );
    }
}
