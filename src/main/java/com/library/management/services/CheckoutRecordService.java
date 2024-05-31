package com.library.management.services;

import java.util.List;

import com.library.management.model.CheckoutRecord;

public interface CheckoutRecordService {
	long createCheckoutRecord(CheckoutRecord checkoutRecord);
    boolean updateCheckoutRecord(CheckoutRecord checkoutRecord);
    CheckoutRecord getCheckoutRecordById(long checkoutRecordId);
    boolean deleteCheckoutRecord(long checkoutRecordId);
    List<CheckoutRecord> getAllCheckoutRecords();
    public List<CheckoutRecord> getCheckoutRecordsByUserId(int userId);
}
