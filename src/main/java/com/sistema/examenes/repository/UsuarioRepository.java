package com.sistema.examenes.repository;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
