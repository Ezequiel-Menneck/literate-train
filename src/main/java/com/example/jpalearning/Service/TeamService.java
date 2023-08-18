package com.example.jpalearning.Service;

import com.example.jpalearning.Entity.Team;
import com.example.jpalearning.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team findById(Integer id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Nao Achei esse diabo"));
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Transactional
    public void createSquad(Team team) {
        teamRepository.save(team);
    }

}
