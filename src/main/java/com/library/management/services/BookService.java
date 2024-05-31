package com.library.management.services;

import java.util.List;

import com.library.management.model.Book;

public interface BookService {
	int createBook(Book book);
    boolean updateBook(Book book);
    Book getBookById(int bookId);
    boolean deleteBook(int bookId);
    List<Book> getAllBooks();
}
