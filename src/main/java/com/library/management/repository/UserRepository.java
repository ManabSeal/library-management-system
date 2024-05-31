package com.library.management.repository;

import java.util.List;

import org.hibernate.Session;

import com.library.management.exception.UserNotFoundException;
import com.library.management.model.User;
import com.library.management.util.HibernateUtil;

public class UserRepository {

    public int saveUser(User user) {
        Session session = null;
        int generatedId = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Save the user entity
            session.save(user);

            // Get the generated ID after saving the entity
            generatedId = user.getUserId(); // Assuming User has a getter for userId

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

    public User findById(int userId){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            User user = session.get(User.class, userId);
            if (user == null) {
                throw new UserNotFoundException(userId);
            }
            return user;
        } catch (Exception e) {
            
            throw new UserNotFoundException(userId);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean saveOrUpdateUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
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

    public boolean deleteUser(int userId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
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

    public List<User> findAllUsers() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User", User.class).list();
            session.getTransaction().commit();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    public boolean checkUserAuth(int userId, String password) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            User user = session.get(User.class, userId);
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return false;
    }
}
