package pl.akazoo.BikeUp.domain.model.converter;

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
public class Converter {

    private final UserService userService;
    private final TourService tourService;

    public User userRegistryToUser(UserRegistry userRegistry) {
        User user = new User();
        user.setUsername(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setPersonalDataVisibility("hidden");
        return user;
    }

    public Tour tourAddToTour(TourAdd tourAdd, TourDetails tourDetails) {
        Tour tour = new Tour();
        User user = userService.loggedUser();
        tour.setDate(tourAdd.getDate());
        tour.setHours(tourAdd.getHours());
        tour.setDistance(tourAdd.getDistance());
        tour.setParticipants(tourAdd.getParticipants());
        tour.setTourDetails(tourDetails);
        tour.setActive("otwarta");
        tour.setUser(user);
        tour.setStartPlace(tourAdd.getStartPlace());
        tour.setStartPostalCode(tourAdd.getStartPostalCode());
        tour.setEndPlace(tourAdd.getEndPlace());
        tour.setEndPostalCode(tourAdd.getEndPostalCode());
        return tour;
    }

    public TourDetails tourAddToTourDetails(TourAdd tourAdd){
        TourDetails tourDetails = new TourDetails();
        tourDetails.setGatheringPlace(tourAdd.getGatheringPlace());
        tourDetails.setMapLink(tourAdd.getLink());
        tourDetails.setDescription(tourAdd.getDescription());
        tourDetails.setReturning(tourAdd.getReturning());
        return tourDetails;
    }

    public User userEditToUser(UserEdit userEdit) {
        User user = userService.loggedUser();
        user.setFirstName(userEdit.getFirstName());
        user.setLastName(userEdit.getLastName());
        if (userEdit.getPersonalDataVisibility() != null) {
            user.setPersonalDataVisibility(userEdit.getPersonalDataVisibility());
        }
        return user;
    }

    public TourEdit tourToTourEditById(Long id) {
        Tour tour = tourService.getTourById(id);
        TourDetails tourDetails = tourService.getTourDetailsByTourId(id);
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

    public Tour tourEditToTour(TourEdit tourEdit) {
        Tour tour = tourService.getTourById(tourEdit.getTourId());
        tour.setDistance(tourEdit.getDistance());
        tour.setHours(tourEdit.getHours());
        return tour;
    }

    public TourDetails tourEditToTourDetails(TourEdit tourEdit){
        TourDetails tourDetails = tourService.getTourDetailsByTourId(tourEdit.getTourId());
        tourDetails.setDescription(tourEdit.getDescription());
        tourDetails.setMapLink(tourEdit.getLink());
        tourDetails.setGatheringPlace(tourEdit.getGatheringPlace());
        tourDetails.setReturning(tourEdit.getReturning());
        return tourDetails;
    }

    public Point pointAddToPoint(PointAdd pointAdd) {
        Point point = new Point();
        point.setDescription(pointAdd.getDescription());
        point.setAmount(pointAdd.getAmount());
        point.setGiver(userService.loggedUser());
        point.setOwner(userService.getById(pointAdd.getUserIdToAdd()));
        point.setTour(tourService.getTourById(pointAdd.getTourId()));
        return point;
    }

    public UserEdit userToUserEdit(User user){
        UserEdit userEdit = new UserEdit();
        userEdit.setFirstName(user.getFirstName());
        userEdit.setLastName(user.getLastName());
        userEdit.setPersonalDataVisibility(user.getPersonalDataVisibility());
        return  userEdit;
    }
}