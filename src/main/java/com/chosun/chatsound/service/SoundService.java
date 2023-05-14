package com.chosun.chatsound.service;

import com.chosun.chatsound.entity.Sound;
import com.chosun.chatsound.exception.SoundNotFoundException;
import com.chosun.chatsound.repository.SoundRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SoundService {

    private final SoundRepository soundRepository;

    public SoundService(SoundRepository soundRepository) {
        this.soundRepository = soundRepository;
    }

    public String getSoundUrl(String text) {
        try {
            Optional<Sound> sound = soundRepository.findByText(text);
            if (sound.isPresent()) {
                return sound.get().getUrl();
            } else {
                throw new SoundNotFoundException("사용 가능한 사운드를 찾을 수 없습니다: " + text);
            }
        } catch (Exception e) {
            throw new RuntimeException("사운드를 가져오는 동안 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
