package mydata.mydata.domain.categories.repository;

import mydata.mydata.domain.categories.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
