function sendMessage() {
        const text = userInput.value.trim();
        if (text === "") return;

        // 1. Mostrar mensaje del usuario en pantalla
        addMessage(text, "user-message");
        userInput.value = "";

        // 2. Enviar pregunta al backend REAL usando Fetch API
        // Esta ruta debe coincidir con el @WebServlet("/chatbot") de tu código Java
        fetch('/chatbot', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({ pregunta: text })
        })
        .then(response => response.json())
        .then(data => {
            // Mostrar la respuesta real que viene de Oracle
            addMessage(data.respuesta, "bot-message");
        })
        .catch(error => {
            console.error("Error:", error);
            addMessage("Error de conexión con el servidor.", "bot-message");
        });
    }

// Inicialización del DOM
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');
const chatMessages = document.getElementById('chat-messages');

function addMessage(text, className) {
    const messageDiv = document.createElement('div');
    messageDiv.className = 'message ' + className;
    const p = document.createElement('p');
    p.textContent = text;
    messageDiv.appendChild(p);
    chatMessages.appendChild(messageDiv);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}

// Event listeners
sendBtn.addEventListener('click', sendMessage);
userInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') sendMessage();
});