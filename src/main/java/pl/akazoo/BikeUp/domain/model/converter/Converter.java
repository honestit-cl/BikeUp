package pl.akazoo.BikeUp.domain.model.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.TourAdd;
import pl.akazoo.BikeUp.domain.dto.UserEdit;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.CityService;
import pl.akazoo.BikeUp.service.impl.ProvinceService;
import pl.akazoo.BikeUp.service.impl.UserService;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class Converter {

    private final ProvinceService provinceService;
    private final CityService cityService;
    private final UserService userService;


    public User userRegistryToUser(UserRegistry userRegistry) {
        User user = new User();
        user.setUsername(userRegistry.getLogin());
        user.setPassword(userRegistry.getPassword());
        user.setProvince(provinceService.findById(userRegistry.getProvince()));
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
        User user = userService.findUserByUsername();
        tour.setDate(LocalDate.parse(tourAdd.getDate()));
        tour.setHours(tourAdd.getHours());
        tour.setCity(city);
        tour.setDistance(tourAdd.getDistance());
        tour.setParticipants(tourAdd.getParticipants());
        tour.setTourDetails(tourDetails);
        tour.setActive("open");
        tour.setUser(user);
        return tour;
    }

    public Tour tourAddToTourEx(TourAdd tourAdd, TourDetails tourDetails) {
        Tour tour = new Tour();
        City city = cityService.findCityById(tourAdd.getCityId());
        User user = userService.findUserEx();
        tour.setDate(LocalDate.parse(tourAdd.getDate()));
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
        User user = userService.findUserByUsername();
        user.setProvince(provinceService.findById(userEdit.getProvince()));
        user.setFirstName(userEdit.getFirstName());
        user.setLastName(userEdit.getLastName());
        return user;
    }
}