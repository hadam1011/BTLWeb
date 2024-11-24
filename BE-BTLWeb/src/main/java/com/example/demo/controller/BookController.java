package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Books;
import com.example.demo.service.BookService;

@RestController
@CrossOrigin
public class BookController {
	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Books> getBooks() {
		return service.getBooks();
	}
	
	@GetMapping("/books/{id}")
	public Books getBook(@PathVariable String id) {
		return service.getBook(Integer.valueOf(id));
	}	
	
	@PostMapping("/book")
	public Books addBook(@RequestBody Books book) {
		return service.saveBook(book);
	}
		
	@PutMapping("/book/{id}")
	public Books updateBook(@PathVariable String id, @RequestBody Books book) {
		book.setBookcode(Integer.valueOf(id));
		return service.updateBook(book);
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable String id) {
		service.deleteBook(Integer.valueOf(id));
	}
}
