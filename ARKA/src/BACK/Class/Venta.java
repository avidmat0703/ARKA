package BACK.Class;

import java.util.List;

public class Venta{
    private int id;
    private int id_producto;
    private int unidades;
    private double precio_unidad;
    private double total;
    private String fecha;

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

    public Venta(int id, int id_producto, int unidades, double precio_unidad,double total, String fecha) {
        this.id = id;
        this.id_producto = id_producto;
        this.unidades = unidades;
        this.precio_unidad = precio_unidad;
        this.total = total;
        this.fecha = fecha;
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
