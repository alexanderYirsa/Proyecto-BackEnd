package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexanderYirsa.app.entity.Clientes;
import com.alexanderYirsa.app.repository.ClientesRepository;


@Service
public class ClientesServiceImpl implements ClientesService{

	@Autowired
	private ClientesRepository clienteResRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Clientes> findAll() {
		
		return clienteResRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Clientes> findAll(Pageable pageable) {
		
		return clienteResRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Clientes> findById(Long id) {
		
		return clienteResRepository.findById(id);
	}

	@Override
	@Transactional
	public Clientes save(Clientes user) {
		
		return clienteResRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		clienteResRepository.deleteById(id);
	}

}
