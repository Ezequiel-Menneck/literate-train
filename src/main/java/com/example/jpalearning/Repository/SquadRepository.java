package com.example.jpalearning.Repository;

import com.example.jpalearning.Entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Integer> {
}
