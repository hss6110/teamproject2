package com.bono.bonoMovie.movie;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieSerivce) {
		this.movieService = movieSerivce;
	}

	
	@PostMapping(value = "/InsertMovie")
	public Movie insertMovie(@RequestBody MovieInfo request) {
		log.info("------------------ 영화 저장---------------");

		return movieService.InsertMovie(request);
	}
}
