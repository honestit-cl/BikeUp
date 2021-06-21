package pl.akazoo.BikeUp.web.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;
    private final TourService tourService;

    public HomeController(UserService userService, TourService tourService) {
        this.userService = userService;
        this.tourService = tourService;
    }

    @GetMapping
    public String welcome(Model model){
        model.addAttribute("users",userService.allUsersCount());
        model.addAttribute("tours",tourService.allToursCount());
        return "start/start";
    }
}