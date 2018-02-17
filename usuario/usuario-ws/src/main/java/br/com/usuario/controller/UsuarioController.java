package br.com.usuario.controller;

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

import br.com.usuario.dao.UsuarioDAO;
import br.com.usuario.model.Usuario;

@RestController
@EnableWebMvc
@RequestMapping(value = UsuarioController.PATH)
public class UsuarioController {
	
	public static final String PATH = "/usuario";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Usuario>> get () {
		return new ResponseEntity<List<Usuario>>(usuarioDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Usuario>(usuarioDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		usuarioDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> save (@RequestBody final Usuario usuarioEntity){
		return new ResponseEntity<Usuario>(usuarioDAO.save(usuarioEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Usuario> alter (@PathVariable("id") int id, @RequestBody final Usuario usuarioEntity) {
		return new ResponseEntity<Usuario>(usuarioDAO.save(usuarioEntity), HttpStatus.OK);
	}
	
}
