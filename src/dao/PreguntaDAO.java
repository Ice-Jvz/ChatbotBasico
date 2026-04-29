package dao;
import model.ConexionOracle;
import java.sql.*;

public class PreguntaDAO {
    public String buscarRespuesta(String preguntaUsuario) {
        String respuesta = "No tengo esa información aún"; // Mensaje por defecto [cite: 29]
        String sql = "SELECT respuesta FROM preguntas WHERE LOWER(pregunta) LIKE LOWER(?)";

        Connection con = ConexionOracle.getConexion();
        if (con == null) {
            return respuesta; // No se pudo conectar a la BD
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, "%" + preguntaUsuario + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                respuesta = rs.getString("respuesta");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public void guardarPregunta(String pregunta) {
        String sql = "INSERT INTO preguntas (pregunta) VALUES (?)";
        Connection con = ConexionOracle.getConexion();
        if (con == null) {
            return; // No se pudo conectar
        }
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pregunta);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
