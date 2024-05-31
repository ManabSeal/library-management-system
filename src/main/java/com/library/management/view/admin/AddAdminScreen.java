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

import com.library.management.model.Admin;
import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;

public class AddAdminScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JFrame addAdminFrame;

    public AddAdminScreen() {
        initializeUI();
    }

    private void initializeUI() {
    	addAdminFrame = new JFrame("Create Admin");
    	addAdminFrame.setLayout(new GridLayout(5, 2));

        JLabel adminNameLabel = new JLabel("Admin Name: ");
        final JTextField adminNameField = new JTextField(50);

        JLabel adminPasswordLabel = new JLabel("Password: ");
        final JPasswordField adminPasswordField = new JPasswordField(8);
        
        JLabel adminNumberLabel = new JLabel("Number: ");
        final JTextField adminNumberField = new JTextField(15);
        
        JLabel adminAddressLabel = new JLabel("Address: ");
        final JTextField adminAddressField = new JTextField(80);

        JButton addAdminBtn = new JButton("Save");
        addAdminBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = adminNameField.getText();
	            String password = new String(adminPasswordField.getPassword());
				String number = adminNumberField.getText();
				String address = adminAddressField.getText();

	            Admin admin = new Admin(name, password, number, address);
	            
	            JOptionPane.showMessageDialog(addAdminFrame, "The assigned ID is " + as.createAdmin(admin));
	            
	            addAdminFrame.dispose(); 
			}
        	
        });

        addAdminFrame.add(adminNameLabel);
        addAdminFrame.add(adminNameField);
        addAdminFrame.add(adminPasswordLabel);
        addAdminFrame.add(adminPasswordField);
        addAdminFrame.add(adminNumberLabel);
        addAdminFrame.add(adminNumberField);
        addAdminFrame.add(adminAddressLabel);
        addAdminFrame.add(adminAddressField);
        addAdminFrame.add(addAdminBtn);

        addAdminFrame.setSize(500, 300);
        addAdminFrame.setLocationRelativeTo(null);
        addAdminFrame.setVisible(true);
    }
}
