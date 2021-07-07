package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.service.impl.PointsService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/points")
public class PointsController {

    private final PointsService pointsService;

    @GetMapping
    public String pointsList(Model model){
        model.addAttribute("points",pointsService.findAllByUserLogged());
        return "/app/pointsListPage/points";
    }
}