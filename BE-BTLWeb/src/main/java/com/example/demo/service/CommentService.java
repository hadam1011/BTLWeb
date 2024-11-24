package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Comment> getAllComment() {
		return repo.findAll();
	}
	
	public Comment saveComment(Comment comment) {
		return repo.save(comment);
	}
	
	public List<Comment> findAllByBookId(int id) {
		String sql = "select cm from Comment cm where cm.bookid = :id";
		return entityManager.createQuery(sql, Comment.class)
				.setParameter("id", id)
				.getResultList();
	}
	
	public void deleteComment(int id) {
		repo.deleteById(id);
	}
	
	public Optional<Comment> findById(int id) {
		return repo.findById(id);
	}
}
