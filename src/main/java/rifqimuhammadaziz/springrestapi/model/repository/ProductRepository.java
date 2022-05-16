package rifqimuhammadaziz.springrestapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springrestapi.model.entity.Product;

import java.util.List;

/*
    CrudRepository<Object, PrimaryKey TypeData>
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    // Add Custom Function
    List<Product> findProductsByName(String name);
}
