package com.example.jpalearning.DTO.Squad;

import com.example.jpalearning.DTO.Person.PersonDTO;
import lombok.Data;

import java.util.List;

@Data
public class SquadDTO {

    private String name;

    private List<PersonDTO> personList;

}
