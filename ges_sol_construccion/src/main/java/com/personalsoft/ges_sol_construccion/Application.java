package com.personalsoft.ges_sol_construccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
public class Application  extends SpringBootServletInitializer{

	public static void main(String[] args) {
                System.out.println("Ejecutando spring boot");
		SpringApplication.run(Application.class, args);
	}
        
        
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
        {
          return builder.sources(Application.class);
        }
        
}
