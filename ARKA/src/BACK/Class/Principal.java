package BACK.Class;

import BACK.DAO.EmpleadoDAO;
import BACK.DAO.ProductoDAO;
import BACK.DAO.VentaDAO;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        ProductoDAO p = new ProductoDAO ();
        //System.out.println (p.crear ());
        //p.modificar ();
        //System.out.println (p.listar ());
        //p.eliminar ();
        //System.out.println (p.listar ());
        EmpleadoDAO e = new EmpleadoDAO ();
        //e.crear ();
        //e.eliminar ();
        //e.modificar ();
        //System.out.println (e.listar ());
        VentaDAO v = new VentaDAO ();
        //v.crear ();
        System.out.println (v.listar ());
        //LecturaYEscrituraDeFicheros.listarVentas ();
    }
}
