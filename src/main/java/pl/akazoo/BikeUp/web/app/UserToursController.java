package pl.akazoo.BikeUp.web.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.User;
import pl.akazoo.BikeUp.service.impl.MemberService;
import pl.akazoo.BikeUp.service.impl.TourDetailsService;
import pl.akazoo.BikeUp.service.impl.TourService;
import pl.akazoo.BikeUp.service.impl.UserService;

import java.util.List;

@Controller
@RequestMapping("/app/tours")
@RequiredArgsConstructor
public class UserToursController {

    private final UserService userService;
    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final MemberService memberService;

    @GetMapping
    public String showTours(Model model) {
//        User user = userService.findUserByUsername();
//        model.addAttribute("allTours", tourService.findToursByUser(user));
        return "app/userTours/userTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> tours() {
        User user = userService.findUserByUsername();
        return tourService.findToursByUser(user);
    }

    @GetMapping("/delete/{id:\\d+}")
    public String prepareDelete(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findById(id));
        return "app/userTours/confirmDelete";
    }

    @PostMapping("/delete")
    public String delete(Long id) {
        TourDetails tourDetails = tourDetailsService.findByTourId(id);
        memberService.deleteMembers(memberService.findMembersByTourId(id));
        tourService.delete(id);
        tourDetailsService.delete(tourDetails);
        return "redirect:/app/tours";
    }
///////////////////////////////////
    @GetMapping("/edit/{id:\\d+}")
    public String edit() {
        return "redirect:/app/tours";
    }

    @PostMapping("/edit")
    public String edited() {

        return "redirect:/app/tours";
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id,Model model) {
        model.addAttribute("details",tourDetailsService.findByTourId(id));
        return "/app/userTours/details";
    }

    @GetMapping("/confirmTour/{id:\\d+}")
    public String confirmTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findById(id));
        return "/app/userTours/confirmTour";
    }

    @PostMapping("/confirmTour")
    public String confirmed(Long id) {
        Tour tour = tourService.findById(id);
        tour.setActive("closed");
        tourService.save(tour);
        return "redirect:/app/tours";
    }
///////////////////////////////////////////////////
    @GetMapping("/confirmParts/{id:\\d+}")
    public String confirmParticipants() {
        return "redirect:/app/tours";
    }
////////////////////////////////////////////////////
    @GetMapping("/addPoints/{id:\\d+}")
    public String addPoints() {
        return "redirect:/app/tours";
    }
}