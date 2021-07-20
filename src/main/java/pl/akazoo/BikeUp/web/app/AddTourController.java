package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.dto.TourAdd;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.structure.ApplicationData;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.service.impl.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/addTour")
@RequiredArgsConstructor
public class AddTourController {

    private final Converter converter;
    private final MemberService memberService;
    private final TourService tourService;
    private final ApplicationData applicationData;

    @GetMapping()
    public String addTour(Model model) {
        model.addAttribute("tourAdd", new TourAdd());
        return "app/addTour/addTour";
    }

    @PostMapping()
    public String registerConfirm(@Valid TourAdd tourAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            tourAdd.setReturning("");
            return "app/addTour/addTour";
        }
        TourDetails tourDetails = converter.tourAddToTourDetails(tourAdd);
        Tour tour = converter.tourAddToTour(tourAdd, tourDetails);
        tourService.saveTourDetails(tourDetails);
        tourService.saveTour(tour);
        memberService.saveCreatorMember(tour);
        return "app/addTour/tourAdded";
    }

    @ModelAttribute("hours")
    public List<String> hours() {
        return applicationData.getHours();
    }
}