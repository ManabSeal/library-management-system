package com.library.management.view.book;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.library.management.model.Book;
import com.library.management.services.BookService;
import com.library.management.services.BookServiceImpl;

public class AddBookScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame addBookFrame;
    private static final BookService bookService = new BookServiceImpl();

    public AddBookScreen() {
        initializeUI();
    }

    private void initializeUI() {
        addBookFrame = new JFrame("Add Book");
        addBookFrame.setLayout(new GridLayout(3, 2));

        JLabel bookNameLabel = new JLabel("Book Name: ");
        final JTextField bookNameField = new JTextField(50);

        JLabel authorNameLabel = new JLabel("Author Name: ");
        final JTextField authorNameField = new JTextField(50);

        JButton addBookBtn = new JButton("Save");
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = bookNameField.getText();
                String authorName = authorNameField.getText();

                Book book = new Book(bookName, authorName);

                bookService.createBook(book);

                JOptionPane.showMessageDialog(addBookFrame, "Book added successfully!");
                addBookFrame.dispose();
            }
        });

        addBookFrame.add(bookNameLabel);
        addBookFrame.add(bookNameField);
        addBookFrame.add(authorNameLabel);
        addBookFrame.add(authorNameField);
        addBookFrame.add(addBookBtn);

        addBookFrame.setSize(500, 200);
        addBookFrame.setLocationRelativeTo(null);
        addBookFrame.setVisible(true);
    }
}

