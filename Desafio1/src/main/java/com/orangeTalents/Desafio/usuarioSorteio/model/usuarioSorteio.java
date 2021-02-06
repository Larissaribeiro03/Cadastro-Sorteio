package com.orangeTalents.Desafio.usuarioSorteio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuarioSorteio") // cria a tabela tb_usuario_sorteio
public class usuarioSorteio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerador auto incrometa IDs
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "sorteio")
	private Integer sorteio;

	@Column(name = "email")
	private String email;
	
	public usuarioSorteio() {
		
	}

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

	public Integer getSorteio() {
		return sorteio;
	}

	public void setSorteio(Integer sorteio) {
		this.sorteio = sorteio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
	