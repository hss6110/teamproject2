package com.bono.bonoMovie.Member;



import java.sql.Date;

import lombok.Value;

@Value
public class MemberInfo {

	private String memId;
	private String memPw;
	private String memName;
	private Integer memGender;
	private Date memBirthday;
	private String memMobile;
	private String memEmail;
	private Integer memPoint;
	private Integer memMoney;
	
	public MemberInfo() {
		
		this.memId = "default";
		this.memPw = "default";
		this.memName = "default";
		this.memGender = 0;
		this.memBirthday = Date.valueOf("1111-11-11");
		this.memMobile = "1";
		this.memEmail = "default";
		this.memPoint = 0;
		this.memMoney = 0;
		
	}

}
