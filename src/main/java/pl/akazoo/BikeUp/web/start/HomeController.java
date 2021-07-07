package pl.akazoo.BikeUp.web.start;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final UserService userService;
    private final TourService tourService;

    @GetMapping
    public String welcome(Model model){
        model.addAttribute("users",userService.allUsersCount());
        model.addAttribute("tours",tourService.allToursCount());
        return "start/start";
    }
}