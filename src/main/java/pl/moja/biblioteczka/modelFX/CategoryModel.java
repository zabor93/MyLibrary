package pl.moja.biblioteczka.modelFX;

import pl.moja.biblioteczka.database.dao.CategoryDao;
import pl.moja.biblioteczka.database.dbUtils.HibernateUtil;
import pl.moja.biblioteczka.database.model.Category;

public class CategoryModel {


    public void saveCategoryInDataBase(String name) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setName(name);
        categoryDao.save(category);
        HibernateUtil.shutdown();
    }
}
