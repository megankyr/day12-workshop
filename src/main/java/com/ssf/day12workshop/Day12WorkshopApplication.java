package com.ssf.day12workshop;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day12WorkshopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day12WorkshopApplication.class);
		String port = portFromCommandLine(args);
		if (port == null) {
			port = "3000";
		}
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.println("Application started on " + port);
		app.run(args);
	}

	private static String portFromCommandLine(String[] args) {
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")) {
			return cliOpts.getOptionValues("port").get(0);
		}
		if (cliOpts.containsOption("server.port")) {
			return cliOpts.getOptionValues("server.port").get(0);
		}
		return null;
	}
}
