package rifqimuhammadaziz.springrestapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springrestapi.model.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
