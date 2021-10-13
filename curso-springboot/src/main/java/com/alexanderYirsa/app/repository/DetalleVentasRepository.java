package com.alexanderYirsa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexanderYirsa.app.entity.DetalleVentas;


@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentas, Long>{
	
}