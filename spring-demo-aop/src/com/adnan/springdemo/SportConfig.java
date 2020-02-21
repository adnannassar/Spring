package com.adnan.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("com.adnan.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// define bean for our sad fortune service
	
	@Bean
	public SadFortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define a bean for our swim coach and inject dependency
	
	@Bean
	public SwimCoach swimCoach () {
		return new SwimCoach(sadFortuneService());
	}
}
