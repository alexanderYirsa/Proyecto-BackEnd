package com.alexanderYirsa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexanderYirsa.app.entity.Productos;


@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long>{
	
}