package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.TourAdd;
import pl.akazoo.BikeUp.domain.dto.UserRegistry;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.service.impl.CityService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app/addTour")
public class AddTourController {

    private final TourService tourService;
    private final CityService cityService;
    private final UserService userService;


    public AddTourController(TourService tourService, CityService cityService, UserService userService) {
        this.tourService = tourService;
        this.cityService = cityService;
        this.userService = userService;

    }

    @GetMapping
    public String addTour(Model model) {
        model.addAttribute("tourAdd", new TourAdd());
        return "app/addTour";
    }

    @PostMapping
    public String registerConfirm(@Valid TourAdd tourAdd, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "app/addTour";
        }
        model.addAttribute("added",tourAdd);
        return "app/tourAdded";
    }

    @ModelAttribute("allCities")
    public List<City> cities() {
        return cityService.findAllByProvince(userService.findProvinceByLoggedUsername());
    }
    @ModelAttribute("hours")
    public List<String> hours() {
        return List.of(
                "30min",
                "1h",
                "1:30h",
                "2h",
                "2:30h",
                "3h",
                "3:30h",
                "4h",
                "4:30h",
                "5h",
                "5:30h",
                "6h",
                "6:30h",
                "7h",
                "7:30h",
                "8h",
                "8:30h",
                "9h",
                "9:30h",
                "10h",
                "10:30h",
                "11h",
                "11:30h",
                "12h"
        );
    }

    @ModelAttribute("kilometersAway")
    public List<String> kilometersAway() {
        return List.of(
                "bezpośrednio",
                "1-5km",
                "do 10km",
                "do 15km",
                "do 20km",
                "do 25km",
                "powyżej 25km"
        );
    }
}