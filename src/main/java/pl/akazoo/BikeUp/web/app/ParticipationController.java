package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/participation")
public class ParticipationController {

    @GetMapping
    public String participation(){
        return "/app/participationPage";
    }
}