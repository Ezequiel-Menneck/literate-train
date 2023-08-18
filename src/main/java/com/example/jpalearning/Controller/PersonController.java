package com.example.jpalearning.Controller;

import com.example.jpalearning.DTO.Person.PersonDTO;
import com.example.jpalearning.Entity.Person;
import com.example.jpalearning.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Person person) {
        personService.createPerson(person);
        return ResponseEntity.ok("Person Criada");
    }

    @PostMapping("/create/2")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody PersonDTO personDTO) {
        personService.createPersonDTO(personDTO);
        return ResponseEntity.ok("Person Criada");
    }


}
