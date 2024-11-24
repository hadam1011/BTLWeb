package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.model.Comment;
import com.example.demo.service.BookService;
import com.example.demo.service.CommentService;

@RestController
@CrossOrigin
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/comments")
	public List<Comment> getComments() {
		return commentService.getAllComment();
	}
	
	@PostMapping("/comment")
	public Comment creatComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable String id) {
		//update book
		Comment comment = commentService.findById(Integer.valueOf(id)).get();
		Books book = bookService.getBook(comment.getBookid());	
		commentService.deleteComment(Integer.valueOf(id));
	}
}
