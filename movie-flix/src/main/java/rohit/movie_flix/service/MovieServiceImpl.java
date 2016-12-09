package rohit.movie_flix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rohit.movie_flix.entity.Movie;
import rohit.movie_flix.entity.User;
import rohit.movie_flix.exception.EntityAlreadyExistException;
import rohit.movie_flix.exception.EntityNotFoundException;
import rohit.movie_flix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movierepository;
	
	@Override
	public List<Movie> findAll() {
		return movierepository.findAll();
	}
	
	@Override
	public List<Movie> filterMovieBy(String filterby, String filterbyvalue) {
		if(filterby.equals("type")){
			System.out.println("I am inside type");
			return movierepository.filterMovieByType(filterbyvalue);
		}
		if(filterby.equals("year")){
			return movierepository.filterMovieByYear(filterbyvalue);
		}
		if(filterby.equals("genre")){
			return movierepository.filterMovieByGenre(filterbyvalue);
		}
		return null;
	}
	
	@Override
	public List<Movie> sortMovieBy(String sortby) {
		if(sortby.equals("imdbrating")){
			return movierepository.sortMovieByIMDBrating(sortby);
		}
		if(sortby.equals("year")){
			return movierepository.sortMovieByYear(sortby);
		}
		if(sortby.equals("imdbvotes")){
			return movierepository.sortMovieByIMDBvotes(sortby);
		}
		return null;
	}
	
	@Override
	public Movie findMovieById(String movieId) {
		Movie movie = movierepository.findMovieById(movieId);
		if (movie == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return movie;
	}

	
	@Transactional
	@Override
	public Movie createMovie(Movie movie) {
		Movie existing = movierepository.findMovieByTitle(movie.getTitle());
		if (existing != null) {
			throw new EntityAlreadyExistException("Movie already exist");
		}
		return movierepository.createMovie(movie);
	}
	
	@Transactional
	@Override
	public Movie updateMovie(String movieId, Movie movie) {
		Movie existing = movierepository.findMovie(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return movierepository.updateMovie(movie);
	}
	
	@Transactional
	@Override
	public void deleteMovie(String movieId) {
		Movie existing = movierepository.findMovie(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		movierepository.deleteMovie(existing);
		
	}

	

}
