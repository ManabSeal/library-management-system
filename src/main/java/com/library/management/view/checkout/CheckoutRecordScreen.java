package com.library.management.view.checkout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CheckoutRecordScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame checkOutFrame;

    public CheckoutRecordScreen() {
        initializeUI();
    }

    private void initializeUI() {
        checkOutFrame = new JFrame("Checkout");
        checkOutFrame.setLayout(new FlowLayout());

        JButton issueBookButton = new JButton("Issue Book");
      
        JButton showUserBooksButton = new JButton("Show User's Books");

        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform issue book action
                // Example: new IssueBookScreen();
            	new IssueBookScreen();
            }
        });

       

        showUserBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action to show user's books count
                // Example: new UserBooksScreen();
                // This screen can display the number of books associated with the user
            	new ShowUserBookScreen();
            }
        });

        checkOutFrame.add(issueBookButton);

        checkOutFrame.add(showUserBooksButton);

        checkOutFrame.pack();
        checkOutFrame.setLocationRelativeTo(null);

        checkOutFrame.setSize(300, 200);
        checkOutFrame.setLocationRelativeTo(null);
        checkOutFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
		new CheckoutRecordScreen();
	}
}