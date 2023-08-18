package com.example.jpalearning.Controller;

import com.example.jpalearning.Entity.Instructor;
import com.example.jpalearning.Entity.Person;
import com.example.jpalearning.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Instructor instructor) {
        instructorService.createPerson(instructor);
        return ResponseEntity.ok("Instructor Criado");
    }

}
