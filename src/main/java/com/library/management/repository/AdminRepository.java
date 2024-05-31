package com.library.management.repository;

import java.util.List;

import org.hibernate.Session;

import com.library.management.exception.AdminNotFoundException;
import com.library.management.model.Admin;
import com.library.management.util.HibernateUtil;

public class AdminRepository {
	
	 public int saveAdmin(Admin admin) {
			Session session = null;
	        int generatedId = 0;
	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            session.beginTransaction();

	            // Save the admin entity
	            session.save(admin);

	            // Get the generated ID after saving the entity
	            generatedId = admin.getAdminId(); // Assuming Admin has a getter for adminId

	            session.getTransaction().commit();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	        	session.close();
	        }
	        return generatedId;
	    }
//	public Admin findById(int adminId) {
//		Session session = null;
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			Admin admin = session.get(Admin.class, adminId);
//			return admin;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		return null;
//	}
	 
	 public Admin findById(int adminId) {
		 Session session = null;
		 try {
			 session = HibernateUtil.getSessionFactory().openSession();
		     Admin admin = session.get(Admin.class, adminId);
		     if (admin == null) {
		    	 throw new AdminNotFoundException(adminId);
		     }
		     return admin;
		 } catch (Exception e) {
		     //e.printStackTrace(); // Log or handle the exception as needed
		     throw new RuntimeException("Error finding admin by ID: " + adminId, e);
		 } finally {
		     if (session != null && session.isOpen()) {
		    	 session.close();
		     }
		 }
	 }
	
	public boolean saveOrUpdateAdmin(Admin admin) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
	        session.saveOrUpdate(admin);
	        session.getTransaction().commit();
	        return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}   
    }
	
	public boolean deleteAdmin(int adminId) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
	        Admin admin = session.get(Admin.class, adminId);
	        if (admin != null) {
	            session.delete(admin);
	        }
	        session.getTransaction().commit();
	        return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}   
    }
	
	public List<Admin> findAllAdmin(){
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
            List<Admin> admins = session.createQuery("FROM Admin", Admin.class).list();
	        session.getTransaction().commit();
	        return admins;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}   
	}
	public boolean checkAuth(int adminId, String password) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Admin admin = session.get(Admin.class, adminId);
			if(admin != null && admin.getPassword().equals(password)) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}
}
