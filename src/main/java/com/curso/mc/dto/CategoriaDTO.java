package com.curso.mc.dto;

import java.io.Serializable;

import com.curso.mc.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer id;
	private String nome;
	
	// Construtor vazio
	public CategoriaDTO(){}
	
	// Construtor
	public CategoriaDTO(Categoria obj)
	{
		id = obj.getId();
		nome = obj.getNome();
	}
	
	// Gets e Sets
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
}
