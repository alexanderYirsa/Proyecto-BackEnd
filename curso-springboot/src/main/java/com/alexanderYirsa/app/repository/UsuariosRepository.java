package com.alexanderYirsa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexanderYirsa.app.entity.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

}
