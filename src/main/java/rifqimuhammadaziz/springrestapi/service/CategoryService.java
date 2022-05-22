package rifqimuhammadaziz.springrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapi.model.entity.Category;
import rifqimuhammadaziz.springrestapi.model.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {
        if (category.getId() != null) { // Update
            Category currentCategory = categoryRepository.findById(category.getId()).get(); // Get category by id
            currentCategory.setName(category.getName()); // Update name
            category = currentCategory; // Save
        }
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Iterable<Category> findByName(String name, Pageable pageable) {
        return categoryRepository.findByNameContains(name, pageable);
    }

    public Iterable<Category> saveBatch(Iterable<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}
