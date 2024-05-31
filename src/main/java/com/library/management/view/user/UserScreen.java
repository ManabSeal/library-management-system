package com.library.management.view.user;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame userScreenFrame;

    public UserScreen() {
        initializeUI();
    }

    private void initializeUI() {
        userScreenFrame = new JFrame("Users");
        userScreenFrame.setLayout(new FlowLayout());

        JButton addUserButton = new JButton("Add User");
        JButton editUserButton = new JButton("Edit User");
        JButton showUserButton = new JButton("Show User");
        JButton deleteUserButton = new JButton("Delete User");

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserScreen();
            }
        });

        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditUserDetailsScreen();
            }
        });

        showUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowUserScreen();
            }
        });

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteUserScreen();
            }
        });

        userScreenFrame.add(addUserButton);
        userScreenFrame.add(editUserButton);
        userScreenFrame.add(showUserButton);
        userScreenFrame.add(deleteUserButton);

        userScreenFrame.pack();
        userScreenFrame.setLocationRelativeTo(null);
        userScreenFrame.setSize(300, 150);
        userScreenFrame.setVisible(true);
    }
}
