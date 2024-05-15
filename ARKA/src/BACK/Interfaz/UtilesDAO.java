package BACK.Interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface UtilesDAO{
    public boolean crear();
    public boolean eliminar();
    public boolean modificar();
    public List<Object> listar();
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
}
