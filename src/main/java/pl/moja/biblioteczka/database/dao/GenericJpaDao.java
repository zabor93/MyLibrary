package pl.moja.biblioteczka.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class GenericJpaDao<T,ID extends Serializable> implements GenericDao<T,ID> {

    private Class<T> persistenceClass;
    private EntityManager entityManager;

    public GenericJpaDao(Class<T> persistenceClass) {
        this.persistenceClass=persistenceClass;
    }

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        T mergedEntity = getEntityManager().merge(entity);
        return mergedEntity;
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }
}
