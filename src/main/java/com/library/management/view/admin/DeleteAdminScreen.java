package com.library.management.view.admin;

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

import com.library.management.model.Admin;
import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;

public class DeleteAdminScreen extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JTextField adminIdField;
    private JButton searchButton;

    public DeleteAdminScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Delete Admin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel mainPanel = new JPanel(new FlowLayout());
        adminIdField = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int adminId = Integer.parseInt(adminIdField.getText());
				Admin admin = as.getAdminById(adminId);
				if(admin != null) {
					showAdminDetails(admin);
				}else {
					JOptionPane.showMessageDialog(mainPanel, "Admin ID not found");
				}
	            
			}
        	
        });

        mainPanel.add(new JLabel("Admin ID: "));
        mainPanel.add(adminIdField);
        mainPanel.add(searchButton);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showAdminDetails(final Admin admin) {
    	 final JFrame deleteAdminFrame = new JFrame("Admin Details");
    	 deleteAdminFrame.setLayout(new GridLayout(6,2));
         
         JLabel nameLabel = new JLabel("Name:");
         final JTextField nameField = new JTextField(50);
         JLabel passwordLabel = new JLabel("Password:");
         final JTextField passwordField = new JTextField(8);
         JLabel numberLabel = new JLabel("Phone Number: ");
         final JTextField numberField = new JTextField(15);
         JLabel addressLabel = new JLabel("Address");
         final JTextField addressField = new JTextField(80);
         
         nameField.setText(admin.getAdminName());
         passwordField.setText(admin.getPassword());
         numberField.setText(admin.getPhoneNumber());
         addressField.setText(admin.getAddress());
         
         JButton deleteButton = new JButton("Delete");
         deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(as.deleteAdmin(admin.getAdminId())) {					
					JOptionPane.showMessageDialog(deleteAdminFrame, "Admin deleted successfully!");
					deleteAdminFrame.dispose();
				}else {
					JOptionPane.showMessageDialog(deleteAdminFrame, "Admin deletion failed!");
				}

			}
        	 
         });

         deleteAdminFrame.add(new JLabel("Admin ID:"));
         deleteAdminFrame.add(new JLabel(Integer.toString(admin.getAdminId())));
         deleteAdminFrame.add(nameLabel);
         deleteAdminFrame.add(nameField);
         deleteAdminFrame.add(passwordLabel);
         deleteAdminFrame.add(passwordField);
         deleteAdminFrame.add(numberLabel);
         deleteAdminFrame.add(numberField);
         deleteAdminFrame.add(addressLabel);
         deleteAdminFrame.add(addressField);
         //editDetailsFrame.add(new JLabel("")); // Placeholder
         deleteAdminFrame.add(deleteButton);

         deleteAdminFrame.setSize(500, 300);
         
         deleteAdminFrame.setLocationRelativeTo(null);
         deleteAdminFrame.setVisible(true);
    }
}

