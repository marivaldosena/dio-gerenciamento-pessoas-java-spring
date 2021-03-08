package com.github.marivaldosena.personapi.controller;

import com.github.marivaldosena.personapi.dto.MessageResponseDto;
import com.github.marivaldosena.personapi.entity.Person;
import com.github.marivaldosena.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
