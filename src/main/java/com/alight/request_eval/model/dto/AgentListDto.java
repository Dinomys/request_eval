package com.alight.request_eval.model.dto;

import com.alight.request_eval.model.persons.Agent;

public class AgentListDto {

    private long id;
    private String name;

    public AgentListDto(Agent agent) {
        this.id = agent.getId();
        this.name = agent.getFirstName() + " " + agent.getLastName();
    }
}
