package com.org.generation.plataforma.mentalidades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mentalidades")
public class MentalidadesController {
	
	@GetMapping
	public String helloW() {
		return "Utilizei a habilidade de: Atenção aos detalhes. E a mentalidade de: Persistência."; 
	}

}
