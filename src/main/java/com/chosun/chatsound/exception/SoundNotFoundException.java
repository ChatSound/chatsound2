package com.chosun.chatsound.exception;

public class SoundNotFoundException extends RuntimeException {
    public SoundNotFoundException(String message) {
        super(message);
    }
}
