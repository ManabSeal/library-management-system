package com.library.management.exception;

public class AdminNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adminId;
    private String message;

    public AdminNotFoundException(int adminId) {
        this.adminId = adminId;
        this.message = "Admin with ID '" + adminId + "' not found";
    }

    public int getAdminId() {
        return adminId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
