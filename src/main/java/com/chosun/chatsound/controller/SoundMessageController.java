package com.chosun.chatsound.controller;

import com.chosun.chatsound.entity.SoundMessage;
import com.chosun.chatsound.service.SoundService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SoundMessageController {

    private final SoundService soundService;

    public SoundMessageController(SoundService soundService) {
        this.soundService = soundService;
    }

    @MessageMapping("/soundMessage")
    @SendTo("/topic/sound")
    public SoundMessage sendSoundMessage(@Payload SoundMessage soundMessage) {
        String soundUrl = soundService.getSoundUrl(soundMessage.getText());
        soundMessage.setSoundUrl(soundUrl);
        return soundMessage;
    }
}
