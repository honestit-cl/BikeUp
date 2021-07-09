package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.UserRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements pl.akazoo.BikeUp.service.Service<User> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public long allUsersCount() {
        return userRepository.count();
    }

    @Override
    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        log.debug("Zapisywany obiekt: " + user);
        userRepository.save(user);
        log.debug("Zapisano: " + user);
    }

    public User getLoggedUser() {
        return userRepository
                .findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new ResourceNotFoundException("User with name: " + SecurityContextHolder.getContext().getAuthentication().getName() + " not exist"));
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id=" + id + " not exist"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        log.debug("Usuwany obiekt: " + user);
        user.ifPresent(userRepository::delete);
        log.debug("Usunięto: " + user);
    }
}