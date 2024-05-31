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
public class EditUserDetailsScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static UserService userService = new UserServiceImpl();
    private JTextField userIdField;
    private JButton searchButton;

    public EditUserDetailsScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Edit User Details");
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
        final JFrame editDetailsFrame = new JFrame("User Details");
        editDetailsFrame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("User Name:");
        final JTextField nameField = new JTextField(50);
        JLabel passwordLabel = new JLabel("Password:");
        final JTextField passwordField = new JTextField(50);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        final JTextField phoneNumberField = new JTextField(15);
        JLabel addressLabel = new JLabel("Address:");
        final JTextField addressField = new JTextField(80);

        nameField.setText(user.getUserName());
        passwordField.setText(user.getPassword());
        phoneNumberField.setText(user.getPhoneNumber());
        addressField.setText(user.getAddress());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                User updatedUser = new User(user.getUserId(),
                        nameField.getText(),
                        passwordField.getText(),
                        phoneNumberField.getText(),
                        addressField.getText());

                if (userService.updateUser(updatedUser)) {
                    JOptionPane.showMessageDialog(editDetailsFrame, "User details updated successfully!");
                    editDetailsFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(editDetailsFrame, "User details update failed!");
                }
            }

        });

        editDetailsFrame.add(new JLabel("User ID:"));
        editDetailsFrame.add(new JLabel(Integer.toString(user.getUserId())));
        editDetailsFrame.add(nameLabel);
        editDetailsFrame.add(nameField);
        editDetailsFrame.add(passwordLabel);
        editDetailsFrame.add(passwordField);
        editDetailsFrame.add(phoneNumberLabel);
        editDetailsFrame.add(phoneNumberField);
        editDetailsFrame.add(addressLabel);
        editDetailsFrame.add(addressField);
        editDetailsFrame.add(saveButton);

        editDetailsFrame.setSize(500, 300);
        editDetailsFrame.setLocationRelativeTo(null);
        editDetailsFrame.setVisible(true);
    }
}
