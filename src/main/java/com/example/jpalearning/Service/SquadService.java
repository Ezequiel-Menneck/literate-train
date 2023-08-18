package com.example.jpalearning.Service;

import com.example.jpalearning.DTO.Person.PersonDTO;
import com.example.jpalearning.DTO.Squad.SquadDTO;
import com.example.jpalearning.Entity.Person;
import com.example.jpalearning.Entity.Squad;
import com.example.jpalearning.Repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SquadService {

    @Autowired
    private SquadRepository squadRepository;

    public SquadDTO findById(Integer id) {
        Squad squad = squadRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Achei esse diabo"));
        SquadDTO squadDTO = new SquadDTO();
        squadDTO.setName(squad.getName());

        List<PersonDTO> personDTOList = squad.getPersonList().stream()
                .map(this::convertToPersonDTO)
                .toList();

        squadDTO.setPersonList(personDTOList);
        return squadDTO;
    }

    public List<Squad> findAll() {
        return squadRepository.findAll();
    }

    @Transactional
    public void createSquad(Squad squad) {
        squadRepository.save(squad);
    }

    @Transactional
    public void createSquadWithoutTeam(SquadDTO squadDTO) {
        Squad squad = new Squad();
        squad.setName(squadDTO.getName());
        squadRepository.save(squad);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setName(person.getName());
        personDTO.setEmail(person.getEmail());
        return personDTO;
    }

}
