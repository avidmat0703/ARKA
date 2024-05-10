package BACK.Class;

public class Prenda extends Producto{
    public Prenda(String nombre, int stock, String talla, String descripcion, String color, String marca) {
        super ( nombre, stock, talla, "Prenda", color, marca);
    }
}
