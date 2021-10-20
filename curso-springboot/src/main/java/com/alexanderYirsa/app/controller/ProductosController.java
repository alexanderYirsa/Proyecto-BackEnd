package com.alexanderYirsa.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexanderYirsa.app.entity.Productos;
import com.alexanderYirsa.app.repository.ProductosRepository;


@RestController //esta es una clase REST
//@RequestMapping(value="productos",method=RequestMethod.GET)
//value=tabla de la bd
@RequestMapping("/api/productos")
public class ProductosController {
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private ProductosRepository productosRepository;
	
	@GetMapping("/listar")
	public List<Productos> listar(){
		return productosRepository.findAll();
	}
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Productos productos) {
		productosRepository.save(productos);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		productosRepository.deleteById(id);
	}
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Productos productos) {
		productosRepository.save(productos);
	}
	
}