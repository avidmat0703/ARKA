package BACK.DAO;
import BACK.Class.Venta;
import BACK.Interfaz.Utiles;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VentaDAO  implements Utiles{


    @Override
    public boolean crear() {
        boolean crear = true;
        BufferedReader br = null;
        try{
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/InsertVentas.txt" ) );
            int id_producto = Integer.valueOf(br.readLine ());
            int unidades = Integer.valueOf(br.readLine ());
            String sql = "INSERT INTO Venta (id_producto, unidades) VALUES(?, ?)";
            Connection connection = Utiles.conectar ();
            try {
                PreparedStatement sentencia = connection.prepareStatement(sql);
                sentencia.setInt(1, id_producto);
                sentencia.setInt(2, unidades);
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
        return false;
    }

    @Override
    public boolean modificar() {
        return false;
    }

    @Override
    public List<Object> listar() {
        List<Venta> resultado = new ArrayList<> ();
        String sql = "SELECT * FROM venta";
        Connection connection = Utiles.conectar ();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter bw = null;
            while (resultSet.next()) {

                int id = resultSet.getInt ( "id" );
                int id_producto = resultSet.getInt ( "id_producto" );
                int unidades = resultSet.getInt ( "unidades" );
                String fecha = resultSet.getString ( "fecha" );
                double precio_unidad = resultSet.getDouble ( "precio_unidad" );
                double total = resultSet.getDouble ( "total" );
                Venta v = new Venta ( id, id_producto, unidades, fecha, precio_unidad, total);
                resultado.add ( v );
            }
            try{
                bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/SelectVentas.txt", false ));
                Iterator<Venta> it = resultado.iterator ();
                while (it.hasNext ())
                {
                    Venta v = it.next ();
                    bw.write ( String.valueOf ( v.getId () ) );
                    bw.newLine ();
                    bw.write ( String.valueOf ( v.getId_producto () ) );
                    bw.newLine ();
                    bw.write ( String.valueOf(v.getUnidades () ));
                    bw.newLine ();
                    bw.write ( v.getFecha () );
                    bw.newLine ();
                    bw.write ( String.valueOf ( v.getPrecio_unidad () ) );
                    bw.newLine ();
                    bw.write ( String.valueOf ( v.getTotal () ) );
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