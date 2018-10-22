package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.moja.biblioteczka.modelFX.CategoryFx;
import pl.moja.biblioteczka.modelFX.CategoryModel;

public class CategoryController {

    @FXML
    private TextField categoryTextField;

    @FXML
    private Button addCategoryButton;

    @FXML
    private Button removeCategoryButton;

    @FXML
    private ComboBox<CategoryFx> categoryComboBox;

    private CategoryModel categoryModel;

    @FXML
    public void initialize(){
        this.categoryModel = new CategoryModel();
        this.categoryModel.init();
        this.categoryComboBox.setItems(this.categoryModel.getCategoryList());
        initBindings();
    }

    private void initBindings(){
        addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
    }

    public void addCategoryOnAction() {
        categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        categoryTextField.clear();
    }

    public void DeleteCategoryButton( ) {
    }

    public void onActionDeleteButton() {

    }
}
