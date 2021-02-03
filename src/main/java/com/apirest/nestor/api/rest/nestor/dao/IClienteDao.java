package com.apirest.nestor.api.rest.nestor.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.nestor.api.rest.nestor.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long>{

}
