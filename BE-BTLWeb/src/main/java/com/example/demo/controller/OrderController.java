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
import com.example.demo.model.Orders;
import com.example.demo.service.BookService;
import com.example.demo.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/orders")
	public List<Orders> getAlls() {
		return orderService.getAll();
	}
	
	@GetMapping("/orders/{id}")
	public List<Orders> getAllOrder(@PathVariable String id) {
		return orderService.getAllByUserid(Integer.valueOf(id));
	}
	
	@PostMapping("/order") 
	public Orders createOrder(@RequestBody Orders order) {
		Books book = bookService.getBook(order.getBookid());
		book.setRemain(book.getRemain() - 1);
		book.setSold(book.getSold() + 1);
		bookService.saveBook(book);
		return orderService.create(order);
	}
	
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable String id) { 
		orderService.delete(Integer.valueOf(id));
	}
}	
