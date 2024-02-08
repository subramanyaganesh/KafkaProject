package com.kafka.KafkaProject;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListenerMain {

    @KafkaListener(
            topics = "myFirstTopic",
            groupId = "groupid"
    )
    public void listen(String message) {
        // This method will be invoked when a message is received from the "myFirstTopic" Kafka topic.
        System.out.println("Received message: " + message);
        // Further processing of the received message can be done here.
    }

}
