package com.example.jpalearning.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "squad_id")
    private Squad squad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
//    @JsonIgnore
    private Team team;

}
