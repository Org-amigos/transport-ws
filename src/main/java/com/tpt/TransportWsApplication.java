package com.tpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tpt.*")
@EnableAutoConfiguration
public class TransportWsApplication {


	public static void main(String[] args) {
		SpringApplication.run(TransportWsApplication.class, args);
	}

}
