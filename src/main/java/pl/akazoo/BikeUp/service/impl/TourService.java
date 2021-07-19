package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.domain.repository.TourDetailsRepository;
import pl.akazoo.BikeUp.domain.repository.TourRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TourService {

    private final TourRepository tourRepository;
    private final UserService userService;
    private final MemberService memberService;
    private final TourDetailsRepository tourDetailsRepository;

    public long allToursCount() {
        return tourRepository.count();
    }

    public void saveTour(Tour tour) {
        log.debug("Zapisywany obiekt: " + tour);
        tourRepository.save(tour);
        log.debug("Zapisano: " + tour);
    }

    public List<Tour> getToursByUser(User user) {
        return tourRepository.findAllTourByUser(user);
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tour with id=" + id + " not exits."));
    }

    public void deleteTour(Long id) {
        Tour tour = getTourById(id);
        log.debug("Usuwany obiekt: " + tour);
        tourRepository.delete(tour);
        log.debug("Usunięto: " + tour);
    }

    public List<Tour> getToursWithoutLoggedUser() {
        User user = userService.loggedUser();
        return tourRepository.findAllByUser_IdNotLike(user.getId());
    }

    public void setClose(Long id) {
        Tour tour = getTourById(id);
        tour.setActive("zamknięta");
        saveTour(tour);
    }

    public void deleteWholeTour(Long tourId) {
        TourDetails tourDetails = getTourDetailsByTourId(tourId);
        memberService.deleteMembers(memberService.getAllByTourId(tourId));
        deleteTour(tourId);
        deleteTourDetails(tourDetails.getId());
    }

    public void saveTourDetails(TourDetails tourDetails) {
        log.debug("Zapisywany obiekt: " + tourDetails);
        tourDetailsRepository.save(tourDetails);
        log.debug("Zapisano: " + tourDetails);
    }

    public TourDetails getTourDetailsByTourId(Long id) {
        return getTourById(id).getTourDetails();
    }

    public void deleteTourDetails(Long id) {
        Optional<TourDetails> tourDetails = tourDetailsRepository.findById(id);
        log.debug("Usuwany obiekt: " + tourDetails);
        tourDetails.ifPresent(tourDetailsRepository::delete);
        log.debug("Usunięto: " + tourDetails);
    }
}