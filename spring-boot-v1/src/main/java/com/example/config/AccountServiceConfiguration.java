package com.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.model")
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@Configuration
@ComponentScan(basePackages = { "com.example.service", "com.example.repository" })
@EnableAutoConfiguration(exclude = {})
public class AccountServiceConfiguration {

}