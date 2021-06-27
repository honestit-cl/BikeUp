package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.service.impl.PointsService;

import java.util.List;

@Controller
@RequestMapping("/app/points")
public class PointsController {

    private final PointsService pointsService;

    public PointsController(PointsService pointsService) {

        this.pointsService = pointsService;
    }

    @GetMapping
    public String pointsList(Model model){
        model.addAttribute("points",pointsService.findAllByUserLogged());
        return "/app/points";
    }
}