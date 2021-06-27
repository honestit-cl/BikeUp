package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.user.Point;
import java.util.List;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point,Long> {

    List<Point> findAllByOwner_id(Long id);

    Optional<Point> findByGiver_IdAndOwner_IdAndTour_Id(Long giver, Long owner, Long tour);
}