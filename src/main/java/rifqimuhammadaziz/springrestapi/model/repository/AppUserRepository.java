package rifqimuhammadaziz.springrestapi.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rifqimuhammadaziz.springrestapi.model.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

}
