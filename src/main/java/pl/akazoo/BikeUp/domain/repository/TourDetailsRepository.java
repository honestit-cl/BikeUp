package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;

public interface TourDetailsRepository extends JpaRepository<TourDetails,Long> {
}
