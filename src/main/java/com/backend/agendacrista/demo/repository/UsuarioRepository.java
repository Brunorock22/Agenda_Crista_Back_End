package com.backend.agendacrista.demo.repository;

import com.backend.agendacrista.demo.model.Igreja;
import com.backend.agendacrista.demo.model.Usuario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAllByIgrejasFavoritasContaining(Igreja igreja);
}

