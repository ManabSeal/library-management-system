package com.library.management.view.checkout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.library.management.model.CheckoutRecord;
import com.library.management.services.CheckoutRecordService;
import com.library.management.services.CheckoutRecordServiceImpl;

public class RenewBookScreen{
	private long checkoutId;
	private JFrame renewBookFrame;

    private final static CheckoutRecordService checkoutRecordService = new CheckoutRecordServiceImpl();

	/**
	 * @param checkoutId
	 */
	public RenewBookScreen(long checkoutId) {
		super();
		this.checkoutId = checkoutId;
		initializeUI();
	}

	/**
	 * @return the checkoutId
	 */
	public long getCheckoutId() {
		return checkoutId;
	}

	/**
	 * @param checkoutId the checkoutId to set
	 */
	public void setCheckoutId(long checkoutId) {
		this.checkoutId = checkoutId;
	}
	
	private void initializeUI() {
        renewBookFrame = new JFrame("Return Book");
        renewBookFrame.setLayout(new GridLayout(3, 2));
        final CheckoutRecord checkoutRecord = checkoutRecordService.getCheckoutRecordById(checkoutId);
        JLabel bookNameLabel = new JLabel("Book Name: "+checkoutRecord.getBook().getBookName());
        
        JLabel userNameLabel = new JLabel("User Name: " + checkoutRecord.getUser().getUserName());
        
        JLabel checkoutDateLabel = new JLabel("Checkout Date: "+ checkoutRecord.getCheckoutDate());
        
        JLabel expectedReturnDateLabel = new JLabel("Expected Return Date: "+checkoutRecord.getReturnDate());
        JButton renewButton = new JButton("Renew");
        JButton cancelButton = new JButton("Cancel");

        renewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              

                if (checkoutRecord != null) {
                	if(checkoutRecord.getActualReturnDate()==null) {
                		checkoutRecord.setReturnDate(checkoutRecord.getReturnDate().plusDays(14)); 

                        // Perform update to mark the book as returned and set fine
                        boolean updateSuccess = checkoutRecordService.updateCheckoutRecord(checkoutRecord);
                        if (updateSuccess) {
                            JOptionPane.showMessageDialog(null, "Book renew successfully. New return date " + checkoutRecord.getReturnDate() );
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to renew book.");
                        }
                	}else {
                		JOptionPane.showMessageDialog(null, "Book Already Returned");
                	}
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Checkout Record not found.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renewBookFrame.dispose(); // Close the window on cancel
            }
        });

        renewBookFrame.add(bookNameLabel);
        renewBookFrame.add(userNameLabel);
        renewBookFrame.add(checkoutDateLabel);
        renewBookFrame.add(expectedReturnDateLabel);
        renewBookFrame.add(renewButton);
        renewBookFrame.add(cancelButton);

        renewBookFrame.pack();
        renewBookFrame.setLocationRelativeTo(null);
        renewBookFrame.setVisible(true);
	}
	
}
