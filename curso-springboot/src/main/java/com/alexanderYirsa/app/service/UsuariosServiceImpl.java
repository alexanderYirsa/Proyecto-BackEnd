package com.alexanderYirsa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alexanderYirsa.app.entity.Usuarios;
import com.alexanderYirsa.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	private UsuariosRepository userResRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuarios> findAll() {
		
		return userResRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuarios> findAll(Pageable pageable) {
		
		return userResRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuarios> findById(Long id) {
		
		return userResRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuarios save(Usuarios user) {
		
		return userResRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		userResRepository.deleteById(id);
	}

}
