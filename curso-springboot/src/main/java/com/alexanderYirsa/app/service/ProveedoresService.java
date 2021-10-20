package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.Proveedores;

public interface ProveedoresService {
	
	public Iterable<Proveedores> findAll();
	public Page<Proveedores> findAll(Pageable pageable);
	public Optional<Proveedores> findById(Long id);
	public Proveedores save(Proveedores user);
	public void deleteById(Long id);

}
