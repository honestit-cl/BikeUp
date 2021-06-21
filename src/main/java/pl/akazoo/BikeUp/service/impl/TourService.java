package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.repository.TourRepository;


@Service
@Transactional
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public long allToursCount(){
        return tourRepository.count();
    }
}