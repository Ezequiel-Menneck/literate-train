package com.example.jpalearning.Repository;

import com.example.jpalearning.Entity.Instructor;
import com.example.jpalearning.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
