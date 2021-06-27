package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Point;

import java.util.List;

public interface PointRepository extends JpaRepository<Point,Long> {

    List<Point> findAllByOwner_id(Long id);

}