package com.github.marivaldosena.personapi.mapper;

import com.github.marivaldosena.personapi.dto.request.PersonDto;
import com.github.marivaldosena.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);
    PersonDto toDto(Person person);
}
