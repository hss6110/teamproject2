package com.bono.bonoMovie;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bono.bonoMovie.Member.Member;
import com.bono.bonoMovie.Member.MemberAdmin;
import com.bono.bonoMovie.Member.MemberRepository;
import com.bono.bonoMovie.Member.MemberState;
@SpringBootTest
public class MemberJoinTest {
	
	private final MemberRepository memberRepository2;

	public MemberJoinTest(MemberRepository memberRepository2) {

		this.memberRepository2 = memberRepository2;
	}	
	
	@Test
	public Member memberJoin() {

		Member member = new Member();
		member.setMemId("id");
		member.setMemPw("12");
		member.setMemName("hss");
		member.setMemGender(1);
		member.setMemBirthday(Date.valueOf("1999-05-05"));
		member.setMemMobile("010-1234-1234");
		member.setMemEmail("testt@naver.com");
		member.setMemPoint(null);
		member.setMemMoney(null);
		member.setMemAdmin(MemberAdmin.USER);
		member.setMemState(MemberState.NORMAL);
		member.setMemJoindate(null);
		member.setMemSysdate(null);

		member = memberRepository2.save(member);
		return member;

	}

}
