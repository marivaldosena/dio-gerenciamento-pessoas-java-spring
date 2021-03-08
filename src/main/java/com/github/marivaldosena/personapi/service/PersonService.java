package com.github.marivaldosena.personapi.service;

import com.github.marivaldosena.personapi.dto.request.PersonDto;
import com.github.marivaldosena.personapi.dto.response.MessageResponseDto;
import com.github.marivaldosena.personapi.entity.Person;
import com.github.marivaldosena.personapi.mapper.PersonMapper;
import com.github.marivaldosena.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(PersonDto personDto) {
        Person personToSave = personMapper.toModel(personDto);
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDto
                .builder()
                .message("Person " + savedPerson.getFirstName() + " was created successfully")
                .build();
    }
}
