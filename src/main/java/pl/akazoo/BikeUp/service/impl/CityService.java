package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.repository.CityRepository;

import java.util.List;

@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllByProvince(Province province){
        return cityRepository.findAllByProvince(province);
    }
}
