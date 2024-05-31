package com.library.management.view.book;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.library.management.model.Book;
import com.library.management.services.BookService;
import com.library.management.services.BookServiceImpl;
public class ShowBookScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static BookService bookService = new BookServiceImpl();
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public ShowBookScreen() {
        initializeUI();
        populateBookData(); // Populate table with example data
    }

    private void initializeUI() {
        setTitle("Book Details"); // Set the title directly to ShowBookScreen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tableModel = new DefaultTableModel();
        bookTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateBookData() {
        // Sample data to populate the table
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();
        for (Book book : bookService.getAllBooks()) {
            Vector<String> row = new Vector<>();
            row.add(Integer.toString(book.getId()));
            row.add(book.getBookName());
            row.add(book.getAuthorName());
            data.add(row);
        }

        // Set column names and data to the table model
        tableModel.setDataVector(data, columnNames);
    }

    public static void main(String[] args) {
        new ShowBookScreen();
    }
}
