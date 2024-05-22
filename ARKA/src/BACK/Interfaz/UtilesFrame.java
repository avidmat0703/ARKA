package BACK.Interfaz;

public interface UtilesFrame {
    public static boolean EsInt(String s) {
        try {
            Integer.parseInt(s); // Para enteros
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean dniCorrecto(String s){
        boolean correcto = true;
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String numeros = "";
        if(s.length ()!=9||s.contains ( " " )||EsInt ( String.valueOf ( s.charAt ( s.length ()-1 ) ) ) || EsDouble ( String.valueOf ( s.charAt ( s.length ()-1 ) ) )){
           correcto = false;
        }
        else {
            for(int i = 0;i<=s.length ()-2;i++) {
                String n =  String.valueOf ( s.charAt ( i ) );
                if (!EsInt (n)) {
                    correcto = false;
                }
                numeros+=n;
            }
            if(correcto){
                char letracorrecta = letras[Integer.valueOf ( numeros ) % 23];
                if(Character.toUpperCase ( s.charAt ( s.length ()-1 )  ) != letracorrecta){
                    correcto = false;
                }
            }
        }
        return correcto;
    }
    public static boolean EsDouble(String s) {
        try {
            Double.parseDouble(s); // Para números de punto flotante
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean esValido(String s){
        if(s.charAt ( 0 ) == ' ')
        {
            return false;
        }
        else{
            return true;
        }
    }
}
