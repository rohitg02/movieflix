package rohit.movie_flix.repository;

import java.util.List;

import rohit.movie_flix.entity.Movie;

public interface MovieRepository {

	public Movie createMovie(Movie movie);

	public Movie findMovieByTitle(String title);

	public Movie findMovie(String movieId);

	public Movie updateMovie(Movie movie);

	public void deleteMovie(Movie existing);

	public List<Movie> findAll();

	public Movie findMovieById(String movieId);

	public List<Movie> filterMovieByType(String filterbytype);

	public List<Movie> filterMovieByYear(String filterbyyear);

	public List<Movie> filterMovieByGenre(String filterbygenre);

	public List<Movie> sortMovieByIMDBrating(String sortby);

	public List<Movie> sortMovieByYear(String sortby);

	public List<Movie> sortMovieByIMDBvotes(String sortby);

}
