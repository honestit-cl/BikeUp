package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour,Long> {

    List<Tour> findAllTourByUser(User user);

    List<Tour> findAllByUser_IdNotLike(Long id);
}