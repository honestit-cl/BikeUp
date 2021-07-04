package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.province.Province;
import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {

    List<City> findAllByProvince_Id(Long id);
}