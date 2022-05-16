package rifqimuhammadaziz.springrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapi.model.entity.Product;
import rifqimuhammadaziz.springrestapi.model.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired // Dependency Injection
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        // Simple Validate
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepository.findProductsByName(name);
    }
}
