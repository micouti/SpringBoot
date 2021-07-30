package com.org.generation.lojagames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.generation.lojagames.model.CategoriaModel;
import com.org.generation.lojagames.repository.CategoriaRepository;

@RestController //classe controller
@RequestMapping ("/categorias") // mapear end points 
@CrossOrigin(origins="*", allowedHeaders="*")
public class CategoriaController {
	
	@Autowired //injeção de dependencias - tomada de controle
	private CategoriaRepository categoriaRepository; //chamando interface repository e  criando objeto para a categoria
	
	@GetMapping
	private ResponseEntity<List<CategoriaModel>> getAll(){
		
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<CategoriaModel> getById(@PathVariable long id){
		
		return categoriaRepository.findById(id)  // mapeamento do objeto
				.map(resp -> ResponseEntity.ok(resp)) //resp recebe o response, se holver algo, mostre
				.orElse(ResponseEntity.notFound().build()); // resp não recebeu nada, devolva not found *build constrói o não encontrado	
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoriaModel));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel categoriaModel){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoriaModel));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		categoriaRepository.deleteById(id);
	}
}
