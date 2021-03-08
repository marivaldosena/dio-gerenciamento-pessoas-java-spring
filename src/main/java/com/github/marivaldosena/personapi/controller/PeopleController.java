package com.github.marivaldosena.personapi.controller;

import com.github.marivaldosena.personapi.dto.MessageResponseDto;
import com.github.marivaldosena.personapi.entity.Person;
import com.github.marivaldosena.personapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {
    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @PostMapping
    public MessageResponseDto createPerson(@RequestBody Person person) {
        Person savedPerson = peopleRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("Person " + savedPerson.getFirstName() + " was created successfully")
                .build();
    }
}
