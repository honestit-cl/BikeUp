package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.TourRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TourService {

    private final TourRepository tourRepository;
    private final UserService userService;

    public long allToursCount() {
        return tourRepository.count();
    }

    public void save(Tour tour) {
        log.debug("Zapisywany obiekt: " + tour);
        tourRepository.save(tour);
        log.debug("Zapisano: " + tour);
    }

    public List<Tour> getAllByUser(User user) {
        return tourRepository.findAllTourByUser(user);
    }

    public Tour getById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tour with id=" + id + " not exits."));
    }

    public void delete(Long id) {
        Tour tour = getById(id);
        log.debug("Usuwany obiekt: " + tour);
        tourRepository.delete(tour);
        log.debug("Usunięto: " + tour);
    }

    public List<Tour> getAllWithoutLogged() {
        User user = userService.logged();
        return tourRepository.findAllByUser_IdNotLike(user.getId());
    }

    public void closingTour(Long id) {
        Tour tour = getById(id);
        tour.setActive("zamknięta");
        save(tour);
    }
}