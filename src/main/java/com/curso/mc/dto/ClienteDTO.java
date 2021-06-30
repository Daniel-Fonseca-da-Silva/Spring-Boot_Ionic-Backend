package com.curso.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.curso.mc.domain.Cliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	// Variáveis
	private Integer id;
	
	@NotEmpty(message = "Campo obrigátorio")
	@Length(min = 5, max = 50, message = "O tamanho deve conter entre 5 e 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo obrigátorio")
	@Email(message = "Digite um email válido")
	private String email;

	// Construtor vazio
	ClienteDTO(){}

	// Construtor povoado
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
	
	// Gets e Sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}