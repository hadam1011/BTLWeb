package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_cartid")
	private int book_cartid;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "bookid")
	private int bookid;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "total")
	private int total;
	
	public BookCart() {}
	
	public BookCart(int book_cartid, int userid, int bookid, String title, int quantity, int price, int total) {
		this.book_cartid = book_cartid;
		this.userid = userid;
		this.bookid = bookid;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

	public int getBook_cartid() {
		return book_cartid;
	}

	public void setBook_cartid(int book_cartid) {
		this.book_cartid = book_cartid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
