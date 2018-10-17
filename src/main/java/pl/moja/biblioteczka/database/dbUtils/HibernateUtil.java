package pl.moja.biblioteczka.database.dbUtils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from Hibernate.cfg.xml
            return new AnnotationConfiguration().configure(
                    new File("C:\\Users\\Jakub\\Documents\\PROGRAMMING\\MojaBiblioteczka\\src\\main\\resources\\Hibernate.cfg.xml")).buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void initDatabase() {
         buildSessionFactory();
         shutdown();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}