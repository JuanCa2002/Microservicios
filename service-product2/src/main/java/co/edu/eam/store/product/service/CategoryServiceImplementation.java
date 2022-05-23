package co.edu.eam.store.product.service;

import co.edu.eam.store.product.entity.Category;
import co.edu.eam.store.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Category createCategory(Category category) {
        category.setStatus("CREATED");
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getListCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Category deleteCategory(Long id) {
        Category categoryTemp= categoryRepository.findById(id).get();
        if(categoryTemp == null){
            return null;
        }
        categoryTemp.setStatus("DELETED");
        return categoryRepository.save(categoryTemp);
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryAuxiliar= categoryRepository.findById(category.getId()).get();
        if(categoryAuxiliar == null){
            return null;
        }
        categoryAuxiliar.setName(category.getName());
        return categoryRepository.save(categoryAuxiliar);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
