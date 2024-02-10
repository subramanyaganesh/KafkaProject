package com.kafka.KafkaProject.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaListenerMain {

    public final List<String> consumedMessages = new ArrayList<>();
    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "groupid"
    )
    public void listen(String message) {
        // This method will be invoked when a message is received from the "myFirstTopic" Kafka topic.
        System.out.println("Received message: " + message);
        // Further processing of the received message can be done here.
        consumedMessages.add(message);
    }

}
