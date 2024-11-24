	package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookCart;
import com.example.demo.model.Books;
import com.example.demo.service.BookCartService;
import com.example.demo.service.BookService;

@RestController
@CrossOrigin
public class BookCartController {
	@Autowired
	private BookCartService bookCartService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book-cart/{id}")
	public List<BookCart> getBookCartById(@PathVariable String id) {
		return bookCartService.getAllBookCart(Integer.valueOf(id));
	}
	
	@PostMapping("/book-cart")
	public BookCart saveBookCart (@RequestBody BookCart bookcart) {
		return bookCartService.saveBookCart(bookcart);
	}
	
	@PutMapping("/book-cart/{id}")
	public BookCart updateBookCart (@PathVariable String id, @RequestBody BookCart bookcart) {
		bookcart.setBook_cartid(Integer.valueOf(id));
		return bookCartService.saveBookCart(bookcart);
	}
	
	@DeleteMapping("book-cart/{id}")
	public void deleteBookCart(@PathVariable String id) {
		bookCartService.deleteBookCart(Integer.valueOf(id));
	}
}
