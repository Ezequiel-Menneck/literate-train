package com.example.jpalearning.Controller;

import com.example.jpalearning.DTO.Team.TeamDTO;
import com.example.jpalearning.Entity.Team;
import com.example.jpalearning.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> findAll() {
        return new ResponseEntity<>(teamService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Team team) {
        teamService.createSquad(team);
        return ResponseEntity.ok("Team Criada");
    }

}
