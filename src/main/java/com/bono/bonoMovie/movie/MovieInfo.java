package com.bono.bonoMovie.movie;

import java.sql.Date;
import java.sql.Time;

import lombok.Value;

@Value
public class MovieInfo {

	private String mvStory;
	private String mvImg;
	private String mvAvi;
	private String mvName;
	private Date mvDateStart;
	private Date mvDateEnd;
	private Time mvTime;
	private MovieGrade mvGrade;

	public MovieInfo() {
		
		this.mvStory = "default";
		this.mvImg = "default";
		this.mvAvi = "default";
		this.mvName = "default";
		this.mvDateStart = Date.valueOf("0001-01-01");
		this.mvDateEnd = Date.valueOf("0001-01-01");
		this.mvTime = Time.valueOf("00:00:01");
		this.mvGrade = MovieGrade.G;
	}
}
