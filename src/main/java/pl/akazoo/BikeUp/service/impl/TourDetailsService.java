package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.repository.TourDetailsRepository;

@Service
@Transactional
public class TourDetailsService {

    private final TourDetailsRepository tourDetailsRepository;
    private final TourService tourService;

    public TourDetailsService(TourDetailsRepository tourDetailsRepository, TourService tourService) {
        this.tourDetailsRepository = tourDetailsRepository;
        this.tourService = tourService;
    }

    public void save(TourDetails tourDetails){
        tourDetailsRepository.save(tourDetails);
    }

    public TourDetails findByTourId(Long id){
        return tourService.findById(id).getTourDetails();
    }

    public void delete(TourDetails tourDetails){
        tourDetailsRepository.delete(tourDetails);
    }
}
