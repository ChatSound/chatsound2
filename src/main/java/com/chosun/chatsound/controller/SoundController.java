package com.chosun.chatsound.controller;

import com.chosun.chatsound.entity.Sound;
import com.chosun.chatsound.repository.SoundRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sound")
public class SoundController {

    private final SoundRepository soundRepository;

    public SoundController(SoundRepository soundRepository) {
        this.soundRepository = soundRepository;
    }

    @GetMapping("/{text}")
    public ResponseEntity<String> getSoundUrl(@PathVariable String text) {
        Optional<Sound> sound = soundRepository.findByText(text);
        return sound.map(value -> ResponseEntity.ok(value.getUrl())).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
