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

public class EditAdminDetailsScreen extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JTextField adminIdField;
    private JButton searchButton;

    public EditAdminDetailsScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Edit Admin Details");
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
    	 final JFrame editDetailsFrame = new JFrame("Admin Details");
         editDetailsFrame.setLayout(new GridLayout(6,2));
         
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
         
         JButton saveButton = new JButton("Save");
         saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Admin a = new Admin(admin.getAdminId(), nameField.getText(), passwordField.getText(), numberField.getText(), addressField.getText());
				if(as.updateAdmin(a)) {					
					JOptionPane.showMessageDialog(editDetailsFrame, "Admin details updated successfully!");
				}else {
					JOptionPane.showMessageDialog(editDetailsFrame, "Admin details update failed!");
				}

			}
        	 
         });

         editDetailsFrame.add(new JLabel("Admin ID:"));
         editDetailsFrame.add(new JLabel(Integer.toString(admin.getAdminId())));
         editDetailsFrame.add(nameLabel);
         editDetailsFrame.add(nameField);
         editDetailsFrame.add(passwordLabel);
         editDetailsFrame.add(passwordField);
         editDetailsFrame.add(numberLabel);
         editDetailsFrame.add(numberField);
         editDetailsFrame.add(addressLabel);
         editDetailsFrame.add(addressField);
         //editDetailsFrame.add(new JLabel("")); // Placeholder
         editDetailsFrame.add(saveButton);

         editDetailsFrame.setSize(500, 300);
         
         editDetailsFrame.setLocationRelativeTo(null);
         editDetailsFrame.setVisible(true);
    }
}
