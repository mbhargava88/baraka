package com.baraka.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.baraka.repository")
@EntityScan("com.baraka")
@ComponentScan({"com.baraka"})
@Configuration
public class DatabaseConfig {
}
