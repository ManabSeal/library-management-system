package com.library.management.repository;

import java.util.List;
import org.hibernate.Session;

import com.library.management.exception.BookNotFoundException;
import com.library.management.model.Book;
import com.library.management.util.HibernateUtil;

public class BookRepository {

    public int saveBook(Book book) {
        Session session = null;
        int generatedId = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Save the book entity
            session.save(book);

            // Get the generated ID after saving the entity
            generatedId = book.getId(); // Assuming Book has a getter for ID

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return generatedId;
    }

    public Book findById(int bookId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Book book = session.get(Book.class, bookId);
            if (book == null) {
                throw new BookNotFoundException(bookId);
            }
            return book;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new BookNotFoundException(bookId);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean saveOrUpdateBook(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean deleteBook(int bookId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                session.delete(book);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Book> findAllBooks() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Book> books = session.createQuery("FROM Book", Book.class).list();
            session.getTransaction().commit();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
   
}
