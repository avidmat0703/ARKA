package BACK.Class;

import java.util.List;

public class Venta{
    private int id;
    private int id_producto;
    private int unidades;
    private String fecha;
    private double precio_unidad;
    private double total;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Venta(int id, int id_producto, int unidades, String fecha, double precio_unidad, double total) {
        this.id = id;
        this.id_producto = id_producto;
        this.unidades = unidades;
        this.fecha = fecha;
        this.precio_unidad = precio_unidad;
        this.total = total;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", id_producto=" + id_producto +
                ", unidades=" + unidades +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
