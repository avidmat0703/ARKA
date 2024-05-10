package BACK.Class;

public class Principal {
    public static void main(String[] args) {
        ProductoDAO p = new ProductoDAO ();
        System.out.println (p.listar ());
        EmpleadoDAO e = new EmpleadoDAO ();
        System.out.println (e.listar ());
    }
}
