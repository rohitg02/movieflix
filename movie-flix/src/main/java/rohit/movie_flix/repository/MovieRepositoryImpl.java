package rohit.movie_flix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rohit.movie_flix.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository{
	
	@PersistenceContext
	private EntityManager mov;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> filterMovieByType(String filterbytype) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.filterByType", Movie.class);
		query.setParameter("filterbytype", filterbytype);
		List<Movie> movies = query.getResultList();
			return movies;
		
	}


	@Override
	public List<Movie> filterMovieByYear(String filterbyyear) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.filterByYear", Movie.class);		
		int year = Integer.parseInt(filterbyyear);
		query.setParameter("filterbyyear", year);
		List<Movie> movies = query.getResultList();
		if (movies.size() > 0) {
			return movies;
		} else {
			return null;
		}
	}


	@Override
	public List<Movie> filterMovieByGenre(String filterbygenre) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.filterByGenre", Movie.class);		
		query.setParameter("filterbygenre", filterbygenre);
		List<Movie> movies = query.getResultList();
		if (movies.size() > 0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> sortMovieByIMDBrating(String sortby) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.SortByIMDBrating", Movie.class);		
		List<Movie> movies = query.getResultList();
		if (movies.size() > 0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> sortMovieByYear(String sortby) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.SortByYear", Movie.class);		
		List<Movie> movies = query.getResultList();
		if (movies.size() > 0) {
			return movies;
		} else {
			return null;
		}
	}

	@Override
	public List<Movie> sortMovieByIMDBvotes(String sortby) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.SortByIMDBvotes", Movie.class);		
		List<Movie> movies = query.getResultList();
		if (movies.size() > 0) {
			return movies;
		} else {
			return null;
		}
	}
	@Override
	public Movie findMovieById(String movieId) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.findMovieById", Movie.class);
		query.setParameter("movieId", movieId);
		List<Movie> movies = query.getResultList();
		if (movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Movie createMovie(Movie movie) {
		mov.persist(movie);
		return movie;
	}

	@Override
	public Movie findMovieByTitle(String title) {
		TypedQuery<Movie> query = mov.createNamedQuery("Movie.findMovieByTitle", Movie.class);
		query.setParameter("mTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies.size() == 1) {
			return movies.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Movie findMovie(String movieId) {
		
		return mov.find(Movie.class, movieId);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		mov.merge(movie);
		return movie;
	}

	@Override
	public void deleteMovie(Movie existing) {
		mov.remove(existing);		
	}



}
