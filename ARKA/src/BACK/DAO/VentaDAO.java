package BACK.DAO;
import BACK.Class.LecturaYEscrituraDeFicheros;
import BACK.Class.Venta;
import BACK.Interfaz.UtilesDAO;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VentaDAO  implements UtilesDAO {


    @Override
    public boolean crear() {
        boolean crear = true;
        BufferedReader br = null;
        try{
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/InsertVentas.txt" ) );
            int id_producto = Integer.valueOf(br.readLine ());
            int unidades = Integer.valueOf(br.readLine ());
            String sql = "INSERT INTO Venta (id_producto, unidades) VALUES(?, ?)";
            Connection connection = UtilesDAO.conectar ();
            if(connection != null) {
                try {
                    PreparedStatement sentencia = connection.prepareStatement ( sql );
                    sentencia.setInt ( 1, id_producto );
                    sentencia.setInt ( 2, unidades );
                    sentencia.executeUpdate ();
                    connection.close ();
                } catch (SQLException ex) {
                    System.out.println ( ex.getMessage () );
                    LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
                    crear = false;
                }
            }
            else{
                crear = false;
            }
        }
        catch (IOException e)
        {
            System.out.println (e.getMessage ());
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
            crear = false;
        }
        finally {
            try {
                br.close ();
            }
            catch (IOException ex)
            {
                System.out.println (ex.getMessage ());
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
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
    public boolean listar() {
        List<Venta> resultado = new ArrayList<> ();
        boolean listar = true;
        String sql = "SELECT * FROM venta";
        Connection connection = UtilesDAO.conectar ();
        if (connection != null) {
            try{
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                BufferedWriter bw = null;
                while (resultSet.next()) {

                    int id = resultSet.getInt ( "id" );
                    int id_producto = resultSet.getInt ( "id_producto" );
                    int unidades = resultSet.getInt ( "unidades" );
                    double precio_unidad = resultSet.getDouble ( "precio_unidad" );
                    String fecha = resultSet.getString ( "fecha" );
                    double total = resultSet.getDouble ( "total" );
                    Venta v = new Venta ( id, id_producto, unidades, precio_unidad, total, fecha);
                    resultado.add ( v );
                }
                try{
                    bw=new BufferedWriter(new FileWriter ( "ARKA/src/Ficheros/SelectVentas.txt", false ));
                    Iterator<Venta> it = resultado.iterator ();
                    int n = resultado.size ();
                    bw.write ( String.valueOf ( n ) );
                    bw.newLine ();
                    while (it.hasNext ())
                    {
                        Venta v = it.next ();
                        bw.write ( String.valueOf ( v.getId () ) );
                        bw.newLine ();
                        bw.write ( String.valueOf ( v.getId_producto () ) );
                        bw.newLine ();
                        bw.write ( String.valueOf(v.getUnidades () ));
                        bw.newLine ();
                        bw.write ( String.valueOf ( v.getPrecio_unidad () ) );
                        bw.newLine ();
                        bw.write ( String.valueOf ( v.getTotal () ) );
                        bw.newLine ();
                        bw.write ( v.getFecha () );
                        bw.newLine ();
                    }
                }
                catch(IOException e){
                    System.out.println (e.getMessage ());
                    LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
                    listar=false;
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
                LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
                listar=false;
            }
        }
        else
        {
            listar=false;
            LecturaYEscrituraDeFicheros.vaciarVentas ();
        }
        return listar;
    }
}