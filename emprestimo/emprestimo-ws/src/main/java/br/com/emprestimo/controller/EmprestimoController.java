package br.com.emprestimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.emprestimo.dao.EmprestimoDAO;
import br.com.emprestimo.model.Emprestimo;

@RestController
@EnableWebMvc
@RequestMapping(value = EmprestimoController.PATH)
public class EmprestimoController {
	
	public static final String PATH = "/emprestimo";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Emprestimo>> get () {
		return new ResponseEntity<List<Emprestimo>>(emprestimoDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Emprestimo> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Emprestimo>(emprestimoDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		emprestimoDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private EmprestimoDAO emprestimoDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Emprestimo> save (@RequestBody final Emprestimo emprestimoEntity){
		return new ResponseEntity<Emprestimo>(emprestimoDAO.save(emprestimoEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Emprestimo> alter (@PathVariable("id") int id, @RequestBody final Emprestimo emprestimoEntity) {
		return new ResponseEntity<Emprestimo>(emprestimoDAO.save(emprestimoEntity), HttpStatus.OK);
	}
	
}
