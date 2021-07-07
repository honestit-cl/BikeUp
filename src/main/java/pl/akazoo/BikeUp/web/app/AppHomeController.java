package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/app", "/app/news"})
public class AppHomeController {

    @GetMapping
    public String appStartingPage(){
        return "app/appHome";
    }
}