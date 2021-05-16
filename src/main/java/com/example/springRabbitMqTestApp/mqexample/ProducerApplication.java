package com.example.springRabbitMqTestApp.mqexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    /*

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    Queue queueFoo() {
        return new Queue("queue.foo", false);
    }

    @Bean
    Queue queueBar() {
        return new Queue("queue.bar", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeFoo(Queue queueFoo, TopicExchange exchange) {
        return BindingBuilder.bind(queueFoo).to(exchange).with("queue.foo");
    }

    @Bean
    Binding bindingExchangeBar(Queue queueBar, TopicExchange exchange) {
        return BindingBuilder.bind(queueBar).to(exchange).with("queue.bar");
    }

    @Autowired
    private Sender sender;

    @Override
    public void run(String... args) throws Exception {
        sender.sendToRabbitmq(new Foo("gustavo"), new Bar());
    }
}

@Service
class Sender {

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

    public void sendToRabbitmq(final Foo foo, final Bar bar) {

        this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);

        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.foo", foo);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.foo", foo);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);

    }
}

class Bar {
    public int age = 33;
}

class Foo {
    public String name = "gustavo";

    public Foo(String message){
        this.name = message;
    }
    */

    @Override
    public void run(String... args) throws Exception {
        //sender.sendToRabbitmq(new Foo("gustavo"), new Bar());
    }
}