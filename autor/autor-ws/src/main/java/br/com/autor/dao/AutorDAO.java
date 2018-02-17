package br.com.autor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autor.model.Autor;

@Repository
public interface AutorDAO extends JpaRepository<Autor, Integer>{

}
