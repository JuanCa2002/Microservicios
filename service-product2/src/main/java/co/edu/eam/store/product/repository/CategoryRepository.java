package co.edu.eam.store.product.repository;

import co.edu.eam.store.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
