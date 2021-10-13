package com.alexanderYirsa.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;

import com.alexanderYirsa.app.entity.Clientes;
import com.alexanderYirsa.app.service.ClientesService;


@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clienteService;
	
	// Create a new User
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Clientes cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));	
	}
	
	//Read an user
	@GetMapping("/listar/{id}")
	public ResponseEntity<?> read(@PathVariable(value= "id") Long userId){
		Optional<Clientes> oUser = clienteService.findById(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
		
	}
	
	//Update User
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Clientes userDetails, @PathVariable(value="id") long userId){
		Optional<Clientes> user = clienteService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(userDetails, user.get());
		user.get().setNombre_cliente(userDetails.getNombre_cliente());
		user.get().setEmail_cliente(userDetails.getEmail_cliente());
		user.get().setDireccion_cliente(userDetails.getDireccion_cliente());
		user.get().setTelefono_cliente(userDetails.getTelefono_cliente());
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(user.get()));
	}
	
	// Delete an user
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		if(!clienteService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clienteService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	//Read all users
	@GetMapping("/listar")
	public List<Clientes> readAll(){
		
		List<Clientes> users = StreamSupport
				.stream(clienteService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;	
	}
}
