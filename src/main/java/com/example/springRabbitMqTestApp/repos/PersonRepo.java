package com.example.springRabbitMqTestApp.repos;

import com.example.springRabbitMqTestApp.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person,Long> {
    Person findByName(String name);
    List<Person> findAllByFirstName(String name);
    List<Person> findAllByLastName(String name);
}
