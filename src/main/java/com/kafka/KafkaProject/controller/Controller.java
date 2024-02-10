package com.kafka.KafkaProject.controller;

import com.kafka.KafkaProject.config.KafkaTopicConfig;
import com.kafka.KafkaProject.services.KafkaDeleteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaTopicConfig kafkaTopicConfig;

    @Autowired
    KafkaDeleteData kafkaDeleteData;

    @PostMapping("/api/send")
    public HttpEntity<String> send(@RequestBody String body ){
        kafkaTemplate.send(kafkaTopicConfig.myFirst().name(),body);
        return new ResponseEntity<>("Successfully added data into Kafka!", HttpStatus.CREATED);
    }
    @DeleteMapping("/api/delete/{topicName}")
    public void deleteTopics(@PathVariable String topicName){
        kafkaDeleteData.deleteTopic(kafkaTopicConfig.myFirst().name());
    }
}
