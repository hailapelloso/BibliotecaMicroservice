package br.com.contato.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contato.model.Contato;

@Repository
public interface ContatoDAO extends JpaRepository<Contato, Integer>{

}
