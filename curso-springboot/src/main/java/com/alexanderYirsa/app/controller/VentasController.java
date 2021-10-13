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
import com.alexanderYirsa.app.entity.Ventas;
import com.alexanderYirsa.app.repository.VentasRepository;
import com.alexanderYirsa.app.service.ClientesService;
import com.alexanderYirsa.app.service.VentasService;


@RestController
@RequestMapping("/api/ventas")
public class VentasController {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO
	private VentasRepository ventasDAO;
	
	@GetMapping("/listar")
	public List<Ventas> listar(){
		return ventasDAO.findAll();
	}
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon
	public void guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		ventasDAO.deleteById(id);
	}
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
}
