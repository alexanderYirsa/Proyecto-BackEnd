package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.Productos;

public interface ProductosService {
	
	public Iterable<Productos> findAll();
	public Page<Productos> findAll(Pageable pageable);
	public Optional<Productos> findById(Long id);
	public Productos save(Productos user);
	public void deleteById(Long id);

}
