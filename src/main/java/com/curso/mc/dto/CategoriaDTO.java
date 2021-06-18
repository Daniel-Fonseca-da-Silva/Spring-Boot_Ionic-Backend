package com.curso.mc.dto;

import java.io.Serializable;
import com.curso.mc.domain.Categoria;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
public class CategoriaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
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
