package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookCart;
import com.example.demo.model.Books;
import com.example.demo.model.Comment;
import com.example.demo.model.Orders;
import com.example.demo.model.Star;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private CommentService serviceComment;
	
	@Autowired
	private BookCartService serviceBookCart;
	
	@Autowired
	private StarService starService;
	
	@Autowired
	private OrderService ordersService;
	
	public List<Books> getBooks() {
		return repo.findAll();
	}
	
	public Books getBook(int id) {
		Optional<Books> book = repo.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		throw new RuntimeException("Khong tim thay sach co id la " + id);
	}
	
	public Books saveBook(Books book) {
		return repo.save(book);
	}
	
	public Books updateBook(Books book) {
		return repo.save(book);
	}
	
	public void deleteBook(int id) {
		// xóa comment của sách
		List<Comment> comments = serviceComment.findAllByBookId(id);
		for (Comment comment : comments) {
			serviceComment.deleteComment(comment.getCommentid());
		}
		
		// xóa sách trong giỏ hàng
		Books book = repo.findById(id).get();
		List<BookCart> bookcarts = serviceBookCart.findAllByTitle(book.getTitle());
		for (BookCart bookcart : bookcarts) {
			serviceBookCart.deleteBookCart(bookcart.getBook_cartid());
		}
		
		// xóa sao
		List<Star> stars = starService.getAllByBookid(id);
		for (Star star: stars) {
			starService.delete(star.getStarid());
		}
		
		// xóa sách trong lịch sử mua hàng
		List<Orders> orders = ordersService.getAllByBookid(id);
		for (Orders order : orders) {
			ordersService.delete(order.getOrderid());
		}
		
		repo.deleteById(id);
	}
	
	public Optional<Books> findByTitle(String title) {
		return repo.findByTitle(title);
	}
	
	public Optional<Books> findByAuthor(String title) {
		return repo.findByAuthor(title);
	}
}
