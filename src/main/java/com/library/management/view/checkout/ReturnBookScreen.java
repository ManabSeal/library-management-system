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
import javax.swing.JTextField;
import com.library.management.model.CheckoutRecord;
import com.library.management.services.CheckoutRecordService;
import com.library.management.services.CheckoutRecordServiceImpl;

public class ReturnBookScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private long checkoutId;
    private JFrame returnBookFrame;

    private final static CheckoutRecordService checkoutRecordService = new CheckoutRecordServiceImpl();
    

    public ReturnBookScreen(long checkoutId) {
    	super();
    	this.checkoutId = checkoutId;
        initializeUI();
    }

    private void initializeUI() {
        returnBookFrame = new JFrame("Return Book");
        returnBookFrame.setLayout(new GridLayout(3, 2));
        final CheckoutRecord checkoutRecord = checkoutRecordService.getCheckoutRecordById(checkoutId);
        JLabel bookNameLabel = new JLabel("Book Name: "+checkoutRecord.getBook().getBookName());
        
        JLabel userNameLabel = new JLabel("User Name: " + checkoutRecord.getUser().getUserName());
        
        JLabel checkoutDateLabel = new JLabel("Checkout Date: "+ checkoutRecord.getCheckoutDate());
        
        JLabel expectedReturnDateLabel = new JLabel("Expected Return Date: "+checkoutRecord.getReturnDate());
        JButton returnButton = new JButton("Return");
        JButton cancelButton = new JButton("Cancel");

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              

                if (checkoutRecord != null) {
                	if(checkoutRecord.getActualReturnDate()==null) {
                		checkoutRecord.setActualReturnDate(LocalDate.now()); // Set actual return date to today's date

                        // Calculate the fine if the book is returned after the expected return date (14 days)
                        double fineAmount = calculateFine(checkoutRecord.getReturnDate(), LocalDate.now());
                        checkoutRecord.setFineAmount(fineAmount);

                        // Perform update to mark the book as returned and set fine
                        boolean updateSuccess = checkoutRecordService.updateCheckoutRecord(checkoutRecord);
                        if (updateSuccess) {
                            JOptionPane.showMessageDialog(null, "Book returned successfully with a fine of " + fineAmount + " rupees.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to return book.");
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
                returnBookFrame.dispose(); // Close the window on cancel
            }
        });

        returnBookFrame.add(bookNameLabel);
        returnBookFrame.add(userNameLabel);
        returnBookFrame.add(checkoutDateLabel);
        returnBookFrame.add(expectedReturnDateLabel);
        returnBookFrame.add(returnButton);
        returnBookFrame.add(cancelButton);

        returnBookFrame.pack();
        returnBookFrame.setLocationRelativeTo(null);
        returnBookFrame.setVisible(true);
    }

    // Method to calculate the fine based on return date and expected return date
    private double calculateFine(LocalDate expectedReturnDate, LocalDate actualReturnDate) {
        double fineAmount = 0;
        if (actualReturnDate.isAfter(expectedReturnDate)) {
            long daysOverdue = ChronoUnit.DAYS.between(expectedReturnDate, actualReturnDate);
            fineAmount = daysOverdue * 1.0; // Considering 1 rupee per day as fine
        }
        return fineAmount;
    }
    
    public static void main(String[] args) {
		
	}
}