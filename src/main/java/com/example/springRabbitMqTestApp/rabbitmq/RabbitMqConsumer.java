package com.example.springRabbitMqTestApp.rabbitmq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMqConsumer {
    Logger logger = Logger.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = "test")
    public void processQueue1(String message) {
        logger.info("Received from queue 1: " + message);
    }
}