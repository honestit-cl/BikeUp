package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akazoo.BikeUp.domain.model.tour.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

}
