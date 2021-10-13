package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexanderYirsa.app.entity.Usuarios;
import com.alexanderYirsa.app.entity.Ventas;
import com.alexanderYirsa.app.repository.UsuariosRepository;
import com.alexanderYirsa.app.repository.VentasRepository;

@Service
public class VentasServiceImpl implements VentasService{

	@Autowired
	private VentasRepository ventasResRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Ventas> findAll() {
		
		return ventasResRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Ventas> findAll(Pageable pageable) {
		
		return ventasResRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Ventas> findById(Long id) {
		
		return ventasResRepository.findById(id);
	}

	@Override
	@Transactional
	public Ventas save(Ventas user) {
		
		return ventasResRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		ventasResRepository.deleteById(id);
	}

}
