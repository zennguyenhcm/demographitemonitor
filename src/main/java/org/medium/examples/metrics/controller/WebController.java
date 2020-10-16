package org.medium.examples.metrics.controller;

import com.fasterxml.jackson.databind.JsonNode;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.graphite.GraphiteConfig;
import io.micrometer.graphite.GraphiteMeterRegistry;
import org.medium.examples.metrics.entity.Person;
import org.medium.examples.metrics.entity.Request;
import org.medium.examples.metrics.service.PersonService;
import org.medium.examples.metrics.service.RequestService;
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
    @Autowired
    private RequestService requestService;

    @GetMapping()
    public Person getPerson(@RequestParam String id) throws Exception {
        Person person = personService.getPerson(id);
        Request request = requestService.getRequest(200);
        requestService.registryMetric(request);
        //System.out.println("result: "+ requestService.query(request).toString()) ;
        return person;
    }

}
