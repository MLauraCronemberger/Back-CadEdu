package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		HelloWorld hello = new HelloWorld();
		hello.hello();
	}
}

@RestController
class HelloWorld {
	
	@GetMapping("/cadastro")
	public String hello() {
		return "Olá usuário";
	}
}
