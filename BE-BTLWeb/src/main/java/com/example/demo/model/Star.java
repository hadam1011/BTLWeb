package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Star {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "starid")
	private int starid;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "bookid")
	private int bookid;
	
	@Column(name = "star")
	private int star;
	
	public Star () {}

	public Star(int starid, int userid, int bookid, int star) {
		this.starid = starid;
		this.userid = userid;
		this.bookid = bookid;
		this.star = star;
	}

	public int getStarid() {
		return starid;
	}

	public void setStarid(int starid) {
		this.starid = starid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
}
