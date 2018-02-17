package br.com.contato.controller;

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

import br.com.contato.dao.ContatoDAO;
import br.com.contato.model.Contato;

@RestController
@EnableWebMvc
@RequestMapping(value = ContatoController.PATH)
public class ContatoController {
	
	public static final String PATH = "/contato";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Contato>> get () {
		return new ResponseEntity<List<Contato>>(contatoDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Contato>(contatoDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		contatoDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private ContatoDAO contatoDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Contato> save (@RequestBody final Contato contatoEntity){
		return new ResponseEntity<Contato>(contatoDAO.save(contatoEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Contato> alter (@PathVariable("id") int id, @RequestBody final Contato contatoEntity) {
		return new ResponseEntity<Contato>(contatoDAO.save(contatoEntity), HttpStatus.OK);
	}
	
}
