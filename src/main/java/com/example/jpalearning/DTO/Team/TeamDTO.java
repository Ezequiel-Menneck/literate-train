package com.example.jpalearning.DTO.Team;

import com.example.jpalearning.DTO.Person.PersonDTO;
import com.example.jpalearning.DTO.Squad.SquadDTO;
import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {

    private String name;
    private List<PersonDTO> personList;
    private List<SquadDTO> squadList;

}
