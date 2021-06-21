package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.user.Point;

public interface PointRepository extends JpaRepository<Point,Long> {
}
