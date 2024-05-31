package com.library.management.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
        try {
            // Load properties from application.properties file
            Properties properties = new Properties();
            properties.load(HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties"));

            // Build Hibernate configuration
            Configuration configuration = new Configuration();
            configuration.setProperties(properties);

            // Add annotated classes (entities) to the configuration
            configuration.addAnnotatedClass(com.library.management.model.Book.class);
            configuration.addAnnotatedClass(com.library.management.model.User.class);
            configuration.addAnnotatedClass(com.library.management.model.Admin.class);
            configuration.addAnnotatedClass(com.library.management.model.CheckoutRecord.class);

            // Build the session factory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        getSessionFactory().close();
    }
}
