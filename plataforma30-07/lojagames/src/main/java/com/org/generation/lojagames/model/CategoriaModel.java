package com.org.generation.lojagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // entidade - tabela
@Table(name = "tb_categoria") // nomear a tabela --> não é obrigatório
public class CategoriaModel { //classe publica
	
	@Id //id = chave primária
	@GeneratedValue (strategy = GenerationType.IDENTITY) //gerar numeros automaticos e o tipo/sequencia identity
	private long id; //atributo privado
	
	@NotNull (message = "O atributo não pode ser nulo!") //javax - não pode ser nulo
	private String tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	} 
	
}
