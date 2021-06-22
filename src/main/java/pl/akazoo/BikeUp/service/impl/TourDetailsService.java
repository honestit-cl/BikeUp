package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsService {

    private final TourDetailsRepository tourDetailsRepository;

    public TourDetailsService(TourDetailsRepository tourDetailsRepository) {
        this.tourDetailsRepository = tourDetailsRepository;
    }


    public void save(TourDetails tourDetails){
        tourDetailsRepository.save(tourDetails);
    }
}
