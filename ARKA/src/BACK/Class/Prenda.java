package BACK.Class;

public class Prenda extends Producto{
    public Prenda(int id, String codigo, String nombre, int stock, String talla, String color, String marca, double precio) {
        super ( id, codigo, nombre, stock, talla, color, marca, "Prenda", precio );
    }

    @Override
    public int getId() {
        return super.getId ();
    }

    @Override
    public String getNombre() {
        return super.getNombre ();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre ( nombre );
    }

    @Override
    public int getStock() {
        return super.getStock ();
    }

    @Override
    public void setStock(int stock) {
        super.setStock ( stock );
    }

    @Override
    public String getTalla() {
        return super.getTalla ();
    }

    @Override
    public void setTalla(String talla) {
        super.setTalla ( talla );
    }

    @Override
    public String getColor() {
        return super.getColor ();
    }

    @Override
    public void setColor(String color) {
        super.setColor ( color );
    }

    @Override
    public String getMarca() {
        return super.getMarca ();
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca ( marca );
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion ();
    }

    @Override
    public String getCodigo() {
        return super.getCodigo ();
    }

    @Override
    public void setCodigo(String codigo) {
        super.setCodigo ( codigo );
    }

    @Override
    public String toString() {
        return super.toString ();
    }
}
