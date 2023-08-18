package com.example.jpalearning.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Squad> squadList = new ArrayList<>();

    @OneToMany(mappedBy = "team")
    private List<Person> personList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "team_instructors",
    joinColumns = @JoinColumn(name = "team_id"),
    inverseJoinColumns = @JoinColumn(name = "instructors_id"))
    private List<Instructor> instructors = new ArrayList<>();

    @OneToOne(mappedBy = "team")
    private Cordinator cordinator;

}
