package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
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
    private final TourDetailsService tourDetailsService;
    private final  MemberService memberService;
    private final TourService tourService;

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

    public List<Tour> getAllWithoutLoggedUser() {
        User user = userService.loggedUser();
        return tourRepository.findAllByUser_IdNotLike(user.getId());
    }

    public void setClose(Long id) {
        Tour tour = getById(id);
        tour.setActive("zamknięta");
        save(tour);
    }

    public void deleteWholeTour(Long tourId) {
        TourDetails tourDetails = tourDetailsService.getByTourId(tourId);
        memberService.deleteMembers(memberService.getAllByTourId(tourId));
        tourService.delete(tourId);
        tourDetailsService.delete(tourDetails.getId());
    }
}