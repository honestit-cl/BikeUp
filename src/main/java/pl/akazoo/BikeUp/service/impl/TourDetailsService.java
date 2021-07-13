package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.repository.TourDetailsRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TourDetailsService {

    private final TourDetailsRepository tourDetailsRepository;
    private final TourService tourService;

    public void save(TourDetails tourDetails) {
        log.debug("Zapisywany obiekt: " + tourDetails);
        tourDetailsRepository.save(tourDetails);
        log.debug("Zapisano: " + tourDetails);
    }

    public TourDetails getByTourId(Long id) {
        return tourService.getById(id).getTourDetails();
    }

    public void delete(Long id) {
        Optional<TourDetails> tourDetails = tourDetailsRepository.findById(id);
        log.debug("Usuwany obiekt: " + tourDetails);
        tourDetails.ifPresent(tourDetailsRepository::delete);
        log.debug("Usunięto: " + tourDetails);
    }

    public TourDetails getById(Long id) {
        return tourDetailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TourDetails with id=" + id + " not exits."));
    }
}