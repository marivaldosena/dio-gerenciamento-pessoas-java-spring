package com.github.marivaldosena.personapi.controller;

import com.github.marivaldosena.personapi.dto.request.PersonDto;
import com.github.marivaldosena.personapi.dto.response.MessageResponseDto;
import com.github.marivaldosena.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDto> listAll() {
        return personService.listAll();
    }
}
