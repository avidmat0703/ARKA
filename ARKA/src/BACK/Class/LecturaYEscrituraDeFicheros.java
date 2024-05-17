package BACK.Class;

import BACK.DAO.EmpleadoDAO;
import BACK.DAO.ProductoDAO;
import BACK.DAO.VentaDAO;

import java.io.*;
import java.util.Arrays;

public class LecturaYEscrituraDeFicheros {

    public static void Login(String info) {
        EmpleadoDAO ee = new EmpleadoDAO ();
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/Login.txt" ) );
            String[] partes = info.split ( "," );
            for (String parte : partes) {
                salida.write ( parte );
                salida.newLine ();
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
            LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
                LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
            }
            System.out.println ( ee.existeYContrasenaCorrecta () );
        }
    }

    public static void eliminarEmpleados(String info) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/DeleteEmpleados.txt" ) );
            salida.write ( info );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            EmpleadoDAO em = new EmpleadoDAO();
            em.eliminar();
        }
    }

    public static void eliminarProductos(String info) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/DeleteProductos.txt" ) );
            salida.write ( info );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            ProductoDAO pp = new ProductoDAO();
            pp.eliminar();
        }
    }

    public static void insertProductos(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/InsertProductos.txt" ) );
            String[] partes = info.split ( "," );
            for (String parte : partes) {
                salida.write ( parte );
                salida.newLine ();
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            ProductoDAO p = new ProductoDAO ();
            p.crear ();
        }
    }

    public static String insertEmpleados(String info) {
        String s = "";
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/InsertEmpleados.txt" ) );
            String[] partes = info.split ( "," );
            for (String parte : partes) {
                salida.write ( parte );
                salida.newLine ();
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            EmpleadoDAO ee = new EmpleadoDAO();
            ee.crear();
        }
        return s;
    }

    public static void insertVentas(String info) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/InsertVentas.txt" ) );
            String[] inf = info.split ( "," );
            salida.write ( inf[0] );
            salida.newLine ();
            salida.write ( inf[1] );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
        }
    }

    public static void modificarEmpleado(String info) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/UpdateEmpleados.txt" ) );
            String[] partes = info.split ( "," );
            for (String parte : partes) {
                salida.write ( parte );
                salida.newLine ();
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            EmpleadoDAO ee = new EmpleadoDAO ();
            ee.modificar ();
        }
    }

    public static void modificarProducto(String info) {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/UpdateProductos.txt" ) );
            String[] partes = info.split ( "," );
            for (String parte : partes) {
                salida.write ( parte );
                salida.newLine ();
            }
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
            ProductoDAO p = new ProductoDAO ();
            p.modificar ();
        }
    }

    public static String[][] listarEmpleados() {
        EmpleadoDAO ee = new EmpleadoDAO ();
        String[][] resultado = new String[0][0];
        vaciarEmpleados ();
        if (ee.listar ()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/SelectEmpleados.txt" ) );
                int n = Integer.valueOf ( br.readLine () );
                String[][] s = new String[n][7];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 7; j++) {
                        s[i][j] = br.readLine ();

                    }
                    System.out.println ( Arrays.toString ( s[i] ) );
                }
                resultado = s;
            } catch (IOException ex) {
                System.out.println ( ex.getMessage () );
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
            } finally {
                try {
                    br.close ();
                } catch (IOException e) {
                    System.out.println ( e.getMessage () );
                }
            }
        }
        return resultado;
    }

    public static String[][] listarProductos() {
        ProductoDAO p = new ProductoDAO ();
        String[][] resultado = new String[0][0];
        vaciarProductos ();
        if (p.listar ()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/SelectProductos.txt" ) );
                int n = Integer.valueOf ( br.readLine () );
                String[][] s = new String[n][9];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 9; j++) {
                        s[i][j] = br.readLine ();
                    }
                    System.out.println ( Arrays.toString ( s[i] ) );
                }
                resultado = s;
            } catch (IOException ex) {
                System.out.println ( ex.getMessage () );
            } finally {
                try {
                    br.close ();
                } catch (IOException e) {
                    System.out.println ( e.getMessage () );
                }
            }
        }
        return resultado;
    }

    public static String[][] listarVentas() {
        VentaDAO v = new VentaDAO ();
        String[][] resultado = new String[0][0];
        vaciarVentas ();
        if (v.listar ()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/SelectVentas.txt" ) );
                int n = Integer.valueOf ( br.readLine () );
                String[][] s = new String[n][6];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 6; j++) {
                        s[i][j] = br.readLine ();

                    }
                    System.out.println ( Arrays.toString ( s[i] ) );
                }
                resultado = s;
            } catch (IOException ex) {
                System.out.println ( ex.getMessage () );
            } finally {
                try {
                    br.close ();
                } catch (IOException e) {
                    System.out.println ( e.getMessage () );
                }
            }
        }
        return resultado;
    }

    public static String error() {
        BufferedReader br = null;
        String error = "";
        try {
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/Error.txt" ) );
            error = br.readLine ();
        } catch (IOException e) {
            System.out.println ( e.getMessage () );
        } finally {
            try {
                br.close ();
            } catch (IOException ex) {
                System.out.println ( ex.getMessage () );
            }
        }
        return error;
    }

    public static void escribirError(String s) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/Error.txt" ) );
            bw.write ( s );
        } catch (IOException e) {
            System.out.println ( e.getMessage () );
        } finally {
            try {
                bw.close ();
            } catch (IOException ex) {
                ex.getMessage ();
            }
        }
    }

    public static void vaciarProductos() {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/SelectProductos.txt" ) );
            salida.write ( "" );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
        }
    }

    public static void vaciarEmpleados() {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/SelectEmpleados.txt" ) );
            salida.write ( "" );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
        }
    }

    public static void vaciarVentas() {
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter ( new FileWriter ( "ARKA/src/Ficheros/SelectVentas.txt" ) );
            salida.write ( "" );
        } catch (IOException ex) {
            System.out.println ( ex.getMessage () );
        } finally {
            try {
                salida.close ();
            } catch (IOException e) {
                System.out.println ( e.getMessage () );
            }
        }
    }

    public static String stock() {
        String resultado = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader ( new FileReader ( "ARKA/src/Ficheros/Stock.txt" ) );
            int n = br.read ();
            while(n!=-1){
                resultado += String.valueOf(Character.valueOf((char) n));
                n=br.read();

            }
        } catch (IOException e) {
            LecturaYEscrituraDeFicheros.escribirError ( e.getMessage () );
        } finally {
            try {
                br.close ();
            } catch (IOException ex) {
                LecturaYEscrituraDeFicheros.escribirError ( ex.getMessage () );
            }
        }
        return  resultado;
    }
}

