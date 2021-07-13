package pl.akazoo.BikeUp.domain.model.extraClasses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akazoo.BikeUp.domain.dto.PointAdd;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.tour.TourDetails;
import pl.akazoo.BikeUp.domain.model.user.Point;
import pl.akazoo.BikeUp.service.impl.*;
import java.util.*;

@Component
@RequiredArgsConstructor
public class ExtraClass {

    private final UserService userService;
    private final MemberService memberService;
    private final PointsService pointsService;
    private final TourDetailsService tourDetailsService;
    private final TourService tourService;

    public Map<Integer, Map<String, String>> levels = new HashMap<>(Map.of(
            0, Map.of("Początek", "Przygodę czas zacząć"),
            1, Map.of("1", "Brawo! Zrobiłeś pierwszy krok."),
            2, Map.of("2", "Świetnie Ci idzie.Rozkrecasz się !"),
            3, Map.of("3", "Stajesz się rozpoznawalny/a !"),
            4, Map.of("4", "Na niejednej szosie opony starłeś/aś !"),
            5, Map.of("5", "Liga światowa.Chapeau bas !"),
            6, Map.of("MAX", "Korona króla kolarzy jest Twoja !")
    ));

    public List<Integer> pointsList = List.of(
            0, 50, 500, 2000, 5000, 7000, 9000
    );

    public Map<String, String> countLevel(Long userPoints) {

        Map<String, String> level = new HashMap<>();

        if (userPoints == null || userPoints == 0) {
            level = levels.get(0);

        } else {
            for (int i = 0; i < pointsList.size(); i++) {
                if (userPoints < pointsList.get(i)){
                    level = levels.get(i-1);
                    break;
                }
            }
            if(userPoints>12000){
                level= levels.get(6);
            }
        }
        return level;
    }

    public Optional<Point> pointsCheck(PointAdd pointAdd) {
        return pointsService.findByGiver_IdAndOwner_IdAndTour_Id(userService.getLoggedUser().getId(), pointAdd.getUserIdToAdd(), pointAdd.getTourId());
    }

    public List<Member> getParticipationListForPoints(Long tourId) {
        List<Member> members = memberService.findMembersByTourId(tourId);
        Optional<Member> member = memberService.findByUser_IdAndTour_Id(userService.getLoggedUser().getId(),tourId);
        member.ifPresent(members::remove);
        return members;
    }

    public void deleteWholeTour(Long id) {
        TourDetails tourDetails = tourDetailsService.findByTourId(id);
        memberService.deleteMembers(memberService.findMembersByTourId(id));
        tourService.delete(id);
        tourDetailsService.delete(tourDetails.getId());
    }
}