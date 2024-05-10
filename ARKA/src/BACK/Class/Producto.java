package BACK.Class;

import BACK.Interfaz.Utiles;

public class Producto {
    private int id;
    private String nombre;
    private int stock;
    private String talla;
    private String color;
    private String marca;
    private String descripcion;

    public Producto(int id, String nombre, int stock, String talla, String color, String marca, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.talla = talla;
        this.color = color;
        this.marca = marca;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}