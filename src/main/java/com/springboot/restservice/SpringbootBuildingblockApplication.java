package com.springboot.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringbootBuildingblockApplication {
	private static final Logger log = Logger.getLogger(SpringbootBuildingblockApplication.class.getName());

	public static void main(String[] args) {
		log.info("Inside main method ");
		SpringApplication.run(SpringbootBuildingblockApplication.class, args);

	}

}
