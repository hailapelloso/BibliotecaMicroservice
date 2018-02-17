package br.com.autor.controller;

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

import br.com.autor.dao.AutorDAO;
import br.com.autor.model.Autor;

@RestController
@EnableWebMvc
@RequestMapping(value = AutorController.PATH)
public class AutorController {
	
	public static final String PATH = "/autor";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Autor>> get () {
		return new ResponseEntity<List<Autor>>(autorDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Autor>(autorDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		autorDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private AutorDAO autorDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Autor> save (@RequestBody final Autor autorEntity){
		return new ResponseEntity<Autor>(autorDAO.save(autorEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Autor> alter (@PathVariable("id") int id, @RequestBody final Autor autorEntity) {
		return new ResponseEntity<Autor>(autorDAO.save(autorEntity), HttpStatus.OK);
	}
	
}
