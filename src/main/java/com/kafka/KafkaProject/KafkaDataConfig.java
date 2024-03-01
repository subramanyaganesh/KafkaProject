package com.kafka.KafkaProject;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.BufferedReader;
import java.io.FileReader;

@Configuration
public class KafkaDataConfig {

    @Value("${kafka.topic.google}")
    String google;

    @Value("${kafka.topic.netflix}")
    String netflix;

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {

            try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/GoogleStock Price.csv"))) {
                reader.lines()
                        .skip(1) // Skip header
                        .map(line -> line.split(",")[2])
                        .forEach(a ->kafkaTemplate.send(google, a));
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }


            try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/NFLX.csv"))) {
                reader.lines()
                        .skip(1) // Skip header
                        .map(line -> line.split(",")[2])
                        .forEach(a ->kafkaTemplate.send(netflix, a));
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
            }
        };
    }
}
