package BACK.Class;

import FRONT.BajaEmpleadoFrame;
import FRONT.BajaProductosFrame;
import FRONT.PANTALLA_INICIO;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void SelectEmpleados(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/SelectEmpleados.txt"));
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

    public static void SelectProductos(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/SelectProductos.txt"));
            salida.write(info);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            try{
                salida.close();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void insertProductos(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/InsertProductos.txt"));
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

    public static void insertVentas(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/InsertVentas.txt"));
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
    public static void modificarEmpleado(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/UpdateEmpleados.txt"));
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
    public static void modificarProducto(String info){
        BufferedWriter salida = null;
        try {
            salida = new BufferedWriter(new FileWriter("ARKA/src/Ficheros/UpdateProductos.txt"));
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
}
