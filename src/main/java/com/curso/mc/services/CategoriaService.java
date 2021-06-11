package com.curso.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.mc.domain.Categoria;
import com.curso.mc.repositories.CategoriaRepository;
import com.curso.mc.services.exceptions.DataIntegretyException;
import com.curso.mc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired // Instânciamento automático
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) 
	{
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	// Implementação insere nova Categoria
	public Categoria insert(Categoria obj) 
	{
		obj.setId(null);
		return repo.save(obj);
	}
	
	// Implementação atualiza Categoria
	public Categoria update(Categoria obj)
	{
		find(obj.getId());
		return repo.save(obj);
	}
	
	// Implementação deleta
	public void delete(Integer id)
	{
		find(id);
		try
		{
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e)
		{
			throw new DataIntegretyException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	// Implementação exibe tudo
	public List<Categoria> findAll()
	{
		return repo.findAll();
	}
	
	// Recupera somente uma quantidade
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy,  String direction)
	{
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
