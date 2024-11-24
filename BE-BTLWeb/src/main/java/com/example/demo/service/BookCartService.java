package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.BookCart;
import com.example.demo.repository.BookCartRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class BookCartService {
	@Autowired
	private BookCartRepository repo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<BookCart> getAllBookCart(int id) {
		String sql = "select bc from BookCart bc where bc.userid = :id";
		return entityManager.createQuery(sql, BookCart.class)
				.setParameter("id", id)
				.getResultList();
	}
	
	public BookCart saveBookCart(BookCart bookcart) {
		return repo.save(bookcart);
	}
	
	public void deleteBookCart(int id) {
		repo.deleteById(id);
	}
	
	public List<BookCart> findAllByTitle(String title){
		String sql = "select bc from BookCart bc where bc.title = :title";
		return entityManager.createQuery(sql, BookCart.class)
				.setParameter("title", title)
				.getResultList();
	}
}
