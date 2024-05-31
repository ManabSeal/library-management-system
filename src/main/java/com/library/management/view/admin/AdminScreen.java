package com.library.management.view.admin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;

public class AdminScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JFrame adminScreenFrame;
	
	public AdminScreen() {
        initializeUI();
    }
	
	private void initializeUI() {
		adminScreenFrame = new JFrame("Admin");
		adminScreenFrame.setLayout(new FlowLayout());

        JButton addAdminButton = new JButton("Add Admin");
        JButton editAdminButton = new JButton("Edit Admin");
        JButton showAdminButton = new JButton("Show Admin");
        JButton deleteAdminButton = new JButton("Delete Admin");
        
        addAdminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddAdminScreen();
			}
        	
        });
        
        editAdminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new EditAdminDetailsScreen();
			}
        	
        });
        showAdminButton.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
				new ShowAdminScreen();
			}
        	
        });
        
        deleteAdminButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteAdminScreen();
			}
        	
        });

        adminScreenFrame.add(addAdminButton);
        adminScreenFrame.add(editAdminButton);
        adminScreenFrame.add(showAdminButton);
        adminScreenFrame.add(deleteAdminButton);
        

        adminScreenFrame.pack();
        adminScreenFrame.setLocationRelativeTo(null);

        adminScreenFrame.setSize(300, 150);
        adminScreenFrame.setLocationRelativeTo(null);
        adminScreenFrame.setVisible(true);
    }
}
