package com.checkmarx.sample;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckmarxRunner implements CommandLineRunner {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CheckmarxRunner.class);

    @Override
    public void run(String[] args) {
        log.info("test");
    }
}



