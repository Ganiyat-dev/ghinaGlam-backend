package com.ghinaglam.ghinaglam.email;

public interface EmailSenderService {
    void send (String to, String email, String subject);
}
