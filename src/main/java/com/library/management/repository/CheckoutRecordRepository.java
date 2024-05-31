package com.library.management.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.library.management.exception.CheckoutRecordNotFoundException;
import com.library.management.model.CheckoutRecord;
import com.library.management.util.HibernateUtil;

public class CheckoutRecordRepository {

    public Long saveCheckoutRecord(CheckoutRecord checkoutRecord) {
        Session session = null;
        Long generatedId = 0L;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            // Save the checkout record entity
            session.save(checkoutRecord);

            // Get the generated ID after saving the entity
            generatedId = checkoutRecord.getId(); // Assuming CheckoutRecord has a getter for ID

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

    public CheckoutRecord findById(long checkoutRecordId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            CheckoutRecord checkoutRecord = session.get(CheckoutRecord.class, checkoutRecordId);
            if (checkoutRecord == null) {
                throw new CheckoutRecordNotFoundException(checkoutRecordId);
            }
            return checkoutRecord;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new CheckoutRecordNotFoundException(checkoutRecordId);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public boolean saveOrUpdateCheckoutRecord(CheckoutRecord checkoutRecord) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(checkoutRecord);
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

    public boolean deleteCheckoutRecord(long checkoutRecordId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            CheckoutRecord checkoutRecord = session.get(CheckoutRecord.class, checkoutRecordId);
            if (checkoutRecord != null) {
                session.delete(checkoutRecord);
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

    public List<CheckoutRecord> findAllCheckoutRecords() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<CheckoutRecord> checkoutRecords = session.createQuery("FROM CheckoutRecord", CheckoutRecord.class).list();
            session.getTransaction().commit();
            return checkoutRecords;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // Additional methods as needed for checkout record repository functionalities
    public List<CheckoutRecord> getCheckoutRecordsByUserId(int userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM CheckoutRecord cr WHERE cr.user.id = :userId";
            Query<CheckoutRecord> query = session.createQuery(hql, CheckoutRecord.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
