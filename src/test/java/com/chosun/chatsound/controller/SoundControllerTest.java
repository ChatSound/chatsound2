package com.chosun.chatsound.controller;

import com.chosun.chatsound.entity.Sound;
import com.chosun.chatsound.repository.SoundRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SoundController.class)
public class SoundControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SoundRepository soundRepository;

    @Test
    public void getSoundUrlTest() throws Exception {
        Sound sound = new Sound();
        sound.setText("dog");
        sound.setUrl("dog.mp3");

        Mockito.when(soundRepository.findByText("dog")).thenReturn(Optional.of(sound));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sound/dog")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

