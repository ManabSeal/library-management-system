package com.library.management.view.user;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.library.management.model.CheckoutRecord;
import com.library.management.model.User;
import com.library.management.services.CheckoutRecordService;
import com.library.management.services.CheckoutRecordServiceImpl;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;

public class UserDetailsScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame userDetailsFrame;
    private final static CheckoutRecordService checkoutRecordService = new CheckoutRecordServiceImpl();
    private final static UserService userService = new UserServiceImpl();

    public UserDetailsScreen(int userId) {
        initializeUI(userId);
    }

    private void initializeUI(int userId) {
    	List<CheckoutRecord> userCheckoutRecords = checkoutRecordService.getCheckoutRecordsByUserId(userId);
        userDetailsFrame = new JFrame("User Details");
        userDetailsFrame.setLayout(new GridLayout(1, 2));

        // User Details Panel
        JPanel userDetailsPanel = new JPanel();
        userDetailsPanel.setLayout(new GridLayout(2, 1));

        User user = userService.getUserById(userId);

        JLabel userNameLabel = new JLabel("User Name: " + user.getUserName());
        double totalFine = 0.0;
        for(CheckoutRecord record: userCheckoutRecords) {
        	totalFine += record.getFineAmount();
        }
        JLabel totalFineLabel = new JLabel("Total Fine: " + totalFine);

        userDetailsPanel.add(userNameLabel);
        userDetailsPanel.add(totalFineLabel);

        // Checkout Records Panel
        JPanel checkoutRecordsPanel = new JPanel();
        

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Book Name");
        columnNames.add("Checkout Date");
        columnNames.add("Expected Return Date");
        columnNames.add("Fine");

        Vector<Vector<Object>> data = new Vector<>();
        for (CheckoutRecord record : userCheckoutRecords) {
            Vector<Object> row = new Vector<>();
            row.add(record.getBook().getBookName());
            row.add(record.getCheckoutDate().toString());
            row.add(record.getReturnDate().toString());
            row.add(record.getFineAmount());
            data.add(row);
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        JTable checkoutRecordsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(checkoutRecordsTable);

        checkoutRecordsPanel.add(scrollPane);

        userDetailsFrame.add(userDetailsPanel);
        userDetailsFrame.add(checkoutRecordsPanel);

        userDetailsFrame.pack();
        userDetailsFrame.setLocationRelativeTo(null);
        userDetailsFrame.setVisible(true);
    }
}