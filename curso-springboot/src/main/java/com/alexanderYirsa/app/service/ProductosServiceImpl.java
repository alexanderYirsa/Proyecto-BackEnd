package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexanderYirsa.app.entity.Productos;
import com.alexanderYirsa.app.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{

	@Autowired
	private ProductosRepository productosRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Productos> findAll() {
		
		return productosRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Productos> findAll(Pageable pageable) {
		
		return productosRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Productos> findById(Long id) {
		
		return productosRepository.findById(id);
	}

	@Override
	@Transactional
	public Productos save(Productos user) {
		
		return productosRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		productosRepository.deleteById(id);
	}

}
