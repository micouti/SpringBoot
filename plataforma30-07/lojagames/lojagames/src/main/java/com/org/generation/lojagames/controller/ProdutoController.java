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

import com.org.generation.lojagames.model.ProdutoModel;
import com.org.generation.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll(){
		
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id){
		
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel produtoModel){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtoRepository.save(produtoModel));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel produtoModel){
		return ResponseEntity.ok(produtoRepository.save(produtoModel));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		produtoRepository.deleteById(id);
	}
}