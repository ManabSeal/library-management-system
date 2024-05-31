package com.library.management.services;

import java.util.List;

import com.library.management.exception.CheckoutRecordNotFoundException;
import com.library.management.model.CheckoutRecord;
import com.library.management.repository.CheckoutRecordRepository;

public class CheckoutRecordServiceImpl implements CheckoutRecordService{
	 private final CheckoutRecordRepository checkoutRecordRepository;

	    public CheckoutRecordServiceImpl() {
	        this.checkoutRecordRepository = new CheckoutRecordRepository();
	    }
	    
	    @Override
	    public long createCheckoutRecord(CheckoutRecord checkoutRecord) {
	        return checkoutRecordRepository.saveCheckoutRecord(checkoutRecord);
	    }

	    @Override
	    public CheckoutRecord getCheckoutRecordById(long checkoutRecordId) {
	    	try {
	    		return checkoutRecordRepository.findById(checkoutRecordId);
	    	}catch(CheckoutRecordNotFoundException e) {
	    		return null;
	    	}catch(Exception e) {
	    		return null;
	    	}
	        
	    }

	    @Override
	    public boolean deleteCheckoutRecord(long checkoutRecordId) {
	        return checkoutRecordRepository.deleteCheckoutRecord(checkoutRecordId);
	    }

	    @Override
	    public List<CheckoutRecord> getAllCheckoutRecords() {
	        return checkoutRecordRepository.findAllCheckoutRecords();
	    }

	    @Override
	    public boolean updateCheckoutRecord(CheckoutRecord checkoutRecord) {
	        return checkoutRecordRepository.saveOrUpdateCheckoutRecord(checkoutRecord);
	    }

		@Override
		public List<CheckoutRecord> getCheckoutRecordsByUserId(int userId) {
			// TODO Auto-generated method stub
			return checkoutRecordRepository.getCheckoutRecordsByUserId(userId);
		}
}
