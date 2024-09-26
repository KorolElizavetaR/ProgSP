package com.progsp.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.progsp.server")
@PropertySource("classpath:hibernate.properties")
public class ConfigClass {
	
}
