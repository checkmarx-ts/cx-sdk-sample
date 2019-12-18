package com.checkmarx.sample;

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

    public CheckmarxRunner(CxClient client) {
        this.client = client;
    }

    @Override
    public void run(String[] args) {
        try {
            List<CxTeam> teams = client.getTeams();
            teams.forEach(t -> log.info(t.getFullName()));
        } catch (CheckmarxException e) {
            log.error("Error occurred while getting teams");
        }
    }
}



