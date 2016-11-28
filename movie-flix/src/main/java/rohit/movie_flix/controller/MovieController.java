package rohit.movie_flix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rohit.movie_flix.entity.Movie;
import rohit.movie_flix.entity.User;
import rohit.movie_flix.service.MovieService;


@RestController
@RequestMapping(value = "/{role}/{userid}/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
		
	@Autowired
	private MovieService movieservice;
	
		@RequestMapping(method = RequestMethod.GET)
		public List<Movie> findAll() {
			return movieservice.findAll();
		}
		
		//Find movie by id
		@RequestMapping(method = RequestMethod.GET, value = "{id}")
		public Movie findMovie(@PathVariable("id") String movieId){
			return movieservice.findMovieById(movieId);
		}
		
		//Filter movie list
		@RequestMapping(method = RequestMethod.GET, value = "filterby/{filterBy}/{filterValue}")
		public List<Movie> filterMovieBy(@PathVariable("filterBy") String filterby, @PathVariable("filterValue") String filterbyvalue){
			return movieservice.filterMovieBy(filterby, filterbyvalue);
		}
		
		//Sort a movie list
		@RequestMapping(method = RequestMethod.GET, value = "sortby/{sortBy}")
		public List<Movie> sortMovieBy(@PathVariable("sortBy") String sortby){
			return movieservice.sortMovieBy(sortby);
		}
		
		//Add a new movie
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movie createMovie(@RequestBody Movie movie, @PathVariable("role") String role){
			if(role.equals("admin")) {
				return movieservice.createMovie(movie);
			} else {
					return null;
			}
		}
		
		//Update existing movie
		@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public Movie updateMovie(@RequestBody Movie movie, @PathVariable("role") String role, @PathVariable("id") String movieId){
			if(role.equals("admin")) {
				return movieservice.updateMovie(movieId, movie);
			} else {
					return null;
			}
		}
		
		//Delete a movie
		@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
		public void deleteMovie(@PathVariable("role") String role, @PathVariable("id") String movieId){
			if(role.equals("admin")) {
				movieservice.deleteMovie(movieId);
			} 
		}

}
