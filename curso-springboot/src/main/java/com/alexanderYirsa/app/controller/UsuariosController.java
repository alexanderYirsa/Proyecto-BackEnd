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
import com.alexanderYirsa.app.entity.Usuarios;
import com.alexanderYirsa.app.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
	//Comenatrio
	
	@Autowired
	private UsuariosService userService;
	
	// Create a new User
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@RequestBody Usuarios user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));	
	}
	
	//Read an user
	@GetMapping("/listar/{id}")
	public ResponseEntity<?> read(@PathVariable(value= "id") Long userId){
		Optional<Usuarios> oUser = userService.findById(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
		
	}
	
	//Update User
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Usuarios userDetails, @PathVariable(value="id") long userId){
		Optional<Usuarios> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(userDetails, user.get());
		user.get().setNombre_usuario(userDetails.getNombre_usuario());
		user.get().setEmail_usuario(userDetails.getEmail_usuario());
		user.get().setUsuario(userDetails.getUsuario());
		user.get().setPassword(userDetails.getPassword());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	// Delete an user
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		if(!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	//Read all users
	@GetMapping("/listar")
	public List<Usuarios> readAll(){
		
		List<Usuarios> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;	
	}
}
