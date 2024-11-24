package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookCart;
import com.example.demo.model.Books;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private CommentService serviceComment;
	
	@Autowired
	private BookCartService serviceBookcart;
	
	@Autowired
	private BookService serviceBook;
	
	public List<User> getAllUser() {
		return repo.findAll();
	}	
	
	public User addUser(User user) {
		return repo.save(user);
	}
	
	public void deleteUser(int id) {
		// xóa comment
		List<Comment> comments = serviceComment.getAllComment();
		for (Comment comment : comments) {
			if (comment.getUserid() == id) {
				serviceComment.deleteComment(comment.getCommentid());
				Books book = serviceBook.getBook(comment.getBookid());
				serviceBook.saveBook(book);
			}
		}
		
		// Xóa sách trong giỏ hàng
		List<BookCart> bookcarts = serviceBookcart.getAllBookCart(id);
		for (BookCart bc : bookcarts) {
			serviceBookcart.deleteBookCart(bc.getBook_cartid());
		}
		
		repo.deleteById(id);
	}
}
