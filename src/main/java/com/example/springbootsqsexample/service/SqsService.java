package com.example.springbootsqsexample.service;

import com.example.springbootsqsexample.domain.MessageSample;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SqsService {

    private final SqsTemplate sqsTemplate;

    public void sendMessage() {
        SendResult<MessageSample> sampleSendResult = sqsTemplate
                .send("MyQueue.fifo",
                        new MessageSample("Hello!", "From SQS!"));
        log.info("Message sent {}", sampleSendResult.message());
    }

    public void receiveMessage() {
        Optional<Message<MessageSample>> messageSampleMessage = sqsTemplate
                .receive(from -> from.queue("MyQueue.fifo")
                                .visibilityTimeout(Duration.ofSeconds(30)),
                        MessageSample.class);

        if (messageSampleMessage.isPresent()) {
            log.info("Received message {}", messageSampleMessage.get());
        } else {
            log.info("No message received");
        }
    }
}
