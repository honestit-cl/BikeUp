package pl.akazoo.BikeUp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.BikeUp.domain.model.Member;
import pl.akazoo.BikeUp.domain.repository.MemberRepository;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(Member member){
        memberRepository.save(member);
    }

    public List<Member> findMembersByTourId(Long id){
        return memberRepository.findAllByTour_Id(id);
    }

    public void deleteMembers(List<Member> members){
        memberRepository.deleteAll(members);
    }
}
