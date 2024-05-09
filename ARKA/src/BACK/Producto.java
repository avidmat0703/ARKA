package BACK;

public class Producto {
    private String nombre;
    private int stock;
    private String talla;
    private String descripcion;
    private String color;
    private String marca;

    public Producto(String nombre, int stock, String talla, String descripcion, String color, String marca) {
        this.nombre = nombre;
        this.stock = stock;
        this.talla = talla;
        this.descripcion = descripcion;
        this.color = color;
        this.marca = marca;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", talla='" + talla + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}