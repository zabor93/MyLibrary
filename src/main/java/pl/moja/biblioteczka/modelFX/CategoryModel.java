package pl.moja.biblioteczka.modelFX;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.moja.biblioteczka.database.dao.CategoryDao;
import pl.moja.biblioteczka.database.dbUtils.HibernateUtil;
import pl.moja.biblioteczka.database.model.Category;

import java.util.List;

public class CategoryModel {

    private ObservableList<CategoryFx> categoryList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFx> category = new SimpleObjectProperty<>();


    public void init() {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getAllData();
        categories.forEach(c -> {
            CategoryFx categoryfx = new CategoryFx();
            categoryfx.setId(c.getId());
            categoryfx.setName(c.getName());
            this.categoryList.add(categoryfx);
        });
        HibernateUtil.shutdown();
    }

    public ObservableList<CategoryFx> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ObservableList<CategoryFx> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryFx getCategory() {
        return category.get();
    }

    public ObjectProperty<CategoryFx> categoryProperty() {
        return category;
    }

    public void setCategory(CategoryFx category) {
        this.category.set(category);
    }

    public void saveCategoryInDataBase(String name) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setName(name);
        categoryDao.save(category);
        HibernateUtil.shutdown();
    }
}
