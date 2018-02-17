package br.com.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.usuario.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}
