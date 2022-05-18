package rifqimuhammadaziz.springrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapi.model.entity.Product;
import rifqimuhammadaziz.springrestapi.model.entity.Supplier;
import rifqimuhammadaziz.springrestapi.model.repository.SupplierRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier findById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (!supplier.isPresent()) {
            return null;
        }
        return supplier.get();
    }

    public Iterable<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier findByEmail(String email) {
        return supplierRepository.findByEmail(email);
    }

    public Supplier findByNameSingle(String name) {
        return supplierRepository.findByName(name);
    }

    public List<Supplier> findSupplierByNameContaining(String name) {
        return supplierRepository.findSupplierByNameContaining("%"+name+"%");
    }

    public List<Supplier> findByNameStartWith(String prefix) {
        return supplierRepository.findByNameStartingWith(prefix);
    }

    public List<Supplier> findByNameOrEmail(String name, String email) {
        return supplierRepository.findByNameContainsOrEmailContains(name, email);
    }

    // TEST
    public Supplier findSupplierByName(String name) {
        return supplierRepository.findSupplierByName(name);
    }

    public List<Supplier> findSuppliersByName(String name) {
        return supplierRepository.findSuppliersByNameLike("%"+name+"%");
    }
}
