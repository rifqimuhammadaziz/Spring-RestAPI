package rifqimuhammadaziz.springrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapi.model.entity.Product;
import rifqimuhammadaziz.springrestapi.model.entity.Supplier;
import rifqimuhammadaziz.springrestapi.model.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired // Dependency Injection
    private ProductRepository productRepository;

    @Autowired
    private SupplierService supplierService;

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

    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findProductsByNameLike("%"+name+"%");
    }

    public List<Product> findProductsByCategory(Long categoryId) {
        return productRepository.findProductByCategory(categoryId);
    }

    public List<Product> findProductsBySupplier(Long supplierId) {
        Supplier supplier = supplierService.findById(supplierId);
        if (supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepository.findProductBySupplier(supplier);
    }

    public void addSupplier(Supplier supplier, Long productId) {
        Product product = findById(productId);
        if (product == null) {
            throw new RuntimeException("Product with id: " +productId+ "not found.");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }
}
