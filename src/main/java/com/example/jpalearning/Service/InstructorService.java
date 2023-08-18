package com.example.jpalearning.Service;

import com.example.jpalearning.Entity.Instructor;
import com.example.jpalearning.Entity.Person;
import com.example.jpalearning.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor findById(Integer id) {
        return instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Achei esse diabo"));
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Transactional
    public void createPerson(Instructor instructor) {
        instructorRepository.save(instructor);
    }

}
