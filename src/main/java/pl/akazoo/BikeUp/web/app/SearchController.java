package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/search")
public class SearchController {

    @GetMapping
    public String search(){
        return "/app/searchTours";
    }
}
