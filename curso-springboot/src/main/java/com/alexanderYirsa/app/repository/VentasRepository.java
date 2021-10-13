package com.alexanderYirsa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexanderYirsa.app.entity.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long>{

}
