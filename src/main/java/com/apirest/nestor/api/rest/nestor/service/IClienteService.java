package com.apirest.nestor.api.rest.nestor.service;

import java.util.List;

import com.apirest.nestor.api.rest.nestor.entity.Cliente;

public interface IClienteService {

	public List<Cliente> getAll();
	public Cliente getClienteById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(long id);
	
}
