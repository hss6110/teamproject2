package com.bono.bonoMovie.Member;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {

		this.memberRepository = memberRepository;
	}

	public Member memberJoin(@RequestBody MemberInfo request) {

		Member member = new Member();
		member.setMemId(request.getMemId());
		member.setMemPw(request.getMemPw());
		member.setMemName(request.getMemName());
		member.setMemGender(request.getMemGender());
		member.setMemBirthday(request.getMemBirthday());
		member.setMemMobile(request.getMemMobile());
		member.setMemEmail(request.getMemEmail());
		member.setMemPoint(request.getMemPoint());
		member.setMemMoney(request.getMemMoney());
		member.setMemAdmin(MemberAdmin.USER);
		member.setMemState(MemberState.NORMAL);
		member.setMemJoindate(null);
		member.setMemSysdate(null);

		member = memberRepository.save(member);
		return member;

	}
	
    public Member updateAdmin(@RequestParam Long memNum) {
        log.info("/updateAdmin, id : {}", memNum);

        Member member = memberRepository.findById(memNum)
                .orElseThrow(() -> new IllegalArgumentException("No Member"));

        member.setMemAdmin(MemberAdmin.ADMIN);

        log.info(member.toString());

        return member;
    }
    
    public List<Member> getMemberListAll() {
    	log.info("getMemberListAll");
        List<Member> memberList = memberRepository.findAll();

        log.info(memberList.toString());

        return memberList;
    }
    
    public List<Member> getMemberName(@RequestParam String memName) {
    	log.info("/memberName, mn : {}", memName);
    	
    	List<Member> member =memberRepository.findByMemName(memName);
    	return member;
    }
    
    public Member getMemberId(@RequestParam String memId) {
    	log.info("/memberId, mi : {}", memId);
    	Optional<Member> member = Optional.of(memberRepository.findByMemId(memId));
    	return member.orElseThrow(() -> new IllegalArgumentException("No Member"));
    }
    
    public boolean login(@RequestBody MemberInfo request) {
    	Member findMember = memberRepository.findByMemId(request.getMemId());
        if(findMember == null){
            return false;

        }

        if(!findMember.getMemPw().equals(request.getMemPw())){
            return false;
        }
        return true;
    			
    	
    }
    
    public Member getId(@RequestParam Long memNum) {
    	log.info("/memberId, ui : {}", memNum);
    	Optional<Member> member = memberRepository.findById(memNum);
		    	
    	return member.orElseThrow(() -> new IllegalArgumentException("No Member"));
    }
}
