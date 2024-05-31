package com.library.management.view.user;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.library.management.services.UserService;
import com.library.management.services.UserServiceImpl;
public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame userLoginFrame;
    public static UserService userService = new UserServiceImpl(); // Assuming you have a UserService interface and its implementation

    public UserLogin() {
        initializeUI();
    }

    private void initializeUI() {
        userLoginFrame = new JFrame("User Login");
        userLoginFrame.setLayout(new GridLayout(3, 2));

        JLabel userIdLabel = new JLabel("User ID: ");
        final JTextField userIdField = new JTextField(20);

        JLabel userPasswordLabel = new JLabel("Password: ");
        final JPasswordField userPasswordField = new JPasswordField(20);

        JButton userLoginBtn = new JButton("Login");
        userLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId = Integer.parseInt(userIdField.getText());
                String password = new String(userPasswordField.getPassword());

                if (userService.userAuth(userId, password)) {
                    JOptionPane.showMessageDialog(userLoginFrame, "User Login Successful");
                    new UserDetailsScreen(userId);
                    // Proceed with user-specific functionality or display user's dashboard
                    // Example: new UserDashboard(userId);
                } else {
                    JOptionPane.showMessageDialog(userLoginFrame, "ID/Password didn't match");
                }

                userLoginFrame.dispose();
            }
        });

        userLoginFrame.add(userIdLabel);
        userLoginFrame.add(userIdField);
        userLoginFrame.add(userPasswordLabel);
        userLoginFrame.add(userPasswordField);
        userLoginFrame.add(userLoginBtn);

        userLoginFrame.setSize(300, 150);
        userLoginFrame.setLocationRelativeTo(null);
        userLoginFrame.setVisible(true);
    }
}
