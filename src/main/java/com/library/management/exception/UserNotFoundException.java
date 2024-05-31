package com.library.management.exception;

public class UserNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String message;

    public UserNotFoundException(int userId) {
        this.userId = userId;
        this.message = "User with ID '" + userId + "' not found";
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
