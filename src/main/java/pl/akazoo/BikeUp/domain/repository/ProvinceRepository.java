package pl.akazoo.BikeUp.domain.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.BikeUp.domain.model.province.Province;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province,Long> {

//    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,
//            attributePaths = { "cities" }
//    )
//    List<Province> findAll();
}
