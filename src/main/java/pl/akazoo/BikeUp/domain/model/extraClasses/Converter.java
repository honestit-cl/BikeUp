//TODO To extraClasses jak już nie ma lepszego pomysłu, to zmienić na utils albo helpers
package pl.akazoo.BikeUp.domain.model.extraClasses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.*;

@Slf4j
@Component
@RequiredArgsConstructor
//TODO Ta klasa nazywa się jak konwerter a pełni rolę logiki biznesowej (zapisując użytkowników itd)
//     Zdecydowanie zły pomysł
public class Converter {

    private final UserService userService;
    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final PointsService pointsService;

    public void saveUserRegistry(UserRegistry userRegistry) {
        User user = new User();
        user.setUsername(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setVisibility("hidden");
        userService.save(user);
    }

    public Tour saveTourAdd(TourAdd tourAdd) {
        TourDetails tourDetails = new TourDetails();
        tourDetails.setGatheringPlace(tourAdd.getGatheringPlace());
        tourDetails.setMapLink(tourAdd.getLink());
        tourDetails.setDescription(tourAdd.getDescription());
        tourDetails.setReturning(tourAdd.getReturning());
        ////
        Tour tour = new Tour();
        User user = userService.getLoggedUser();
        tour.setDate(tourAdd.getDate());
        tour.setHours(tourAdd.getHours());
        tour.setDistance(tourAdd.getDistance());
        tour.setParticipants(tourAdd.getParticipants());
        tour.setTourDetails(tourDetails);
        tour.setActive("otwarta");
        tour.setUser(user);
        tour.setStartPlace(tourAdd.getStartPlace());
        tour.setStartPost(tourAdd.getStartPost());
        tour.setEndPlace(tourAdd.getEndPlace());
        tour.setEndPost(tourAdd.getEndPost());
        //////
        tourDetailsService.save(tourDetails);
        tourService.save(tour);
        //////
        return tour;
    }

    public void saveUserEdit(UserEdit userEdit) {
        User user = userService.getLoggedUser();
        user.setFirstName(userEdit.getFirstName());
        user.setLastName(userEdit.getLastName());
        if (userEdit.getVisibility() != null) {
            user.setVisibility(userEdit.getVisibility());
        }
        userService.save(user);
    }

    public TourEdit tourToTourEditById(Long id) {
        Tour tour = tourService.findById(id);
        TourDetails tourDetails = tourDetailsService.findByTourId(id);
        TourEdit tourEdit = new TourEdit();
        tourEdit.setTourId(id);
        tourEdit.setDistance(tour.getDistance());
        tourEdit.setHours(tour.getHours());
        tourEdit.setGatheringPlace(tourDetails.getGatheringPlace());
        tourEdit.setReturning(tourDetails.getReturning());
        tourEdit.setDescription(tourDetails.getDescription());
        tourEdit.setLink(tourDetails.getMapLink());
        return tourEdit;
    }

    public void saveTourEdit(TourEdit tourEdit) {
        Tour tour = tourService.findById(tourEdit.getTourId());
        TourDetails tourDetails = tourDetailsService.findByTourId(tourEdit.getTourId());
        tour.setDistance(tourEdit.getDistance());
        tour.setHours(tourEdit.getHours());
        tourDetails.setDescription(tourEdit.getDescription());
        tourDetails.setMapLink(tourEdit.getLink());
        tourDetails.setGatheringPlace(tourEdit.getGatheringPlace());
        tourDetails.setReturning(tourEdit.getReturning());
        tourService.save(tour);
        tourDetailsService.save(tourDetails);
    }

    public void savePointAdd(PointAdd pointAdd) {
        Point point = new Point();
        point.setDescription(pointAdd.getDescription());
        point.setAmount(pointAdd.getAmount());
        point.setGiver(userService.getLoggedUser());
        point.setOwner(userService.findById(pointAdd.getUserIdToAdd()));
        point.setTour(tourService.findById(pointAdd.getTourId()));
        pointsService.save(point);
    }

    public UserEdit userToUserEdit(User user){
        UserEdit userEdit = new UserEdit();
        userEdit.setFirstName(user.getFirstName());
        userEdit.setLastName(user.getLastName());
        userEdit.setVisibility(user.getVisibility());
        return  userEdit;
    }
}