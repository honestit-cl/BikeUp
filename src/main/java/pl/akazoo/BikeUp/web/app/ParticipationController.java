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
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.converter.ExtraClass;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.service.impl.MemberService;
import pl.akazoo.BikeUp.service.impl.TourDetailsService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app/participation")
public class ParticipationController {

    private final MemberService memberService;
    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final UserService userService;
    private final Converter converter;
    private final ExtraClass extraClass;

    @GetMapping("/singOut/{id:\\d+}")
    public String singOutTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findById(id));
        return "/app/participation/confirmSingOut";
    }

    @PostMapping("/singOut")
    public String confirmed(Long id) {
        memberService.singOut(id);
        return "redirect:/app/participation";
    }

    @GetMapping
    public String participation(Model model) {
        Map<Tour, String> tourList = memberService.getParticipationMap();
        model.addAttribute("tours", tourList);
        return "/app/participation/participationPage";
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details", tourDetailsService.findByTourId(id));
        return "/app/participation/details";
    }

    @GetMapping("/addPointsList/{id:\\d+}")
    public String addPoints(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findById(id));
        model.addAttribute("members", extraClass.getParticipationListForPoints(id));
        return "/app/participation/addPoints";
    }

    @GetMapping("/addPoints/{userId:\\d+}/{tourId:\\d+}")
    public String addPointsForm(@PathVariable Long userId, @PathVariable Long tourId, Model model) {
        PointAdd point = new PointAdd();
        point.setUserIdToAdd(userId);
        point.setTourId(tourId);
        model.addAttribute("pointAdd", point);
        model.addAttribute("user", userService.findUserById(userId));
        return "/app/participation/pointsForm";
    }

    @PostMapping("/addPointsConfirmed")
    public String appPointsConfirmed(@Valid PointAdd pointAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/app/participation/pointsForm";
        }

        Tour tour = tourService.findById(pointAdd.getTourId());
        TourDetails tourDetails = tourDetailsService.findByTourId(pointAdd.getTourId());

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

        if (extraClass.pointsCheck(pointAdd).isEmpty()) {
            converter.savePointAdd(pointAdd);
            return "redirect:/app/participation/addPointsList/" + pointAdd.getTourId();
        }
        return "/app/participation/pointsWrong";
    }
}