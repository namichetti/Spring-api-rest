package com.apirest.nestor.api.rest.nestor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.nestor.api.rest.nestor.entity.Cliente;
import com.apirest.nestor.api.rest.nestor.service.IClienteService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/")
	public List<Cliente> index(){
		return clienteService.getAll();
	}
	
	@GetMapping("/{id}")
	public Cliente show(@PathVariable(value="id")Long id){
		return clienteService.getClienteById(id);
	}
		
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente){
		return clienteService.save(cliente);
	}
		
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable(value="id")Long id) {
		Cliente clienteActual = clienteService.getClienteById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value="id")Long id) {
		 clienteService.delete(id);
	}
	
	
}
