package com.conferenceApp.conferenceAppDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//changes to create a WAR instead of a JAR (copy war file on tomcat)
public class ConferenceAppDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceAppDemoApplication.class, args);
		System.out.println("Hello World");
	}

}
