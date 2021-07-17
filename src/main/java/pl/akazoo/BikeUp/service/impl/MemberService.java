package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.user.Member;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.repository.MemberRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService{

    private final MemberRepository memberRepository;
    private final UserService userService;

    public void save(Member member) {
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }

    public List<Member> getAllByTourId(Long id) {
        return memberRepository.findAllByTour_Id(id);
    }

    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member with id=" + id + " not exits."));
    }

    public void delete(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        log.debug("Usuwany obiekt: " + member);
        member.ifPresent(memberRepository::delete);
        log.debug("Usunięto: " + member);
    }

    public void deleteMembers(List<Member> members) {
        log.debug("Usuwany obiekt: " + members);
        memberRepository.deleteAll(members);
        log.debug("Usunięto: " + members);
    }

    public void saveNewMember(Tour tour) {
        Member member = new Member();
        member.setTour(tour);
        member.setStatus("oczekujący");
        member.setUser(userService.loggedUser());
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }

    public Optional<Member> getByUserIdAndTourId(Long userId, Long tourId) {
        return memberRepository.findByUser_idAndTour_id(userId, tourId);
    }

    public List<Member> getAllByLoggedUser() {
        return memberRepository.findByUser_id(userService.loggedUser().getId());
    }

    public void saveCreatorMember(Tour tour) {
        Member member = new Member();
        member.setStatus("aktywny");
        member.setTour(tour);
        member.setUser(userService.loggedUser());
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }

    public Map<Tour, String> getParticipationMap() {
        List<Member> memberList = getAllByLoggedUser();
        Map<Tour, String> tourList = new LinkedHashMap<>();
        memberList.removeIf(member -> member.getTour().getUser().getUsername().equals(userService.loggedUser().getUsername()));
        for (Member member : memberList) {
            tourList.put(member.getTour(), member.getStatus());
        }
        return tourList;
    }

    public void singOutFromTrip(Long tripId) {
        Optional<Member> member = getByUserIdAndTourId(userService.loggedUser().getId(), tripId);
        member.ifPresent(member2 -> delete(member2.getId()));
    }

    public void setActive(Long id) {
        Member member = getById(id);
        member.setStatus("aktywny");
        save(member);
    }

    public List<Member> getParticipationListForPoints(Long tourId) {
        List<Member> members = getAllByTourId(tourId);
        Optional<Member> member = getByUserIdAndTourId(userService.loggedUser().getId(),tourId);
        member.ifPresent(members::remove);
        return members;
    }
}