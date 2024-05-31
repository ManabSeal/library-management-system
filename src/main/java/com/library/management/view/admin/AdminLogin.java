package com.library.management.view.admin;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;

public class AdminLogin extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JFrame adminLoginFrame;

    public AdminLogin() {
        initializeUI();
    }

    private void initializeUI() {
    	adminLoginFrame = new JFrame("Admin Login");
        adminLoginFrame.setLayout(new GridLayout(3, 2));

        JLabel adminIdLabel = new JLabel("Admin ID: ");
        final JTextField adminIdField = new JTextField(20);

        JLabel adminPasswordLabel = new JLabel("Password: ");
        final JPasswordField adminPasswordField = new JPasswordField(20);

        JButton adminLoginBtn = new JButton("Login");
        adminLoginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int adminId = Integer.parseInt(adminIdField.getText());
	            String password = new String(adminPasswordField.getPassword());
	            if(as.adminAuth(adminId, password)) {
	            	JOptionPane.showMessageDialog(adminLoginFrame, "Admin Login Successful");
	            	new ChooseOperation();
	            }else {
	            	JOptionPane.showMessageDialog(adminLoginFrame, "ID/Password didn't match");
	            }
	            
	            adminLoginFrame.dispose(); 
			}
        	
        });

        adminLoginFrame.add(adminIdLabel);
        adminLoginFrame.add(adminIdField);
        adminLoginFrame.add(adminPasswordLabel);
        adminLoginFrame.add(adminPasswordField);
        adminLoginFrame.add(adminLoginBtn);

        adminLoginFrame.setSize(300, 150);
        adminLoginFrame.setLocationRelativeTo(null);
        adminLoginFrame.setVisible(true);
    }

    
}
