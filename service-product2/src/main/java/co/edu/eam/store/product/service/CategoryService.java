package co.edu.eam.store.product.service;

import co.edu.eam.store.product.entity.Category;

import java.util.List;


public interface CategoryService {

    public Category createCategory(Category category);

    public List<Category> getListCategories();

    public Category deleteCategory(Long id);

    public Category updateCategory(Category category);

    public Category getCategoryById(Long id);
}
