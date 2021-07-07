package pl.akazoo.BikeUp.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.UserRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public long allUsersCount() {
        return userRepository.count();
    }

    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public User getLoggedUser() {
        return userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new ResourceNotFoundException("User with name: " + SecurityContextHolder.getContext().getAuthentication().getName() + " not exist"));
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}