package BACK.Class;

public class Principal {
    public static void main(String[] args) {
        ProductoDAO p = new ProductoDAO ();
        Accesorio a = new Accesorio ( 1, "a", 3, "a", "c", "d" );
        System.out.println (a);
        System.out.println (p.listar ());
    }
}
