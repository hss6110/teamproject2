package com.bono.bonoMovie.Member;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberSerivce) {
		this.memberService = memberSerivce;
	}

	@GetMapping(value = "/test")
	public String test(@RequestParam(value = "name", required = false) String name) {

		return "Hi " + name;
	}

	@GetMapping(value = "/main")
	public String main() {
		log.info("--------connect main---------------");
		return "Hello, World!";
	}

	/**
	 * 회원가입 서비스 실행
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/memberJoin")
	public Member memberJoin(@RequestBody MemberInfo request) {

		return memberService.memberJoin(request);
	}

	/**
	 * 관리자 권한 부여
	 * 
	 * @param memberNum //Id값으로 검색
	 * @return
	 */
	@GetMapping(value = "/updateAdmin")
	@Transactional
	public Member updateAdmin(Long memNum) {

		return memberService.updateAdmin(memNum);
	}

	/**
	 * 회원 전체 검색
	 * @return
	 */
	@GetMapping(value = "/memberListAll")
	public List<Member> getMemberListAll() {
		return memberService.getMemberListAll();

	}
	
	/**
	 * 회원 이름으로 검색
	 * @param memberName
	 * @return
	 */
	@GetMapping(value="/memberName")
	public List<Member> getMemberName(String memName) {
		return memberService.getMemberName(memName);
	}
	
	/**
	 * 회원 아이디로 검색
	 * @param memberId
	 * @return
	 */
	@GetMapping(value="/memberId")
	public Member getMemberId(String memId) {
		return memberService.getMemberId(memId);
	}
	
	/**
	 * 로그인
	 * @param request
	 * @return
	 */
	@PostMapping(value="/login")
	public String login(@RequestBody MemberInfo request) {
		if(memberService.login(request)){
            return "redirect:/main";
        }
        return "/login";
	}
	
	/**
	 * 회원번호(@Id)로 검색
	 * @param memNum
	 * @return
	 */
	@GetMapping(value="/getId")
	 public Member getId(@RequestParam Long memNum) {
		return memberService.getId(memNum);
	}
}
