package BACK.Class;

import FRONT.BajaEmpleadoFrame;
import FRONT.BajaProductosFrame;
import FRONT.PANTALLA_INICIO;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class LecturaYEscrituraDeFicheros {
    public static void eliminarEmpleados(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/DeleteEmpleados.txt"));
            salida.write(info);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void eliminarProductos(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/DeleteProductos.txt"));
            salida.write(info);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void insertProductos(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/InsertProductos.txt"));
            String[] partes = info.split ( "," );
            for(String parte : partes)
            {
                salida.write ( parte );
                salida.newLine ();
            }
            salida.write(info);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void insertEmpleados(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/InsertEmpleados.txt"));
            String[] partes = info.split ( "," );
            for(String parte : partes)
            {
                salida.write(parte);
                salida.newLine ();
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void insertVentas(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/InsertVentas.txt"));
            String[] inf = info.split(",");
            salida.write(inf[0]);
            salida.newLine ();
            salida.write ( inf[1] );
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void modificarEmpleado(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/UpdateEmpleados.txt"));
            String [] partes = info.split ( "," );
            for(String parte : partes)
            {
                salida.write ( parte );
                salida.newLine ();
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void modificarProducto(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/UpdateProductos.txt"));
            String [] partes = info.split ( "," );
            for(String parte : partes)
            {
                salida.write ( parte );
                salida.newLine ();
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void modificarVentas(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/UpdateVentas.txt"));
            salida.write ( info );
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static String[][] listarEmpleados(){
        String[][]resultado = new String[0][0];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader ("ARKA/src/Ficheros/SelectEmpleados.txt"));
            int n = Integer.valueOf ( br.readLine () );
            String[][] s = new String[n][7];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < 7 ; j++)
                {
                    s[i][j] = br.readLine ();

                }
                System.out.println (Arrays.toString ( s[i] ));
            }
            resultado = s;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                br.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
    public static String[][] listarProductos(){
        String[][]resultado = new String[0][0];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader ("ARKA/src/Ficheros/SelectProductos.txt"));
            int n = Integer.valueOf ( br.readLine () );
            String[][] s = new String[n][9];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < 9 ; j++)
                {
                    s[i][j] = br.readLine ();

                }
                System.out.println (Arrays.toString ( s[i] ));
            }
            resultado = s;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
    public static String[][] listarVentas(){
        String[][]resultado = new String[0][0];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader ("ARKA/src/Ficheros/SelectVentas.txt"));
            int n = Integer.valueOf ( br.readLine () );
            String[][] s = new String[n][6];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < 6 ; j++)
                {
                    s[i][j] = br.readLine ();

                }
                System.out.println (Arrays.toString ( s[i] ));
            }
            resultado = s;
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }


}
