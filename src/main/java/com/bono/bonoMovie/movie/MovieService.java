package com.bono.bonoMovie.movie;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MovieService {
	
	public final MovieRepository movieRepository;
	public MovieService (MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Movie InsertMovie(@RequestBody MovieInfo request) {

		Movie movie = new Movie();
		movie.setMvState(MovieState.UPCOMING);
		movie.setMvStory(request.getMvStory());
		movie.setMvImg(request.getMvImg());
		movie.setMvAvi(request.getMvAvi());
		movie.setMvName(request.getMvName());
		movie.setMvDateStart(request.getMvDateStart());
		movie.setMvDateEnd(request.getMvDateEnd());
		movie.setMvTime(request.getMvTime());
		movie.setMvGrade(request.getMvGrade());
		

		movie = movieRepository.save(movie);
		return movie;

	}

}
