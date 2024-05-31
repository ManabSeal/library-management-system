package com.library.management.view.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BookScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame bookScreenFrame;

    public BookScreen() {
        initializeUI();
    }

    private void initializeUI() {
        bookScreenFrame = new JFrame("Books");
        bookScreenFrame.setLayout(new FlowLayout());

        JButton addBookButton = new JButton("Add Book");
        JButton editBookButton = new JButton("Edit Book");
        JButton showBookButton = new JButton("Show Book");
        JButton deleteBookButton = new JButton("Delete Book");

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookScreen();
            }
        });

        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditBookDetailsScreen();
            }
        });

        showBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowBookScreen();
            }
        });

        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteBookScreen();
            }
        });

        bookScreenFrame.add(addBookButton);
        bookScreenFrame.add(editBookButton);
        bookScreenFrame.add(showBookButton);
        bookScreenFrame.add(deleteBookButton);

        bookScreenFrame.pack();
        bookScreenFrame.setLocationRelativeTo(null);
        bookScreenFrame.setSize(300, 150);
        bookScreenFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
		new BookScreen();
	}
}
