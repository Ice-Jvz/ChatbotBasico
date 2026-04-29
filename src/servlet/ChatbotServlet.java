package servlet;
import dao.PreguntaDAO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.Gson;

@WebServlet("/chatbot")
public class ChatbotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir la pregunta (simplificado para el prototipo)
        String pregunta = request.getParameter("pregunta"); 
        
        // 2. Consultar la lógica del "motor" [cite: 57, 58]
        PreguntaDAO dao = new PreguntaDAO();
        String respuesta = dao.buscarRespuesta(pregunta);

        // Si no se encontró respuesta, guardar la pregunta para respuesta posterior
        if ("No tengo esa información aún".equals(respuesta)) {
            dao.guardarPregunta(pregunta);
        }

        // 3. Responder al frontend en formato JSON [cite: 50]
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("respuesta", respuesta);
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(jsonResponse));
    }
}
