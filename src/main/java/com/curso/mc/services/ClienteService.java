package com.curso.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.mc.domain.Cliente;
import com.curso.mc.dto.ClienteDTO;
import com.curso.mc.repositories.ClienteRepository;
import com.curso.mc.services.exceptions.DataIntegretyException;
import com.curso.mc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired // Instânciamento automático
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	// Implementação atualiza Cliente
		public Cliente update(Cliente obj)
		{
			Cliente newObj = find(obj.getId());
			updateData(newObj, obj);
			return repo.save(newObj);
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
				throw new DataIntegretyException("Não é possível excluir porque existem entidades relacionadas");
			}
		}
		
		// Implementação exibe tudo
		public List<Cliente> findAll()
		{
			return repo.findAll();
		}
		
		// Recupera somente uma quantidade
		public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy,  String direction)
		{
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Cliente fromDTO(ClienteDTO objDto)
		{
			return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
		}
		
		private void updateData(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}
	
}