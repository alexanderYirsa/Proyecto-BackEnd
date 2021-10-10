package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alexanderYirsa.app.entity.Usuarios;

public interface UsuariosService {
	
	public Iterable<Usuarios> findAll();
	public Page<Usuarios> findAll(Pageable pageable);
	public Optional<Usuarios> findById(Long id);
	public Usuarios save(Usuarios user);
	public void deleteById(Long id);

}
