package pl.akazoo.BikeUp.web.app;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/app", "/app/news"})
public class AppHomeController {

    @GetMapping
    public String appStartingPage(Authentication currentUser, Model model){
        model.addAttribute("currentUser",currentUser.getName());
        return "app/appHome";
    }
}