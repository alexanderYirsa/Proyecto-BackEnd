package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.DetalleVentas;


public interface DetalleVentasService {
	
	public Iterable<DetalleVentas> findAll();
	public Page<DetalleVentas> findAll(Pageable pageable);
	public Optional<DetalleVentas> findById(Long id);
	public DetalleVentas save(DetalleVentas user);
	public void deleteById(Long id);

}
