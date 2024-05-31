package com.library.management.view.book;
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

import com.library.management.model.Book;
import com.library.management.services.BookService;
import com.library.management.services.BookServiceImpl;
public class EditBookDetailsScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static BookService bookService = new BookServiceImpl();
    private JTextField bookIdField;
    private JButton searchButton;

    public EditBookDetailsScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Edit Book Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel mainPanel = new JPanel(new FlowLayout());
        bookIdField = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int bookId = Integer.parseInt(bookIdField.getText());
                Book book = bookService.getBookById(bookId);
                if (book != null) {
                    showBookDetails(book);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Book ID not found");
                }
            }

        });

        mainPanel.add(new JLabel("Book ID: "));
        mainPanel.add(bookIdField);
        mainPanel.add(searchButton);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showBookDetails(final Book book) {
        final JFrame editDetailsFrame = new JFrame("Book Details");
        editDetailsFrame.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Book Name:");
        final JTextField nameField = new JTextField(50);
        JLabel authorLabel = new JLabel("Author:");
        final JTextField authorField = new JTextField(50);

        nameField.setText(book.getBookName());
        authorField.setText(book.getAuthorName());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Book updatedBook = new Book(book.getId(), nameField.getText(), authorField.getText());
                if (bookService.updateBook(updatedBook)) {
                    JOptionPane.showMessageDialog(editDetailsFrame, "Book details updated successfully!");
                    editDetailsFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(editDetailsFrame, "Book details update failed!");
                }
            }

        });

        editDetailsFrame.add(new JLabel("Book ID:"));
        editDetailsFrame.add(new JLabel(Integer.toString(book.getId())));
        editDetailsFrame.add(nameLabel);
        editDetailsFrame.add(nameField);
        editDetailsFrame.add(authorLabel);
        editDetailsFrame.add(authorField);
        editDetailsFrame.add(saveButton);

        editDetailsFrame.setSize(500, 300);
        editDetailsFrame.setLocationRelativeTo(null);
        editDetailsFrame.setVisible(true);
    }
}
