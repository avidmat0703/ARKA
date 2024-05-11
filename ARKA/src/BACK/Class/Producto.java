package BACK.Class;

import BACK.Interfaz.Utiles;

public class Producto {
    private int id;
    private String codigo;

    private String nombre;
    private int stock;
    private String talla;
    private String color;
    private String marca;
    private String descripcion;
    private double precio;

    public Producto(int id, String codigo, String nombre, int stock, String talla, String color, String marca, String descripcion, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.talla = talla;
        this.color = color;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}