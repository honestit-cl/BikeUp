package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.service.impl.MemberService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/search")
public class SearchTourController {

    private final TourService tourService;
    private final MemberService memberService;
    private final UserService userService;

    @GetMapping
    public String search() {
        return "/app/tourSearching/searchTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> toursData() {
        return tourService.getToursWithoutLoggedUser();
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details",tourService.getTourDetailsByTourId(id));
        return "/app/tourSearching/details";
    }

    @GetMapping("/confirmPart/{id:\\d+}")
    public String confirmTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "/app/tourSearching/confirmPart";
    }

    @PostMapping("/confirmPart")
    public String confirmed(Long id) {
        if(memberService.getByUserIdAndTourId(userService.loggedUser().getId(),id).isEmpty()) {
            Tour tour = tourService.getTourById(id);
            memberService.saveNewMember(tour);
            return "/app/tourSearching/userAdded";
        }
        return "/app/tourSearching/memberWrong";
    }
}