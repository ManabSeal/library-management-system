package com.library.management.exception;

public class BookNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookId;
    private String message;

    public BookNotFoundException(int bookId) {
        this.bookId = bookId;
        this.message = "Book with ID '" + bookId + "' not found";
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
