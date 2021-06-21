package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akazoo.BikeUp.domain.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}