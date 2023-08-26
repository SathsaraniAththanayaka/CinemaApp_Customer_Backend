package com.movieFanSide.Customer.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic movieTopic(){
        return TopicBuilder.name("movie")
                .build();
    }

    @Bean
    public NewTopic movieJsonTopic(){
        return TopicBuilder.name("movie_json")
                .build();
    }
}
