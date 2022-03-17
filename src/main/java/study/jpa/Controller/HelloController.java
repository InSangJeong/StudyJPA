package study.jpa.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jpa.Entity.Member;
import study.jpa.Service.MemberService;

@RestController
public class HelloController {

    MemberService memberService;

    public HelloController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
    @GetMapping("/sample1")
    public String tryCRUD(){
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("인상");
        member.setAge(32);

        memberService.addMember(member);


        return "done";
    }
}
