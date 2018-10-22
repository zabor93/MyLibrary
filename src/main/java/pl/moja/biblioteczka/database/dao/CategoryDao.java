package pl.moja.biblioteczka.database.dao;

import org.hibernate.Session;
import pl.moja.biblioteczka.database.model.Category;

public class CategoryDao {

    private Session session;


    GeneralDao generalDao = new GeneralDao(session);

    public void save(Category category) {
        generalDao.save(category);
    }
}