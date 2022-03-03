package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    // 스프링 컨테이너에서 받아 써야하는데 new로 만들면 다른 컨트롤러에서 사용이 가능해짐.
    private final MemberService memberService;

    // 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member= new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //home으로 보내기
    }
}
