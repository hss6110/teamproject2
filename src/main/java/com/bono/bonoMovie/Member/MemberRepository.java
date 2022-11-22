package com.bono.bonoMovie.Member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
	List<Member> findByMemName(String memName);
	Member findByMemId(String memId); 

}
