package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.dto.TourEdit;
import pl.akazoo.BikeUp.domain.dto.PointAdd;
import pl.akazoo.BikeUp.domain.model.converter.Converter;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.service.impl.*;
import pl.akazoo.BikeUp.structure.ApplicationData;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app/tours")
@RequiredArgsConstructor
public class UserToursController {

    private final UserService userService;
    private final TourService tourService;
    private final MemberService memberService;
    private final Converter converter;
    private final PointsService pointsService;
    private final ApplicationData applicationData;

    @GetMapping
    public String showTours() {
        return "app/userTours/userTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> tours() {
        return tourService.getToursByUser(userService.loggedUser());
    }

    @GetMapping("/delete/{id:\\d+}")
    public String prepareDelete(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "app/userTours/confirmDelete";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        tourService.deleteWholeTour(id);
        return "redirect:/app/tours";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("tourEdit", converter.tourToTourEditById(id));
        return "/app/userTours/editTour";
    }

    @PostMapping("/edit")
    public String edited(@Valid TourEdit tourEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            tourEdit.setReturning("");
            return "app/userTours/editTour";
        }
        Tour tour = converter.tourEditToTour(tourEdit);
        TourDetails tourDetails = converter.tourEditToTourDetails(tourEdit);
        tourService.saveTour(tour);
        tourService.saveTourDetails(tourDetails);
        return "redirect:/app/tours";
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details", tourService.getTourDetailsByTourId(id));
        return "/app/userTours/details";
    }

    @GetMapping("/confirmTour/{id:\\d+}")
    public String confirmTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "/app/userTours/confirmTour";
    }

    @PostMapping("/confirmTour")
    public String confirmed(Long id) {
        tourService.setClose(id);
        return "redirect:/app/tours";
    }

    @GetMapping("/confirmPart/{id:\\d+}")
    public String confirmParticipants(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        model.addAttribute("members", memberService.getAllByTourId(id));
        return "/app/userTours/confirmParticipators";
    }

    @GetMapping("/setActive/{id:\\d+}/{id2:\\d+}")
    public String setActiveMember(@PathVariable Long id, @PathVariable Long id2) {
        memberService.setActive(id);
        return "redirect:/app/tours/confirmPart/" + id2;
    }

    @GetMapping("/addPointsList/{id:\\d+}")
    public String addPoints(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        model.addAttribute("members", memberService.getParticipationListForPoints(id));
        return "/app/userTours/addPoints";
    }

    @GetMapping("/addPoints/{userId:\\d+}/{tourId:\\d+}")
    public String addPointsForm(@PathVariable Long userId, @PathVariable Long tourId, Model model) {
        PointAdd point = new PointAdd();
        point.setUserIdToAdd(userId);
        point.setTourId(tourId);
        model.addAttribute("pointAdd", point);
        model.addAttribute("user", userService.getById(userId));
        return "/app/userTours/pointsForm";
    }

    @PostMapping("/addPointsConfirmed")
    public String appPointsConfirmed(@Valid PointAdd pointAdd, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "/app/userTours/pointsForm";
        }

        Tour tour = tourService.getTourById(pointAdd.getTourId());
        TourDetails tourDetails = tourService.getTourDetailsByTourId(pointAdd.getTourId());

        if (tourDetails.getReturning().equals("tak")) {
            if (pointAdd.getAmount() > tour.getDistance() * 2) {
                bindingResult.rejectValue("amount", null, "Ilość punktów nie może większa niż " + tour.getDistance() * 2);
                return "/app/userTours/pointsForm";
            }
        } else {
            if (pointAdd.getAmount() > tour.getDistance()) {
                bindingResult.rejectValue("amount", null, "Ilość punktów nie może większa niż " + tour.getDistance());
                return "/app/userTours/pointsForm";
            }
        }

        if (!pointsService.exists(pointAdd)) {
            Point point = converter.pointAddToPoint(pointAdd);
            pointsService.save(point);
            model.addAttribute("tourId",pointAdd.getTourId());
            return "app/userTours/pointsDone";
        }
        return "/app/userTours/pointsWrong";
    }

    @ModelAttribute("hours")
    public List<String> hours() {
        return applicationData.getHours();
    }
}