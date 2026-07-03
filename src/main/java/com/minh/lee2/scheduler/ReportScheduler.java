package com.minh.lee2.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReportScheduler {
    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 60000)
    public void generateReport() {
        log.info("Generating report...");
        emailService.sendEmail();
        log.info("Report generated!");

    }

}
