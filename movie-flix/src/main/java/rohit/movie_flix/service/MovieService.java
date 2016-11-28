package rohit.movie_flix.service;

import java.util.List;

import rohit.movie_flix.entity.Movie;

public interface MovieService {
	
	public Movie createMovie(Movie movie);

	public Movie updateMovie(String movieId,Movie movie);

	public void deleteMovie(String movieId);

	public List<Movie> findAll();

	public Movie findMovieById(String movieId);

	public List<Movie> filterMovieBy(String filterby, String filterbyvalue);

	public List<Movie> sortMovieBy(String sortby);

}
