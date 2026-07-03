package com.minh.lee2.scheduler;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Async
    @SneakyThrows
    public void sendEmail() {
        log.info("Sending email...");
        Thread.sleep(5000);
        log.info("Email sent");
    }
}
