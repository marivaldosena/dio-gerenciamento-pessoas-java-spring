package com.github.marivaldosena.personapi.service;

import com.github.marivaldosena.personapi.dto.MessageResponseDto;
import com.github.marivaldosena.personapi.entity.Person;
import com.github.marivaldosena.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(Person person) {
        Person savedPerson = personRepository.save(person);

        return MessageResponseDto
                .builder()
                .message("Person " + savedPerson.getFirstName() + " was created successfully")
                .build();
    }
}
