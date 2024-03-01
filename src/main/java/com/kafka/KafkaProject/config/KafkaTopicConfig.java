package com.kafka.KafkaProject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.google}")
    private String google;

    @Bean
    public NewTopic googleTopic(){
        return TopicBuilder.name(google).build();
    }

}
