package pl.moja.biblioteczka.database.dao;


import java.io.Serializable;
import java.util.List;


public interface GenericDao<T, ID extends Serializable> {

    T save(T entity);

    T update(T entity);

    void flush();

    T edit(T entity);


}
