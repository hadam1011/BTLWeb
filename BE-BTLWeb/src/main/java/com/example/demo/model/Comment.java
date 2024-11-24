package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentid")
	private int commentid;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "bookid")
	private int bookid;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "date")
	private String date;
	
	public Comment() {}

	public Comment(int commentid, int userid, int bookid, String content, String username, String date) {
		super();
		this.commentid = commentid;
		this.userid = userid;
		this.bookid = bookid;
		this.content = content;
		this.username = username;
		this.date = date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
