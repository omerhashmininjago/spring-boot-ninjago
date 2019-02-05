package com.lego.omer.bootstrap;


import com.lego.omer.error.handler.NinjagoUncaughtExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.Banner.Mode.OFF;

@SpringBootApplication(scanBasePackages = {"com.lego.omer"})
public class NinjagoApplication {

    private static final Logger LOG = LoggerFactory.getLogger(NinjagoApplication.class);

    public static void main(String... args) {

        Thread.setDefaultUncaughtExceptionHandler(new NinjagoUncaughtExceptionHandler());
        LOG.info("Going to start Ninjago");
        // If we want to override some default configuration of Spring boot
        SpringApplication application = new SpringApplication(NinjagoApplication.class);

        // this would not log the default Spring banner when the app starts
        application.setBannerMode(OFF);
        application.run(args);
        LOG.info("Ninjago Successfully started");
    }

}
