package com.example.jpalearning.Controller;

import com.example.jpalearning.DTO.Squad.SquadDTO;
import com.example.jpalearning.Entity.Squad;
import com.example.jpalearning.Service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("squad")
public class SquadController {

    @Autowired
    private SquadService squadService;

    @GetMapping("/{id}")
    public ResponseEntity<SquadDTO> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(squadService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Squad>> findAll() {
        return new ResponseEntity<>(squadService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Squad squad) {
        squadService.createSquad(squad);
        return ResponseEntity.ok("Squad Criada");
    }

    @PostMapping("/create/no-team")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createWithoutTeam(@RequestBody SquadDTO squadDTO) {
        squadService.createSquadWithoutTeam(squadDTO);
        return ResponseEntity.ok("Squad without team has created");
    }

}
