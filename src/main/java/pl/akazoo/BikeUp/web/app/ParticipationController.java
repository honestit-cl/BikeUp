package pl.akazoo.BikeUp.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.BikeUp.service.impl.MemberService;

@Controller
@RequestMapping("/app/participation")
public class ParticipationController {

    private final MemberService memberService;

    public ParticipationController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String participation(){
        memberService.findMembersByLoggedUsername();
        return "/app/participationPage";
    }
}