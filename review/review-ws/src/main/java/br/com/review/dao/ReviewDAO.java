package br.com.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.review.model.Review;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Integer>{

}
