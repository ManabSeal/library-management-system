package com.library.management.view.user;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.library.management.model.User;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
public class DeleteUserScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static UserService userService = new UserServiceImpl();
    private JTextField userIdField;
    private JButton searchButton;

    public DeleteUserScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Delete User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel mainPanel = new JPanel(new FlowLayout());
        userIdField = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int userId = Integer.parseInt(userIdField.getText());
                User user = userService.getUserById(userId);
                if (user != null) {
                    showUserDetails(user);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "User ID not found");
                }
            }

        });

        mainPanel.add(new JLabel("User ID: "));
        mainPanel.add(userIdField);
        mainPanel.add(searchButton);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showUserDetails(final User user) {
        final JFrame deleteUserFrame = new JFrame("User Details");
        deleteUserFrame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("User Name:");
        final JTextField nameField = new JTextField(50);
        JLabel passwordLabel = new JLabel("User Password:");
        final JTextField passwordField = new JTextField(8);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        final JTextField phoneNumberField = new JTextField(50);
        JLabel addressLabel = new JLabel("Address:");
        final JTextField addressField = new JTextField(50);

        nameField.setText(user.getUserName());
        passwordField.setText(user.getPassword());
        phoneNumberField.setText(user.getPhoneNumber());
        addressField.setText(user.getAddress());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (userService.deleteUser(user.getUserId())) {
                    JOptionPane.showMessageDialog(deleteUserFrame, "User deleted successfully!");
                    deleteUserFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(deleteUserFrame, "User deletion failed!");
                }
            }
        });

        deleteUserFrame.add(new JLabel("User ID:"));
        deleteUserFrame.add(new JLabel(Integer.toString(user.getUserId())));
        deleteUserFrame.add(nameLabel);
        deleteUserFrame.add(nameField);
        deleteUserFrame.add(passwordLabel);
        deleteUserFrame.add(passwordField);
        deleteUserFrame.add(phoneNumberLabel);
        deleteUserFrame.add(phoneNumberField);
        deleteUserFrame.add(addressLabel);
        deleteUserFrame.add(addressField);
        deleteUserFrame.add(deleteButton);

        deleteUserFrame.setSize(500, 300);
        deleteUserFrame.setLocationRelativeTo(null);
        deleteUserFrame.setVisible(true);
    }
}