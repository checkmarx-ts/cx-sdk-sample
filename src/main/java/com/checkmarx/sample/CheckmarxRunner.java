package com.checkmarx.sample;

import com.checkmarx.sdk.config.CxProperties;
import com.checkmarx.sdk.dto.cx.CxTeam;
import com.checkmarx.sdk.exception.CheckmarxException;
import com.checkmarx.sdk.service.CxClient;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckmarxRunner implements CommandLineRunner {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CheckmarxRunner.class);

    private final CxClient client;
    private final CxProperties properties;

    public CheckmarxRunner(CxClient client, CxProperties properties) {
        this.client = client;
        this.properties = properties;
    }

    @Override
    public void run(String[] args) {
        try {
            //list out teams
            List<CxTeam> teams = client.getTeams();
            teams.forEach(t -> log.info(t.getFullName()));
            //get the base team from the property file
            String teamId = client.getTeamId(properties.getTeam());
            //create a new team under this above team
            String newTeamId = client.createTeam(teamId, "MyNewTeam");
            //log the new team id
            log.info("New team id: {}", newTeamId);
            //list out teams again
            teams = client.getTeams();
            teams.forEach(t -> log.info(t.getFullName()));
        } catch (CheckmarxException e) {
            log.error("Error occurred while getting teams");
        }
    }
}



