var socket = new SockJS('/websocket');
var stompClient = Stomp.over(socket);
var audio = new Audio(); // Audio 객체를 전역으로 선언

function playSound(url) {
    audio.src = url;
    audio.play();
}

function stopSound() {
    audio.pause();
    audio.currentTime = 0;
}

stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/sound', function (soundMessage) {
        var chatbox = document.getElementById('chatbox');
        var soundMessageData = JSON.parse(soundMessage.body);
        var messageCard = createMessageCard('봇: ' + soundMessageData.text, soundMessageData);
        chatbox.appendChild(messageCard);
    });
})