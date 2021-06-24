package pl.akazoo.BikeUp.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.UserRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Province findProvinceByLoggedUsername() {
        Optional<User> user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.orElseThrow(() -> new ResourceNotFoundException("User not exist")).getProvince();
    }

    public User findUserByUsername() {
        return userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new ResourceNotFoundException("User with name: " + SecurityContextHolder.getContext().getAuthentication().getName() + " not exist"));
    }

    public User findUserEx(){
        return userRepository.findById(1L).orElseThrow();
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
}