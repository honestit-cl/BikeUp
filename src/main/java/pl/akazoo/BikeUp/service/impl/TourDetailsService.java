package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.repository.TourDetailsRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TourDetailsService {

    private final TourDetailsRepository tourDetailsRepository;
    private final TourService tourService;

    public void save(TourDetails tourDetails){
        log.debug("Zapisywany obiekt: " + tourDetails);
        tourDetailsRepository.save(tourDetails);
        log.debug("Zapisano: " + tourDetails);
    }

    public TourDetails findByTourId(Long id){
        return tourService.findById(id).getTourDetails();
    }

    public void delete(TourDetails tourDetails){
        log.debug("Usuwany obiekt: " + tourDetails);
        tourDetailsRepository.delete(tourDetails);
        log.debug("Usunięto: " + tourDetails);
    }
}