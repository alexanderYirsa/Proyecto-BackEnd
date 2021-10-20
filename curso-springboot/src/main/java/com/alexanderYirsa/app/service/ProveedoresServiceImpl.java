package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexanderYirsa.app.entity.Proveedores;
import com.alexanderYirsa.app.repository.ProveedoresRepository;


@Service
public class ProveedoresServiceImpl implements ProveedoresService{

	@Autowired
	private ProveedoresRepository proveedoresRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Proveedores> findAll() {
		
		return proveedoresRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Proveedores> findAll(Pageable pageable) {
		
		return proveedoresRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedores> findById(Long id) {
		
		return proveedoresRepository.findById(id);
	}

	@Override
	@Transactional
	public Proveedores save(Proveedores user) {
		
		return proveedoresRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		proveedoresRepository.deleteById(id);
	}

}
