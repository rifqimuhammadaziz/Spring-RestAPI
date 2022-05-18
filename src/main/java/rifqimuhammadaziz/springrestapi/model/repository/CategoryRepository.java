package rifqimuhammadaziz.springrestapi.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springrestapi.model.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    Page<Category> findByNameContains(String name, Pageable pageable);
}
