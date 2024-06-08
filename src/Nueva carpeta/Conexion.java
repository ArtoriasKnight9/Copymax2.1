package Contorlador;


import Modelo.Productosprecios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Conexion {
    private Connection connection;
    
    public Conexion() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3307/Copymax";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos, error: " + e.toString());
        }
        
   }
    
    public Connection getConnection() {
        return connection;
    }
    
     // Nuevo método para verificar la conexión
    public boolean verificarConexion() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
    
     public List<Productosprecios> obtenerProductos() {
    List<Productosprecios> productos = new ArrayList<>();
    String sql = "SELECT Nombre_producto, Precio, Icono FROM Productos";

    try (Connection con = getConnection(); 
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            String nombre = rs.getString("Nombre_producto");
            double precio = rs.getDouble("Precio");
            String icono = rs.getString("Icono");
            productos.add(new Productosprecios(nombre, precio, icono));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productos;
} 
    
}
