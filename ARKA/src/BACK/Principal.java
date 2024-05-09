package BACK;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Principal {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Tienda_de_ropa";
        String username = "tu_usuario";
        String password = "tu_contraseña";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM producto";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("ARKA/src/BACK/Ficheros/productos.txt"));
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String tipoProducto = resultSet.getString("tipo_producto");
                    int stock = resultSet.getInt("stock");
                    String talla = resultSet.getString("talla");
                    String color = resultSet.getString("color");
                    String marca = resultSet.getString("marca");
                    String linea = String.format("ID: %d, Tipo de Producto: %s, Stock: %d, Talla: %s, Color: %s, Marca: %s%n", id, tipoProducto, stock, talla, color, marca);
                    writer.write(linea);
                }
                writer.close();
                System.out.println("Se ha escrito la información de los productos en el archivo productos.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
