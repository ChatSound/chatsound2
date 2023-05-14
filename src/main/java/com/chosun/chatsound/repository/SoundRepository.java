package com.chosun.chatsound.repository;

import com.chosun.chatsound.entity.Sound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoundRepository extends JpaRepository<Sound, Long> {
    Optional<Sound> findByText(String text);
}
