package br.com.livro.controller;

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

import br.com.livro.dao.LivroDAO;
import br.com.livro.model.Livro;

@RestController
@EnableWebMvc
@RequestMapping(value = LivroController.PATH)
public class LivroController {
	
	public static final String PATH = "/livro";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Livro>> get () {
		return new ResponseEntity<List<Livro>>(livroDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Livro> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Livro>(livroDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		livroDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private LivroDAO livroDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Livro> save (@RequestBody final Livro livroEntity){
		return new ResponseEntity<Livro>(livroDAO.save(livroEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Livro> alter (@PathVariable("id") int id, @RequestBody final Livro livroEntity) {
		return new ResponseEntity<Livro>(livroDAO.save(livroEntity), HttpStatus.OK);
	}
	
}
