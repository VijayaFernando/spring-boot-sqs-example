package com.example.springbootsqsexample.job;

import com.example.springbootsqsexample.service.SqsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SqsJob {

    private final SqsService sqsService;

    @Scheduled(fixedRate = 2500, initialDelay = 0)
    public void sendAndReceiveMessage() {
        sqsService.sendMessage();
        sqsService.receiveMessage();
    }
}
