package pl.akazoo.BikeUp.web.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/profile")
public class ProfileController {

    @GetMapping
    public String profile(){
        return "/app/profile";
    }
}