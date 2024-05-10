package BACK.Class;

import java.util.List;

public class Venta{
    private final String id = "id";
    private int id_producto;
    private int unidades;
    private final String fecha = "now()";

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

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Venta(int id_producto, int unidades) {
        this.id_producto = id_producto;
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id='" + id + '\'' +
                ", id_producto=" + id_producto +
                ", unidades=" + unidades +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
