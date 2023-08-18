package com.example.jpalearning.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
