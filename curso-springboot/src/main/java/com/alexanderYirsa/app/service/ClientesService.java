package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.Clientes;


public interface ClientesService {
	
	public Iterable<Clientes> findAll();
	public Page<Clientes> findAll(Pageable pageable);
	public Optional<Clientes> findById(Long id);
	public Clientes save(Clientes user);
	public void deleteById(Long id);

}
