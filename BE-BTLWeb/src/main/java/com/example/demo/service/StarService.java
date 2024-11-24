package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Star;
import com.example.demo.repository.StarRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StarService {
	@Autowired
	private StarRepository starRepo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Star> getAll() {
		return starRepo.findAll();
	}
	
	public List<Star> getAllByBookid(int id){
		String sql = "select s from Star s where s.bookid = :id";
		return entityManager.createQuery(sql, Star.class)
				.setParameter("id", id)
				.getResultList();
	}
	
	public Star save(Star star) {
		return starRepo.save(star);
	}
	
	public void delete (int id) {
		starRepo.deleteById(id);
	}
}
