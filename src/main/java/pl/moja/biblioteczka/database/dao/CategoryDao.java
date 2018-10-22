package pl.moja.biblioteczka.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.moja.biblioteczka.database.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private Session session;
    private SessionFactory sessionFactory;


    GeneralDao generalDao = new GeneralDao();

    public void save(Category category) {
        generalDao.save(category);
    }


    public List<Category> getAllData() {
        return generalDao.getAllUsers();
    }
}