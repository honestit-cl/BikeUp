package pl.akazoo.BikeUp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.repository.MemberRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final UserService userService;

    public void save(Member member){
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }

    public List<Member> findMembersByTourId(Long id){
        return memberRepository.findAllByTour_Id(id);
    }

    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member with id="+id+"not exits."));
    }

    public void delete(Member member){
        log.debug("Usuwany obiekt: " + member);
        memberRepository.delete(member);
        log.debug("Usunięto: " + member);
    }

    public void deleteMembers(List<Member> members){
        log.debug("Usuwany obiekt: " + members);
        memberRepository.deleteAll(members);
        log.debug("Usunięto: " + members);
    }

    public void saveNewMember(Tour tour){
        Member member = new Member();
        member.setTour(tour);
        member.setStatus("oczekujący");
        member.setUser(userService.getLoggedUser());
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }

    public Optional<Member> findByUser_IdAndTour_Id(Long userId,Long tourId){
        return memberRepository.findByUser_idAndTour_id(userId, tourId);
    }

    public List<Member> findMembersByLoggedUsername(){
        return memberRepository.findByUser_id(userService.getLoggedUser().getId());
    }

    public void saveCreatorMember(Tour tour) {
        Member member = new Member();
        member.setStatus("aktywny");
        member.setTour(tour);
        member.setUser(userService.getLoggedUser());
        log.debug("Zapisywany obiekt: " + member);
        memberRepository.save(member);
        log.debug("Zapisano: " + member);
    }
}