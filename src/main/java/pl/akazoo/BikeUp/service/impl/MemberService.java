package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.model.tour.Tour;
import pl.akazoo.BikeUp.domain.repository.MemberRepository;
import pl.akazoo.BikeUp.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final UserService userService;

    public MemberService(MemberRepository memberRepository, UserService userService) {
        this.memberRepository = memberRepository;
        this.userService = userService;
    }

    public void save(Member member){
        memberRepository.save(member);
    }

    public List<Member> findMembersByTourId(Long id){
        return memberRepository.findAllByTour_Id(id);
    }
    public Member findById(Long id){
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member with id="+id+"not exits."));
    }

    public void deleteMembers(List<Member> members){
        memberRepository.deleteAll(members);
    }

    public void saveNewMember(Tour tour){
        Member member = new Member();
        member.setTour(tour);
        member.setStatus("waiting");
        member.setUser(userService.findUserByUsername());
        memberRepository.save(member);
    }
}
