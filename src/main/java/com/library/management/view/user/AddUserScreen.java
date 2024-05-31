package com.library.management.view.user;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.library.management.model.User;
import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
public class AddUserScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame addUserFrame;
    private static final UserService userService = new UserServiceImpl();

    public AddUserScreen() {
        initializeUI();
    }

    private void initializeUI() {
        addUserFrame = new JFrame("Add User");
        addUserFrame.setLayout(new GridLayout(5, 2));

        JLabel userNameLabel = new JLabel("User Name: ");
        final JTextField userNameField = new JTextField(50);

        JLabel passwordLabel = new JLabel("Password: ");
        final JTextField passwordField = new JTextField(50);

        JLabel phoneNumberLabel = new JLabel("Phone Number: ");
        final JTextField phoneNumberField = new JTextField(15);

        JLabel addressLabel = new JLabel("Address: ");
        final JTextField addressField = new JTextField(80);

        JButton addUserBtn = new JButton("Save");
        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText();
                String password = passwordField.getText();
                String phoneNumber = phoneNumberField.getText();
                String address = addressField.getText();

                User user = new User(userName, password, phoneNumber, address);

                userService.createUser(user);

                JOptionPane.showMessageDialog(addUserFrame, "User added successfully!");
                addUserFrame.dispose();
            }
        });

        addUserFrame.add(userNameLabel);
        addUserFrame.add(userNameField);
        addUserFrame.add(passwordLabel);
        addUserFrame.add(passwordField);
        addUserFrame.add(phoneNumberLabel);
        addUserFrame.add(phoneNumberField);
        addUserFrame.add(addressLabel);
        addUserFrame.add(addressField);
        addUserFrame.add(addUserBtn);

        addUserFrame.setSize(500, 250);
        addUserFrame.setLocationRelativeTo(null);
        addUserFrame.setVisible(true);
    }
}