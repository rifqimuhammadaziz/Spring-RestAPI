package rifqimuhammadaziz.springrestapi.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rifqimuhammadaziz.springrestapi.model.entity.Product;
import rifqimuhammadaziz.springrestapi.model.entity.Supplier;

import javax.websocket.server.PathParam;
import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    Supplier findByEmail(String email);

    Supplier findByName(String name);

    // Error when second hit
    List<Supplier> findSupplierByNameContaining(String name);

    // Error when second hit
    List<Supplier> findByNameStartingWith(String prefix);

    // Error when second hit
    List<Supplier> findByNameContainsOrEmailContains(String name, String email);

    // Test Success with manual query jql
    @Query("SELECT s FROM Supplier s WHERE s.name = :name")
    public Supplier findSupplierByName(@PathParam("name") String name);

    @Query("SELECT s FROM Supplier s WHERE s.name LIKE :name")
    public List<Supplier> findSuppliersByNameLike(@PathParam("name") String name);
}
