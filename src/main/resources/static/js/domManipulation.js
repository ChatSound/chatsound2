function createMessageCard(messageText, soundMessageData, isUserMessage) {
    var messageCard = document.createElement('div');
    messageCard.className = "card mb-2";

    // 추가: 메시지 카드에 사용자 또는 Bot 클래스 추가
    if (isUserMessage) {
        messageCard.classList.add("user-message");
    } else {
        messageCard.classList.add("bot-message");
    }


    var messageBody = document.createElement('div');
    messageBody.className = "card-body";
    messageBody.textContent = messageText;

    if (!isUserMessage) {
        var playButton = document.createElement('button');
        playButton.className = "btn btn-primary btn-sm";
        playButton.textContent = "Play";
        playButton.onclick = function () {
            playSound(soundMessageData.soundUrl);
        }

        var stopButton = document.createElement('button');
        stopButton.className = "btn btn-secondary btn-sm ml-2";
        stopButton.textContent = "Stop";
        stopButton.onclick = stopSound;

        messageBody.appendChild(playButton);
        messageBody.appendChild(stopButton);
    }

    messageCard.appendChild(messageBody);
    return messageCard;
}

var style = document.createElement('style');
style.innerHTML = `
.user-message {
    text-align: right;
    background-color: #D1E7DD;
}

.bot-message {
    text-align: left;
    background-color: #E2EFC4;
}
`;
document.head.appendChild(style);