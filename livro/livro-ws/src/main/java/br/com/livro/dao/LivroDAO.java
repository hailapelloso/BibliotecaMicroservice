package br.com.livro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.livro.model.Livro;

@Repository
public interface LivroDAO extends JpaRepository<Livro, Integer>{

}
