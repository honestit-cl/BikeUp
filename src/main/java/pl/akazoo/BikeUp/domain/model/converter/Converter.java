package pl.akazoo.BikeUp.domain.model.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.*;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.*;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Converter {

    private final ProvinceService provinceService;
    private final CityService cityService;
    private final UserService userService;
    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final PointsService pointsService;
    private final MemberService memberService;


    public User userRegistryToUser(UserRegistry userRegistry) {
        User user = new User();
        user.setUsername(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setProvince(provinceService.findById(userRegistry.getProvince()));
        user.setVisibility("hidden");
        return user;
    }

    public TourDetails tourAddToTourDetails(TourAdd tourAdd) {
        TourDetails tourDetails = new TourDetails();
        tourDetails.setHowFar(tourAdd.getHowFar());
        tourDetails.setMapLink(tourAdd.getLink());
        tourDetails.setDescription(tourAdd.getDescription());
        tourDetails.setStart(tourAdd.getStart());
        return tourDetails;
    }

    public Tour tourAddToTour(TourAdd tourAdd, TourDetails tourDetails) {
        Tour tour = new Tour();
        City city = cityService.findCityById(tourAdd.getCityId());
        User user = userService.findUserByLoggedUsername();
        tour.setDate(tourAdd.getDate());
        tour.setHours(tourAdd.getHours());
        tour.setCity(city);
        tour.setDistance(tourAdd.getDistance());
        tour.setParticipants(tourAdd.getParticipants());
        tour.setTourDetails(tourDetails);
        tour.setActive("open");
        tour.setUser(user);
        return tour;
    }

    public User userEditToUser(UserEdit userEdit) {
        User user = userService.findUserByLoggedUsername();
        user.setProvince(provinceService.findById(userEdit.getProvince()));
        user.setFirstName(userEdit.getFirstName());
        user.setLastName(userEdit.getLastName());
        if (userEdit.getVisibility() != null) {
            user.setVisibility(userEdit.getVisibility());
        }
        return user;
    }

    public TourEdit tourToTourEditById(Long id) {
        Tour tour = tourService.findById(id);
        TourDetails tourDetails = tourDetailsService.findByTourId(id);
        TourEdit tourEdit = new TourEdit();
        tourEdit.setTourId(id);
        tourEdit.setDistance(tour.getDistance());
        tourEdit.setHours(tour.getHours());
        tourEdit.setStart(tourDetails.getStart());
        tourEdit.setDescription(tourDetails.getDescription());
        tourEdit.setHowFar(tourDetails.getHowFar());
        tourEdit.setLink(tourDetails.getMapLink());
        return tourEdit;
    }

    public void saveTourEdit(TourEdit tourEdit) {
        Tour tour = tourService.findById(tourEdit.getTourId());
        TourDetails tourDetails = tourDetailsService.findByTourId(tourEdit.getTourId());
        tour.setDistance(tourEdit.getDistance());
        tour.setHours(tourEdit.getHours());
        tour.setDate(tourEdit.getDate());
        tourDetails.setStart(tourEdit.getStart());
        tourDetails.setDescription(tourEdit.getDescription());
        tourDetails.setHowFar(tourEdit.getHowFar());
        tourDetails.setMapLink(tourEdit.getLink());
        tourService.save(tour);
        tourDetailsService.save(tourDetails);
    }

    public void savePointAdd(PointAdd pointAdd) {
        Point point = new Point();
        point.setDescription(pointAdd.getDescription());
        point.setAmount(pointAdd.getAmount());
        point.setGiver(userService.findUserByLoggedUsername());
        point.setOwner(userService.findUserById(pointAdd.getUserIdToAdd()));
        point.setTour(tourService.findById(pointAdd.getTourId()));
        pointsService.save(point);
    }

    public Optional<Point> pointsCheck(PointAdd pointAdd) {
        return pointsService.findByGiver_IdAndOwner_IdAndTour_Id(userService.findUserByLoggedUsername().getId(), pointAdd.getUserIdToAdd(), pointAdd.getTourId());
    }

    public List<Member> getParticipationListForPoints(Long tourId) {
        List<Member> members = memberService.findMembersByTourId(tourId);
        Optional<Member> member = memberService.findByUser_IdAndTour_Id(userService.findUserByLoggedUsername().getId(),tourId);
        member.ifPresent(members::remove);
        return members;
    }
}