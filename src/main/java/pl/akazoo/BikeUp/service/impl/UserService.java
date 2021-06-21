package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long allUsersCount() {
        return userRepository.count();
    }

    public void save(User user){
        userRepository.save(user);
    }
}