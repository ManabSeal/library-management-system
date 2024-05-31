package com.library.management.view.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.library.management.view.book.BookScreen;
import com.library.management.view.checkout.CheckoutRecordScreen;
import com.library.management.view.user.UserScreen;


public class ChooseOperation extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame chooseOperationFrame;
	
	public ChooseOperation() {
        initializeUI();
    }
	
	private void initializeUI() {
		chooseOperationFrame = new JFrame("Choose Operation");
		chooseOperationFrame.setLayout(new FlowLayout());

        JButton adminOperation = new JButton("Manage Admins");
        JButton userOperation = new JButton("Manage Users");
        JButton bookOperation = new JButton("Manage Books");
        JButton libraryOperation = new JButton("Manage Library");
        
        adminOperation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminScreen();
			}
        	
        });
        
        userOperation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UserScreen();
			}
        	
        });
        bookOperation.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
				new BookScreen();
			}
        	
        });
        
        libraryOperation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CheckoutRecordScreen();
			}
        	
        });

        chooseOperationFrame.add(adminOperation);
        chooseOperationFrame.add(userOperation);
        chooseOperationFrame.add(bookOperation);
        chooseOperationFrame.add(libraryOperation);
        

        chooseOperationFrame.pack();
        chooseOperationFrame.setLocationRelativeTo(null);

        chooseOperationFrame.setSize(300, 150);
        chooseOperationFrame.setLocationRelativeTo(null);
        chooseOperationFrame.setVisible(true);
    }
	public static void main(String[] args) {
		new ChooseOperation();
	}
}
