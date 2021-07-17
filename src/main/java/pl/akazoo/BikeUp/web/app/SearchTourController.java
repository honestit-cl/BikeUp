package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.service.impl.MemberService;
import pl.akazoo.BikeUp.service.impl.TourDetailsService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/search")
public class SearchTourController {

    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final MemberService memberService;
    private final UserService userService;

    @GetMapping
    public String search() {
        return "/app/searching/searchTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> toursData() {
        return tourService.getAllWithoutLoggedUser();
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details",tourDetailsService.getByTourId(id));
        return "/app/searching/details";
    }

    @GetMapping("/confirmPart/{id:\\d+}")
    public String confirmTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getById(id));
        return "/app/searching/confirmPart";
    }

    @PostMapping("/confirmPart")
    public String confirmed(Long id) {
        if(memberService.getByUserIdAndTourId(userService.loggedUser().getId(),id).isEmpty()) {
            Tour tour = tourService.getById(id);
            memberService.saveNewMember(tour);
            return "/app/searching/userAdded";
        }
        return "/app/searching/memberWrong";
    }
}