package com.alight.request_eval.service;

import com.alight.request_eval.model.dto.AgentListDto;
import com.alight.request_eval.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentService {

private final AgentRepository repository;

    public AgentService(AgentRepository repository) {
        this.repository = repository;
    }

    public List<AgentListDto> listActiveAgents(){
        return repository.findAll().stream()
                .filter(agent -> agent.isArchived())
                .map(agent -> new AgentListDto(agent))
                .collect(Collectors.toList());
    }
}
