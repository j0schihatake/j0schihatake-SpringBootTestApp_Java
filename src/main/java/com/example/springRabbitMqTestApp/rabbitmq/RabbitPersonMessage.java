package com.example.springRabbitMqTestApp.rabbitmq;

import com.example.springRabbitMqTestApp.domain.Person;

import java.io.Serializable;
import java.sql.Date;

public class RabbitPersonMessage implements Serializable {

    private String name;

    private String firstName;

    private String lastName;

    private Date birthDate;

    public RabbitPersonMessage(){
        this.name = "new";
        this.firstName = "new";
        this.lastName = "new";
        this.birthDate = null;
    }

    public RabbitPersonMessage(Person person){
        this.name = person.getName();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.birthDate = person.getBirthDate();
    }

    public static Person rabbitPersonMessageToPerson(RabbitPersonMessage rpm){
        return new Person(rpm.firstName, rpm.name, rpm.lastName, rpm.birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
