package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.repository.CityRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;

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

    public City findCityById(Long id){
         return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City with id " + id + " not exist"));
    }
}