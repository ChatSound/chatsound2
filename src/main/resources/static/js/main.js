function sendText() {
    var textInput = document.getElementById('text-input');
    stompClient.send("/app/soundMessage", {}, JSON.stringify({'text': textInput.value}));

    var chatbox = document.getElementById('chatbox');
    var messageCard = createMessageCard('사용자: ' + textInput.value, {}, true);
    chatbox.appendChild(messageCard);

    textInput.value = '';
}