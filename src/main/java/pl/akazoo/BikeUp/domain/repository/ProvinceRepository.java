package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.province.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long> {
}