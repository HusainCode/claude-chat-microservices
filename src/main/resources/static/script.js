const chatForm = document.getElementById('chatForm');
const chatInput = document.getElementById('chatInput');
const chatMessages = document.getElementById('chatMessages');

chatForm.addEventListener('submit', function(e) {
    e.preventDefault();
    const text = chatInput.value.trim();
    if (!text) return;
    appendMessage("You", text);
    chatInput.value = '';

    // Send the message to the backend and get AI reply
    fetch('/api/ai', {
        method: 'POST',
        headers: { 'Content-Type': 'text/plain' },
        body: text
    })
        .then(response => response.text())
        .then(aiReply => {
            appendMessage("Bot", aiReply);
        })
        .catch(err => {
            appendMessage("Bot", "Sorry, something went wrong!");
        });
});

function appendMessage(sender, text) {
    const div = document.createElement('div');
    div.innerHTML = `<strong>${sender}:</strong> ${text}`;
    chatMessages.appendChild(div);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}
