package com.library.management.view.admin;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.library.management.model.Admin;
import com.library.management.services.AdminService;
import com.library.management.services.AdminServiceImpl;

public class ShowAdminScreen extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AdminService as = new AdminServiceImpl();
	private JTable adminTable;
    private DefaultTableModel tableModel;

    public ShowAdminScreen() {
        initializeUI();
        populateAdminData(); // Populate table with example data
    }

    private void initializeUI() {
    	setTitle("Admin Details"); // Set the title directly to ShowAdminScreen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel();
        adminTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(adminTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateAdminData() {
        // Sample data to populate the table
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Phone Number");
        columnNames.add("Address");

        Vector<Vector<String>> data = new Vector<>();
        for(Admin a: as.getAllAdmins()) {
        	Vector<String> row = new Vector<>();
        	row.add(Integer.toString(a.getAdminId()));
        	row.add(a.getAdminName());
        	row.add(a.getPhoneNumber());
        	row.add(a.getAddress());
        	data.add(row);
        }

        // Set column names and data to the table model
        tableModel.setDataVector(data, columnNames);
    }
    public static void main(String[] args) {
		new ShowAdminScreen();
	}
}
