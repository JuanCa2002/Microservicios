package co.edu.eam.store.product.controller;

import co.edu.eam.store.product.entity.Category;
import co.edu.eam.store.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> register(@RequestBody Category category){
        Category createdCategory= categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> list(){
        List<Category> categories= categoryService.getListCategories();
        if(categories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        Category categoryAuxiliar= categoryService.getCategoryById(id);
        if(categoryAuxiliar == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryAuxiliar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        Category categoryAuxiliar= categoryService.deleteCategory(id);
        if(categoryAuxiliar == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryAuxiliar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
        category.setId(id);
        Category updatedCategory= categoryService.updateCategory(category);
        if (category == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategory);
    }
}
