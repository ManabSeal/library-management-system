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
public class DeleteBookScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    public static BookService bookService = new BookServiceImpl();
    private JTextField bookIdField;
    private JButton searchButton;

    public DeleteBookScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Delete Book");
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
        final JFrame deleteBookFrame = new JFrame("Book Details");
        deleteBookFrame.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Book Name:");
        final JTextField nameField = new JTextField(50);
        JLabel authorLabel = new JLabel("Author:");
        final JTextField authorField = new JTextField(50);

        nameField.setText(book.getBookName());
        authorField.setText(book.getAuthorName());

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (bookService.deleteBook(book.getId())) {
                    JOptionPane.showMessageDialog(deleteBookFrame, "Book deleted successfully!");
                    deleteBookFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(deleteBookFrame, "Book deletion failed!");
                }

            }
        });

        deleteBookFrame.add(new JLabel("Book ID:"));
        deleteBookFrame.add(new JLabel(Integer.toString(book.getId())));
        deleteBookFrame.add(nameLabel);
        deleteBookFrame.add(nameField);
        deleteBookFrame.add(authorLabel);
        deleteBookFrame.add(authorField);
        deleteBookFrame.add(deleteButton);

        deleteBookFrame.setSize(500, 300);
        deleteBookFrame.setLocationRelativeTo(null);
        deleteBookFrame.setVisible(true);
    }
}