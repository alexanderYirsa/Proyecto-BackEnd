package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.Ventas;


public interface VentasService {
	
	public Iterable<Ventas> findAll();
	public Page<Ventas> findAll(Pageable pageable);
	public Optional<Ventas> findById(Long id);
	public Ventas save(Ventas user);
	public void deleteById(Long id);

}
