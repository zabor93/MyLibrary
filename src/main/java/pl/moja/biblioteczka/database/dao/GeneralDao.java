package pl.moja.biblioteczka.database.dao;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.moja.biblioteczka.database.dbUtils.HibernateUtil;
import pl.moja.biblioteczka.database.model.Category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GeneralDao {
private SessionFactory sessionFactory;

    public GeneralDao() {
        this.sessionFactory=HibernateUtil.getSessionFactory();
    }

//    public void save(Object object) {
//        sessionFactory.openSession().beginTransaction();
//
//        sessionFactory.openSession().save(o)
//        session.getTransaction().commit();
//
//    }

//    public void delete(Object object) {
//        session.beginTransaction();
//        session.delete(object);
//        session.getTransaction().commit();
//    }
//
//    public <T> Collection<T> list(Class<T> type) {
//        Collection<T> result = null;
//        session.createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//        return result;
//    }
//
//    public <T> T get(Class<T> type, Serializable id) {
//        return (T) session.get(type, id);
//    }



    public void save(Object user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

//    public void deleteUser(int userid) {
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            User user = (User) session.load(User.class, new Integer(userid));
//            session.delete(user);
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (trns != null) {
//                trns.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//    }

//    public void updateUser(User user) {
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            session.update(user);
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            if (trns != null) {
//                trns.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//    }
//
    public List<Category> getAllUsers() {
        List<Category> users = new ArrayList<Category>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Category ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
//
//    public User getUserById(int userid) {
//        User user = null;
//        Transaction trns = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            trns = session.beginTransaction();
//            String queryString = "from User where id = :id";
//            Query query = session.createQuery(queryString);
//            query.setInteger("id", userid);
//            user = (User) query.uniqueResult();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        } finally {
//            session.flush();
//            session.close();
//        }
//        return user;
//    }
//}
}
