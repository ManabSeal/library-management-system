package com.library.management.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.library.management.view.checkout.RenewBookScreen;
import com.library.management.view.checkout.ReturnBookScreen;

public class ButtonEditor extends DefaultCellEditor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btn;
	 private String lbl;
	 private Boolean clicked;
	 
	 
	 public ButtonEditor(JTextField txt) {
		super(txt);
		
		btn=new JButton();
		btn.setOpaque(true);
		
		//WHEN BUTTON IS CLICKED
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fireEditingStopped();
			}
		});
		
	}
	 
	 //OVERRIDE A COUPLE OF METHODS
	 @Override
	public Component getTableCellEditorComponent(JTable table, Object obj,
			boolean selected, int row, int col) {

			//SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		 lbl=(obj==null) ? "":obj.toString();
		 btn.setText(lbl);
		 clicked=true;
		return btn;
	}
	 
	//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	 @Override
	public Object getCellEditorValue() {

		 if(clicked)
			{
			//SHOW US SOME MESSAGE
			 String[] str = lbl.split(" ");
				if(str[0].equals("Renew")) {
					new RenewBookScreen(Long.parseLong(str[1]));
				}else {
					new ReturnBookScreen(Long.parseLong(str[1]));
				}
			}
		//SET IT TO FALSE NOW THAT ITS CLICKED
		clicked=false;
	  return new String(lbl);
	}
	
	 @Override
	public boolean stopCellEditing() {

	       //SET CLICKED TO FALSE FIRST
			clicked=false;
		return super.stopCellEditing();
	}
	 
	 @Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
}
