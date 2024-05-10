package BACK.Class;

public class Accesorio extends Producto{
    private final String descripcion = "Accesorio";
    public Accesorio(int id, String nombre, int stock, String talla, String color, String marca) {
        super ( id, nombre, stock, talla,color, marca );
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
    public String toString() {
        return super.toString () + ", Descripción='" + descripcion + "\'}";
    }
}
