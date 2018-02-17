package br.com.emprestimo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emprestimo.model.Emprestimo;

@Repository
public interface EmprestimoDAO extends JpaRepository<Emprestimo, Integer>{

}
