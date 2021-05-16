package com.example.springRabbitMqTestApp;

import com.example.springRabbitMqTestApp.domain.Person;
import com.example.springRabbitMqTestApp.rabbitmq.RabbitMqConsumer;
import com.example.springRabbitMqTestApp.rabbitmq.RabbitMqProducer;
import com.example.springRabbitMqTestApp.rabbitmq.RabbitPersonMessage;
import com.example.springRabbitMqTestApp.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Person> persons = personRepo.findAll();

        model.put("persons", persons);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String birthdate, Map<String, Object> model) {
        Date date = Date.valueOf(birthdate);
        Person person = new Person(name, firstname, lastname, date);
        mqProcess(person);
        Iterable<Person> persons = personRepo.findAll();
        model.put("persons", persons);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Person> persons;
        Person person = null;
        if (filter != null && !filter.isEmpty()) {
            persons = personRepo.findAllByFirstName(filter);
            if (((List<Person>) persons).isEmpty())
                persons = personRepo.findAllByLastName(filter);
            if (((List<Person>) persons).isEmpty())
                person = personRepo.findByName(filter);
            model.put("persons", person == null ? persons : person);
        } else {
            model.put("persons", persons = personRepo.findAll());
        }

        return "main";
    }

    @GetMapping("test")
    public String test() {
        mqProcess(new Person("Злопупенцев", "Грязномаз", "Старообрядович"));
        return "main";
    }

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    /**
     * Согласно ТЗ метод сначала отправляет полученные данные в MQRabbit, а потом сразу вычитывает
     * их и отправляет в postgress.
     */
    private Person mqProcess(Person person){
        RabbitPersonMessage message = new RabbitPersonMessage(person);
        rabbitMqProducer.sendToRabbitmq(message);
        return person;
    }
}
