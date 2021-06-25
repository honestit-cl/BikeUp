package pl.akazoo.BikeUp.web.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.service.impl.MemberService;
import pl.akazoo.BikeUp.service.impl.TourDetailsService;
import pl.akazoo.BikeUp.service.impl.TourService;

import java.util.List;

@Controller
@RequestMapping("/app/search")
@Slf4j
public class SearchController {

    private final TourService tourService;
    private final TourDetailsService tourDetailsService;
    private final MemberService memberService;

    public SearchController(TourService tourService, TourDetailsService tourDetailsService, MemberService memberService) {
        this.tourService = tourService;
        this.tourDetailsService = tourDetailsService;
        this.memberService = memberService;
    }

    @GetMapping
    public String search() {
        return "/app/searching/searchTours";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Tour> toursData() {
        return tourService.findAllToursWithoutUser();
    }

    @GetMapping("/details/{id:\\d+}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("details",tourDetailsService.findByTourId(id));
        return "/app/searching/details";
    }

    @GetMapping("/confirmPart/{id:\\d+}")
    public String confirmTrip(@PathVariable Long id, Model model) {
        model.addAttribute("tour", tourService.findById(id));
        return "/app/searching/confirmPart";
    }

    @PostMapping("/confirmPart")
    public String confirmed(Long id) {
        Tour tour = tourService.findById(id);
        memberService.saveNewMember(tour);
        return "redirect:/app/search";
    }
}