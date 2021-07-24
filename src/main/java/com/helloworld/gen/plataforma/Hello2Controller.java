package com.helloworld.gen.plataforma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello2")
public class Hello2Controller {	
	
	@GetMapping
	public String hello() {
		return "Mentalidades: Persistência e Orientação ao Futuro,"
				+ "\nHabilidade: Atenção aos detalhes";
	}
}