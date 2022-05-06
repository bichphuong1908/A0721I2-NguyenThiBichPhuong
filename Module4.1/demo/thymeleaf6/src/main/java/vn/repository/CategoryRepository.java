package vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
