package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.domain.dto.PointAdd;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.service.impl.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/participation")
public class ParticipationController {

    private final MemberService memberService;
    private final TourService tourService;
    private final UserService userService;
    private final Converter converter;
    private final PointsService pointsService;

    @GetMapping("/singOut/{id:\\d+}")
    public String singOutTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "/app/participation/confirmSingOut";
    }

    @PostMapping("/singOut")
    public String confirmed(Long id) {
        memberService.singOutFromTrip(id);
        return "redirect:/app/participation";
    }

    @GetMapping
    public String participation(Model model) {
        model.addAttribute("tours", memberService.getParticipationMap());
        return "/app/participation/participationPage";
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details", tourService.getTourDetailsByTourId(id));
        return "/app/participation/details";
    }

    @GetMapping("/addPointsList/{id:\\d+}")
    public String addPoints(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        model.addAttribute("members", memberService.getParticipationListForPoints(id));
        return "/app/participation/addPoints";
    }

    @GetMapping("/addPoints/{userId:\\d+}/{tourId:\\d+}")
    public String addPointsForm(@PathVariable Long userId, @PathVariable Long tourId, Model model) {
        PointAdd point = new PointAdd();
        point.setUserIdToAdd(userId);
        point.setTourId(tourId);
        model.addAttribute("pointAdd", point);
        model.addAttribute("user", userService.getById(userId));
        return "/app/participation/pointsForm";
    }

    @PostMapping("/addPointsConfirmed")
    public String appPointsConfirmed(@Valid PointAdd pointAdd, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/app/participation/pointsForm";
        }

        Tour tour = tourService.getTourById(pointAdd.getTourId());
        TourDetails tourDetails = tourService.getTourDetailsByTourId(pointAdd.getTourId());

        if (tourDetails.getReturning().equals("tak")) {
            if (pointAdd.getAmount() > tour.getDistance() * 2) {
                bindingResult.rejectValue("amount", null, "Ilość punktów nie może większa niż " + tour.getDistance() * 2);
                return "/app/participation/pointsForm";
            }
        } else {
            if (pointAdd.getAmount() > tour.getDistance()) {
                bindingResult.rejectValue("amount", null, "Ilość punktów nie może większa niż " + tour.getDistance());
                return "/app/participation/pointsForm";
            }
        }

        if (!pointsService.exists(pointAdd)) {
            Point point = converter.pointAddToPoint(pointAdd);
            pointsService.save(point);
            model.addAttribute("tourId",pointAdd.getTourId());
            return "/app/participation/pointsDone";
        }
        return "/app/participation/pointsWrong";
    }
}