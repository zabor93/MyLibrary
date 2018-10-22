package pl.moja.biblioteczka.database.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.moja.biblioteczka.database.dbUtils.HibernateUtil;

import java.io.Serializable;
import java.util.Collection;

public class GeneralDao {

    private Session session;

    public GeneralDao(Session session) {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void save(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();

    }

    public void delete(Object object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    public <T> Collection<T> list(Class<T> type) {
        Collection<T> result = null;
        session.createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return result;
    }

    public <T> T get(Class<T> type, Serializable id) {
        return (T) session.get(type, id);
    }
}
