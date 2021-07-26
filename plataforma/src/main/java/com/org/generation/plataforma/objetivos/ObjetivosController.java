package com.org.generation.plataforma.objetivos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("objetivos")
public class ObjetivosController {
	
	@GetMapping
	public String helloObj() {
		return "Os meus objetivos para essa semana é absorver tudo quanto possível de conteúdo"
		+ "\n e firmar todo ele pranticando";
	}

}