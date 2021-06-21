package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.province.City;

public interface CityRepository extends JpaRepository<City,Long> {
}
