package com.apirest.nestor.api.rest.nestor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.nestor.api.rest.nestor.dao.IClienteDao;
import com.apirest.nestor.api.rest.nestor.entity.Cliente;

@Service
public class IClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> getAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente getClienteById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(long id) {
		clienteDao.deleteById(id);
		
	}

}
