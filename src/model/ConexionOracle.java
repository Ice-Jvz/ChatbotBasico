package model;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionOracle {
    public static Connection getConexion() {
        try {
            // Datos de tu contenedor Docker
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            String user = "system";
            String pass = "adm123";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
