package com.library.management.view.checkout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.library.management.model.CheckoutRecord;
import com.library.management.services.CheckoutRecordService;
import com.library.management.services.CheckoutRecordServiceImpl;
import com.library.management.services.BookService;
import com.library.management.services.BookServiceImpl;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
public class IssueBookScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame issueBookFrame;
    private JTextField userIdField;
    private JTextField bookIdField;

    private static final CheckoutRecordService checkoutRecordService = new CheckoutRecordServiceImpl();
    private static final BookService bookService = new BookServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    public IssueBookScreen() {
        initializeUI();
    }

    private void initializeUI() {
        issueBookFrame = new JFrame("Issue Book");
        issueBookFrame.setLayout(new GridLayout(4, 2));

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField();

        JButton issueButton = new JButton("Issue");
        JButton cancelButton = new JButton("Cancel");

        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get User ID and Book ID from text fields
                int userId = Integer.parseInt(userIdField.getText());
                int bookId = Integer.parseInt(bookIdField.getText());

                // Create a new CheckoutRecord object
                CheckoutRecord checkoutRecord = new CheckoutRecord();
                checkoutRecord.setCheckoutDate(LocalDate.now()); // Set checkout date to today's date
                checkoutRecord.setReturnDate(LocalDate.now().plusDays(14));
                // Fetch User and Book objects using the provided IDs and set them in the CheckoutRecord
                checkoutRecord.setUser(userService.getUserById(userId));
                checkoutRecord.setBook(bookService.getBookById(bookId));

                // Issue the book by creating a checkout record
                long checkoutRecordId = checkoutRecordService.createCheckoutRecord(checkoutRecord);
                if (checkoutRecordId != 0) {
                    JOptionPane.showMessageDialog(null, "Book issued successfully with Checkout Record ID: " + checkoutRecordId);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to issue book.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueBookFrame.dispose(); // Close the window on cancel
            }
        });

        issueBookFrame.add(userIdLabel);
        issueBookFrame.add(userIdField);
        issueBookFrame.add(bookIdLabel);
        issueBookFrame.add(bookIdField);
        issueBookFrame.add(issueButton);
        issueBookFrame.add(cancelButton);

        issueBookFrame.pack();
        issueBookFrame.setLocationRelativeTo(null);
        issueBookFrame.setVisible(true);
    }
    public static void main(String[] args) {
		new IssueBookScreen();
	}
}
