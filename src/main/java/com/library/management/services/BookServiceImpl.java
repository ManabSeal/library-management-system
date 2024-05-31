package com.library.management.services;

import java.util.List;

import com.library.management.exception.BookNotFoundException;
import com.library.management.model.Book;
import com.library.management.repository.BookRepository;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public int createBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public Book getBookById(int bookId) {
        try {
            return bookRepository.findById(bookId);
        } catch (BookNotFoundException e) {
            // Log the exception or handle it according to your application's needs
            // For example, throw a custom exception or return null
            
            return null;
        }catch(Exception e) {
        	return null;
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public boolean updateBook(Book book) {
        return bookRepository.saveOrUpdateBook(book);
    }

    // Additional methods as needed for book service functionalities
}

