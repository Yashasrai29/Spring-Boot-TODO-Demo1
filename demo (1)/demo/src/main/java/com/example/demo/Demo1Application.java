package com.example.demo;

import com.example.demo.dto.TodoDto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
public class Demo1Application  {

	public static void main(String[] args ){
		SpringApplication.run(Demo1Application.class, args);
	}
     @Bean
      public TodoDto todoDto(){
		return  new TodoDto();
	  }



}
