package com.example.jpalearning.Service;

import com.example.jpalearning.DTO.Person.PersonDTO;
import com.example.jpalearning.Entity.Person;
import com.example.jpalearning.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Achei esse diabo"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void createPersonDTO(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setEmail(personDTO.getEmail());
        personRepository.save(person);
    }

}
