# 🤖 Chatbot Universitario

Un asistente virtual inteligente diseñado para responder preguntas frecuentes sobre servicios, programas y actividades universitarias.

## 📋 Descripción

El Chatbot Universitario es una aplicación web que proporciona respuestas automáticas a estudiantes y usuarios sobre diferentes aspectos de la institución educativa. Integra una base de datos Oracle para almacenar y recuperar información, así como registrar preguntas frecuentes no respondidas.

## 🎯 Funcionalidades Disponibles

El chatbot puede responder preguntas sobre **12 temas principales**:

1. ⏰ **Horarios** - Información sobre horarios de clases y atención
2. 📝 **Matrícula** - Procesos y requisitos de inscripción
3. 📞 **Contacto** - Números telefónicos y correos de contacto
4. 🎓 **Carreras** - Programas académicos disponibles
5. 💰 **Becas** - Información sobre becas y ayudas financieras
6. 📚 **Biblioteca** - Horarios, servicios y recursos de biblioteca
7. ✍️ **Inscripciones** - Fechas y procedimientos de inscripción
8. 💵 **Costos** - Aranceles, matrículas y costos académicos
9. 🏢 **Campus** - Ubicación, instalaciones y transporte
10. 💻 **Virtual** - Plataforma de educación virtual y acceso
11. 🔬 **Prácticas** - Programas de prácticas profesionales
12. ⚽ **Deportes** - Actividades deportivas y recreativas

## 🛠️ Tecnologías Utilizadas

- **Backend**: Java Servlet (Java 17)
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Base de Datos**: Oracle Database
- **Build Tool**: Maven
- **Servidor**: Apache Tomcat 7
- **Librerías**: GSON (JSON processing)

## 📦 Requisitos Previos

- Java Development Kit (JDK) 17 o superior
- Maven 3.6 o superior
- Apache Tomcat 7 (se descarga automáticamente con Maven)
- Oracle Database 19c o superior
- Navegador web moderno

## 🚀 Instalación y Uso

### 1. Clonar o descargar el repositorio

```bash
git clone <url-del-repositorio>
cd ChatBot
```

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Iniciar el servidor Tomcat

```bash
mvn tomcat7:run
```

### 4. Acceder a la aplicación

Abre tu navegador y ve a:

```
http://localhost:8080
```

## 📁 Estructura del Proyecto

```
ChatBot/
├── src/
│   ├── dao/
│   │   └── PreguntaDAO.java          # Acceso a datos de preguntas
│   ├── model/
│   │   └── ConexionOracle.java       # Configuración de conexión BD
│   └── servlet/
│       └── ChatbotServlet.java       # Endpoint del chatbot (/chatbot)
├── web/
│   ├── index.html                    # Interfaz principal
│   ├── style.css                     # Estilos de la aplicación
│   └── app.js                        # Lógica del frontend
├── pom.xml                           # Configuración Maven
└── README.md                         # Este archivo
```

## 💬 Cómo Usar el Chatbot

1. Accede a la aplicación en tu navegador
2. En el campo de entrada, escribe tu pregunta (ej: "¿Cuál es el horario de clases?")
3. El chatbot procesará tu pregunta y mostrará la respuesta
4. Si el chatbot no tiene información sobre el tema, registrará tu pregunta para respuesta posterior

## 📝 Ejemplo de Preguntas

```
- ¿Cuál es el horario de atención?
- ¿Cuáles son las becas disponibles?
- ¿Cómo puedo matricularme?
- ¿Dónde está ubicado el campus?
- ¿Cómo accedo a la plataforma virtual?
- ¿Hay actividades deportivas?
```

## 🔗 Endpoints de la API

### POST /chatbot
Procesa preguntas del usuario

**Request:**
```json
{
  "pregunta": "¿Cuál es el horario?"
}
```

**Response:**
```json
{
  "respuesta": "El horario de atención es de 8:00 AM a 5:00 PM"
}
```

## 🔐 Configuración de Base de Datos

Antes de ejecutar la aplicación, configura tu conexión a Oracle en [src/model/ConexionOracle.java](src/model/ConexionOracle.java):

```java
// Actualiza estas credenciales
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String usuario = "tu_usuario";
String password = "tu_contraseña";
```

## 📊 Estadísticas

- **Temas de cobertura**: 12
- **Java Version**: 17
- **Compatibilidad**: Java SE 17+

## 👨‍💻 Desarrollo

Para contribuir al proyecto:

1. Haz fork del repositorio
2. Crea una rama para tu feature (`git checkout -b feature/NuevaFuncionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/NuevaFuncionalidad`)
5. Abre un Pull Request

## 📧 Contacto

Para preguntas o sugerencias sobre este proyecto, contacta a través de los canales universitarios.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver detalles en el archivo LICENSE.

---

**Última actualización**: 6 de mayo de 2026
