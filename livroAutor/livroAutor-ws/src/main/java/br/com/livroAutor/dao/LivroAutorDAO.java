package br.com.livroAutor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livroAutor.model.LivroAutor;

@Repository
public interface LivroAutorDAO extends JpaRepository<LivroAutor, Integer>{

}
