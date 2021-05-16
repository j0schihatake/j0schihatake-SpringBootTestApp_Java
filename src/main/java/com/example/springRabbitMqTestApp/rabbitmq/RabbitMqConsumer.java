package com.example.springRabbitMqTestApp.rabbitmq;

import com.example.springRabbitMqTestApp.domain.Person;
import com.example.springRabbitMqTestApp.repos.PersonRepo;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.stereotype.Service;

@Service
@EnableRabbit
public class RabbitMqConsumer implements RabbitListenerConfigurer {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    public MappingJackson2MessageConverter mappingJackson2MessageConverter;

    @Autowired
    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory;

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(defaultMessageHandlerMethodFactory);
    }

    @RabbitListener(queues = "queue.test")
    public void receiveMessage(RabbitPersonMessage message) {
        try {
            personRepo.save(RabbitPersonMessage.rabbitPersonMessageToPerson(message));
        } catch (Exception e) {}
    }
}
