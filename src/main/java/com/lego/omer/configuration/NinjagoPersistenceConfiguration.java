package com.lego.omer.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConditionalOnProperty(name = "persistence.autoconfigure.enabled", matchIfMissing = true)
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.lego.omer.domain"})
@EnableJpaRepositories(basePackages = {"com.lego.omer.repo"})
public class NinjagoPersistenceConfiguration {
}
