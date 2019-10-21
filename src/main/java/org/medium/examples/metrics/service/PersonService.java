package org.medium.examples.metrics.service;

import java.util.Objects;
import org.medium.examples.metrics.entity.Person;
import org.medium.examples.metrics.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(String id) {
        Person person = personRepository.getPersonById(id);
        if (Objects.nonNull(person)) {
            double salary = 5000.00;
            person.setSalary(salary);
        }
        return person;
    }
}
