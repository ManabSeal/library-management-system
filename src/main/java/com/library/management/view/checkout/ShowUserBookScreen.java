package com.library.management.view.checkout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.library.management.model.CheckoutRecord;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import com.library.management.services.CheckoutRecordService;
import com.library.management.services.CheckoutRecordServiceImpl;
import com.library.management.services.BookService;
import com.library.management.services.BookServiceImpl;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
import com.library.management.util.ButtonEditor;
import com.library.management.util.ButtonRenderer;
public class ShowUserBookScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame showUserBooksFrame;
    private JTextField userIdField;

    private final static CheckoutRecordService checkoutRecordService = new CheckoutRecordServiceImpl();
    private final static UserService userService = new UserServiceImpl();
    public ShowUserBookScreen() {
        initializeUI();
    }

    private void initializeUI() {
        showUserBooksFrame = new JFrame("User's Books");
        showUserBooksFrame.setLayout(new FlowLayout());

        JLabel userIdLabel = new JLabel("Enter User ID:");
        userIdField = new JTextField(10);
        
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(userIdField.getText());
                    displayUserBooks(userId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid User ID.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserBooksFrame.dispose(); // Close the window on cancel
            }
        });

        showUserBooksFrame.add(userIdLabel);
        showUserBooksFrame.add(userIdField);
        showUserBooksFrame.add(submitButton);
        showUserBooksFrame.add(cancelButton);

        showUserBooksFrame.pack();
        showUserBooksFrame.setLocationRelativeTo(null);
        showUserBooksFrame.setVisible(true);
    }

    private void displayUserBooks(int userId) {
        List<CheckoutRecord> userCheckoutRecords = checkoutRecordService.getCheckoutRecordsByUserId(userId);
        double totalFine = 0.0;
       
        
        
        if (userCheckoutRecords.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books taken by this user.");
            showUserBooksFrame.dispose();
        } else {
            Vector<String> columnNames = new Vector<>();
            columnNames.add("Book Name");
            columnNames.add("Checkout Date");
            columnNames.add("Return Date");
            columnNames.add("Actual Return Date");
            columnNames.add("Fine");
            columnNames.add(""); // Empty column for Renew button
            columnNames.add(""); // Empty column for Return button

            Vector<Vector<Object>> data = new Vector<>();
            for (final CheckoutRecord record : userCheckoutRecords) {
            	totalFine+= record.getFineAmount();
                Vector<Object> row = new Vector<>();
                row.add(record.getBook().getBookName());
                row.add(record.getCheckoutDate().toString());
                row.add(record.getReturnDate().toString());
                if(record.getActualReturnDate()!= null) {
                	row.add(record.getActualReturnDate().toString());
                }else {
                	row.add("-");
                }
                
                row.add(record.getFineAmount());

                // Renew button

                row.add("Renew "+record.getId());
                
                row.add("Return "+record.getId());

                data.add(row);
            }
            JLabel userNameLabel = new JLabel("<html>Name: "+ userService.getUserById(userId).getUserName()+"<br>Total Fine: "+totalFine+"</html>");
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) ;

            JTable userBooksTable = new JTable(tableModel);
            userBooksTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            userBooksTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            userBooksTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());;
        	
        	//SET CUSTOM EDITOR TO TEAMS COLUMN
        	userBooksTable.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
        	
        	userBooksTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());;
         	
         	//SET CUSTOM EDITOR TO TEAMS COLUMN
         	userBooksTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));

            // Add the table to a scroll pane and display it
            JScrollPane scrollPane = new JScrollPane(userBooksTable);
            scrollPane.setPreferredSize(new Dimension(720, 450));
            showUserBooksFrame.add(scrollPane);
            showUserBooksFrame.add(userNameLabel);
            
            showUserBooksFrame.pack();
            showUserBooksFrame.setLocationRelativeTo(null);
            showUserBooksFrame.setVisible(true);
        }
    }
    public static void main(String[] args) {
		new ShowUserBookScreen();
	}
}