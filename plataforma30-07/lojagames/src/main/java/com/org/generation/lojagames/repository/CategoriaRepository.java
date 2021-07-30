package com.org.generation.lojagames.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.generation.lojagames.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{ //interface, puxando dependencia do pom.xml
	//assinatura de método
	
	public List<CategoriaModel> findByTipoContainigIgnoreCase(String tipo);

}
