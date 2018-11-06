package com.algaworks.festas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Convidado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Integer qtde;
	
	@ManyToOne
    @JoinColumn(name = "festa_id")
	@NotNull(message = "Festa Obrigatória")
	private Festa festa;
	
	//
	
	

	//-------Getters and Setters  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	
	public Festa getFesta() {
		return festa;
	}
	
	public void setFesta(Festa festa) {
		this.festa = festa;
	}
}
