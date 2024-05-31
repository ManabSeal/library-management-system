package com.library.management.exception;

public class CheckoutRecordNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long checkoutId;
    private String message;

    public CheckoutRecordNotFoundException(long checkoutId) {
        this.checkoutId = checkoutId;
        this.message = "Checkout with ID '" + checkoutId + "' not found";
    }

    public long getCheckoutId() {
        return checkoutId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

