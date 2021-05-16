package com.example.springRabbitMqTestApp.rabbitmq;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqProducer {

    Logger logger = Logger.getLogger(RabbitMqProducer.class);

    @Autowired
    public Queue myQueue;

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMqProducer(AmqpTemplate amqpTemplate){
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("/msg")
    public ResponseEntity<String> msg(@RequestBody String message){
        logger.log(Level.INFO, "msg в rabbitMQ");
        amqpTemplate.convertAndSend(myQueue.getName(),message);
        return ResponseEntity.ok("Сообщение доставлено.");
    }
}
