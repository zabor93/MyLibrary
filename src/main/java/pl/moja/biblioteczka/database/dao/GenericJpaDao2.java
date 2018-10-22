package pl.moja.biblioteczka.database.dao;

import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class GenericJpaDao2<T extends Serializable> {

    private Class<T> clazz;

    SessionFactory sessionFactory;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return (T)sessionFactory.getCurrentSession().get( clazz, id );
    }
    public void create(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}



