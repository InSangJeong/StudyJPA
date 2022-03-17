package study.jpa.Service;

import org.springframework.stereotype.Service;
import study.jpa.Entity.Member;
import study.jpa.Repository.MemberRepository;

@Service
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void addMember(Member m){
        memberRepository.save(m);

    }


}
