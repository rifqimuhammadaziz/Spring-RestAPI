package rifqimuhammadaziz.springrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rifqimuhammadaziz.springrestapi.model.entity.AppUser;
import rifqimuhammadaziz.springrestapi.model.repository.AppUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%s' not found", email)));
    }

    public AppUser registerUser(AppUser user) {
        boolean isUserExist = appUserRepository.findByEmail(user.getEmail()).isPresent();
        if (isUserExist) {
            throw new RuntimeException(
                    String.format("User with email '%s' already exists", user.getEmail())
            );
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRepository.save(user);
    }
}
