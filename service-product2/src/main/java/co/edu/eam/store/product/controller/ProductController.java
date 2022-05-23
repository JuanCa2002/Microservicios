package co.edu.eam.store.product.controller;

import co.edu.eam.store.product.entity.Category;
import co.edu.eam.store.product.entity.Product;
import co.edu.eam.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> list(@RequestParam(name="categoryId", required = false) Long categoryId){
          List<Product> products= new ArrayList<>();
          if(categoryId == null){
              products= productService.ListAllProducts();
          }
          else{
              products= productService.findByCategory(Category.builder().id(categoryId).build());
          }
          if(products.isEmpty()){
              return ResponseEntity.noContent().build();
          }

          return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product product= productService.getProduct(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> register(@RequestBody Product product){
        //TODOS: completar con validaciones de los estudiantes xd
        Product createdProduct= productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product product){
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        if(updatedProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id){
        Product deletedProduct= productService.deleteProduct(id);
        if(deletedProduct == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedProduct);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable("id") Long id, @RequestParam(value = "quantity", required = true) Double quantity){
       Product product = productService.updateStock(id,quantity);
       if(product == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(product);
    }
}

