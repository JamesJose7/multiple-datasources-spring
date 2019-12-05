package com.example.multidatasourcedemo.dao1;

import com.example.multidatasourcedemo.model_1.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByFirstNameAndLastName(String firstName, String lastName);
}
