package com.example.multidatasourcedemo.config;

import com.example.multidatasourcedemo.dao1.PersonRepository;
import com.example.multidatasourcedemo.dao2.CompanyRepository;
import com.example.multidatasourcedemo.model_1.Person;
import com.example.multidatasourcedemo.model_2.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class StartupConfig {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {

        // Insert person if it does not exist
        Person person = personRepository.findByFirstNameAndLastName("Jaime", "Paz");
        if (person == null)
            personRepository.save(new Person("Jaime", "Paz"));

        // Insert company if it does not exist
        Company company = companyRepository.findByName("Google");
        if (company == null)
            companyRepository.save(new Company("Google", 100000));
    }
}
