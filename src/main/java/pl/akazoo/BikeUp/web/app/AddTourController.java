package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.dto.TourAdd;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.province.City;
import pl.akazoo.BikeUp.domain.model.province.Province;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.service.impl.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/addTour")
@RequiredArgsConstructor
public class AddTourController {

    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final CityService cityService;
    private final UserService userService;
    private final Converter converter;
    private final MemberService memberService;
    private final ProvinceService provinceService;

    @GetMapping
    public String pickProvince() {
        return "app/addTour/pickProvince";
    }

    @GetMapping("/form")
    public String addTour(Model model, @RequestParam Long id) {
        if(id == 0){
            model.addAttribute("allCities", cityService.findAllByProvinceId(userService.getLoggedUserProvince().getId()));
        }else {
            model.addAttribute("allCities", cityService.findAllByProvinceId(id));
        }
        model.addAttribute("tourAdd", new TourAdd());
        return "app/addTour/addTour";
    }

    @PostMapping("/form")
    public String registerConfirm(@Valid TourAdd tourAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "app/addTour/addTour";
        }
        TourDetails tourDetails = converter.tourAddToTourDetails(tourAdd);
        Tour tour = converter.tourAddToTour(tourAdd, tourDetails);
        tourDetailsService.save(tourDetails);
        tourService.save(tour);
        ///
        memberService.saveCreatorMember(tour);
        return "app/addTour/tourAdded";
    }

    @ModelAttribute("allProvinces")
    public List<Province> provinces() {
        return provinceService.findAll();
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