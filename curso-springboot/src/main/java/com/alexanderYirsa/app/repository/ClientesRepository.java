package com.alexanderYirsa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexanderYirsa.app.entity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
