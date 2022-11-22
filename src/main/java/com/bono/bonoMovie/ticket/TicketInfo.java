package com.bono.bonoMovie.ticket;

import java.sql.Date;

import lombok.Value;

@Value
public class TicketInfo {

	private Integer ticketMemNum;
	private Integer ticketCost;
	private String ticketSeat;
	private String ticketPay;
	private Integer ticketMvNum;
	private Integer ticketRestate;
	private Integer ticketCount;
	private Integer ticketState;
	
	public TicketInfo() {
		
		this.ticketMemNum = 0;
		this.ticketCost = 0;
		this.ticketSeat = "default";
		this.ticketPay = "신용카드";
		this.ticketMvNum = 0;
		this.ticketRestate = 0;
		this.ticketCount = 0;
		this.ticketState = 0;
		
	}
}
