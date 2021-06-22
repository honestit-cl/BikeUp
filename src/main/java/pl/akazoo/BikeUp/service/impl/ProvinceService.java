package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.repository.ProvinceRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<Province> findAll(){
        return provinceRepository.findAll();
    }

    public Province findById(Long id){
        return provinceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Province with id " + id + " not exist"));
    }
    public void save(Province province){
        provinceRepository.save(province);
    }
}