package BACK.Interfaz;

public interface UtilesFrame {
    public static boolean EsInt(String str) {
        try {
            Integer.parseInt(str); // Para enteros
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean EsDouble(String str) {
        try {
            Double.parseDouble(str); // Para números de punto flotante
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
