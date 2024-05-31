package com.library.management.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.library.management.view.admin.AdminLogin;
import com.library.management.view.user.UserLogin;

public class LoginScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LoginScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton userLoginButton = new JButton("User Login");
        JButton adminLoginButton = new JButton("Admin Login");

        userLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(rootPane, "User Login Clicked");
				new UserLogin();
			}
        	
        });
        adminLoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 new AdminLogin();
			}
        	
        });

        add(userLoginButton);
        add(adminLoginButton);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    
    public static void main(String[] args) {
		new LoginScreen();
	}
	//insert into checkoutrecords (checkoutdate, returndate, fineamount, userid, bookid) values ('2023-12-01','2023-12-14',0.0,3,4);
}
