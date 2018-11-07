package com.algaworks.festas.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Festa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String data;
	private String hora;
	private String foto;
	
	@OneToMany(mappedBy = "festa", cascade = CascadeType.ALL)
	private Set<Convidado> convidados;
	
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}
	public Set<Convidado> getConvidados() {
		return convidados;
	}
	public void setConvidados(Set<Convidado> convidados) {
		this.convidados = convidados;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	



}
