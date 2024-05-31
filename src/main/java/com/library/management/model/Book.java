package com.library.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookinfo")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String bookName;
	private String authorName;
	public Book() {
		super();
	}

	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}
	public Book(int bookId, String bookName, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return bookId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.bookId = id;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + "]";
	}
	
	
	
}
