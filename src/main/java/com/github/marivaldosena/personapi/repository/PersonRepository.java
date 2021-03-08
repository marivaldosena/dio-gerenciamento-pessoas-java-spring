package com.github.marivaldosena.personapi.repository;

import com.github.marivaldosena.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
