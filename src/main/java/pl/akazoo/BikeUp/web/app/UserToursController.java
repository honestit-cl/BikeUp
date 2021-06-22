package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

import java.util.List;

@Controller
@RequestMapping("/app/tours")
public class UserToursController {

    private final UserService userService;
    private final TourService tourService;

    public UserToursController(UserService userService, TourService tourService) {
        this.userService = userService;
        this.tourService = tourService;
    }

    @GetMapping
    public String showTours(Model model) {
//        User user = userService.findUserByUsername();
//        model.addAttribute("allTours", tourService.findToursByUser(user));
        return "app/userTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> tours() {
        User user = userService.findUserByUsername();
        return tourService.findToursByUser(user);
    }
}
