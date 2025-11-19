package br.com.fiap.gs.repository;

import br.com.fiap.gs.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}