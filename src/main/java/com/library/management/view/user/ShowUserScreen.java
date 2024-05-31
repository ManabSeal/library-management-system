package com.library.management.view.user;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.library.management.model.User;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
public class ShowUserScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static UserService userService = new UserServiceImpl();
    private JTable userTable;
    private DefaultTableModel tableModel;

    public ShowUserScreen() {
        initializeUI();
        populateUserData(); // Populate table with example data
    }

    private void initializeUI() {
        setTitle("User Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel();
        userTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateUserData() {
        // Sample data to populate the table
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Phone Number");
        columnNames.add("Address");

        Vector<Vector<String>> data = new Vector<>();
       
        for (User user : userService.getAllUsers()) {
            Vector<String> row = new Vector<>();
            row.add(Integer.toString(user.getUserId()));
            row.add(user.getUserName());
            row.add(user.getPhoneNumber());
            row.add(user.getAddress());
            data.add(row);
        }

        // Set column names and data to the table model
        tableModel.setDataVector(data, columnNames);
    }

    public static void main(String[] args) {
        new ShowUserScreen();
    }
}