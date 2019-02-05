package com.lego.omer.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NinjagoRunner implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(NinjagoRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Going to load static data");

        //Do something before the services kick in
        new NinjagoLoader();
    }

}
