package br.com.review.controller;

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

import br.com.review.dao.ReviewDAO;
import br.com.review.model.Review;

@RestController
@EnableWebMvc
@RequestMapping(value = ReviewController.PATH)
public class ReviewController {
	
	public static final String PATH = "/review";
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)	
	public ResponseEntity<List<Review>> get () {
		return new ResponseEntity<List<Review>>(reviewDAO.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Review> get (@PathVariable("id") int id) {		
		return new ResponseEntity<Review>(reviewDAO.findOne(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)	
	public HttpStatus delete (@PathVariable("id") int id) {
		reviewDAO.delete(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Review> save (@RequestBody final Review reviewEntity){
		return new ResponseEntity<Review>(reviewDAO.save(reviewEntity), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)	
	public ResponseEntity<Review> alter (@PathVariable("id") int id, @RequestBody final Review reviewEntity) {
		return new ResponseEntity<Review>(reviewDAO.save(reviewEntity), HttpStatus.OK);
	}
	
}
