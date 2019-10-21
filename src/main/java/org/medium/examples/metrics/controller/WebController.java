package org.medium.examples.metrics.controller;

import org.medium.examples.metrics.entity.Person;
import org.medium.examples.metrics.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("person")
public class WebController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public Person getPerson(@RequestParam String id) {
        Person person = personService.getPerson(id);
        return person;
    }

}
