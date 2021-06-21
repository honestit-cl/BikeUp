package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import pl.akazoo.BikeUp.domain.repository.TourRepository;


@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public long allToursCount(){
        return tourRepository.count();
    }
}