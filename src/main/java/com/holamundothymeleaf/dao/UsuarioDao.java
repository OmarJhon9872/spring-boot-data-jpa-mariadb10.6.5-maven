package com.holamundothymeleaf.dao;

import com.holamundothymeleaf.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
