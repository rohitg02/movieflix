package rohit.movie_flix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
@NamedQueries({@NamedQuery(name = "Movie.findMovieByTitle", query = "SELECT m from Movie m where m.Title=:mTitle"),
		@NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m ORDER BY m.imdbRating"),
		@NamedQuery(name = "Movie.findMovieById", query = "SELECT m from Movie m where m.id=:movieId"),
		@NamedQuery(name = "Movie.filterByType", query = "SELECT m from Movie m where m.Type=:filterbytype"),
		@NamedQuery(name = "Movie.filterByYear", query = "SELECT m from Movie m where m.Year=:filterbyyear"),
		@NamedQuery(name = "Movie.filterByGenre", query = "SELECT m from Movie m where m.Genre=:filterbygenre"),
		@NamedQuery(name = "Movie.SortByIMDBrating", query = "SELECT m from Movie m ORDER BY m.imdbRating"),
		@NamedQuery(name = "Movie.SortByYear", query = "SELECT m from Movie m ORDER BY m.Year"),
		@NamedQuery(name = "Movie.SortByIMDBvotes", query = "SELECT m from Movie m ORDER BY m.imdbVotes")
})
public class Movie {
	@Id
	private String id;
	
	@JsonProperty("Title")
	@Column(unique = true)
	private String Title;
	
	@JsonProperty("Year")
	private int Year;
	
	@JsonProperty("Rated")
	private String Rated;
	
	@JsonProperty("Released")
	private String Released;
	
	@JsonProperty("Runtime")
	private String Runtime;
	
	@JsonProperty("Genre")
	private String Genre;
	
	@JsonProperty("Director")
	private String Director;
	
	@JsonProperty("Writer")
	private String Writer;
	
	@JsonProperty("Actors")
	private String Actors;
	
	@JsonProperty("Plot")
	private String Plot;
	
	@JsonProperty("Language")
	private String Language;
	
	@JsonProperty("Country")
	private String Country;
	
	@JsonProperty("Awards")
	private String Awards;
	
	@JsonProperty("Poster")
	private String Poster;
	
	@JsonProperty("Metascore")
	private int Metascore;
	
	@JsonProperty("imdbRating")
	private float imdbRating;
	
	@JsonProperty("imdbVotes")
	private int imdbVotes;
	
	@JsonProperty("imdbID")
	private String imdbID;
	
	@JsonProperty("Type")
	private String Type;
	
	public Movie(){
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		Title = title;
	}
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	
	public String getRated() {
		return Rated;
	}
	
	public void setRated(String rated) {
		Rated = rated;
	}
	
	public String getReleased() {
		return Released;
	}
	
	public void setReleased(String released) {
		Released = released;
	}
	
	public String getRuntime() {
		return Runtime;
	}
	
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	
	public String getGenre() {
		return Genre;
	}
	
	public void setGenre(String genre) {
		Genre = genre;
	}
	
	public String getDirector() {
		return Director;
	}
	
	public void setDirector(String director) {
		Director = director;
	}
	
	public String getWriter() {
		return Writer;
	}
	
	public void setWriter(String writer) {
		Writer = writer;
	}
	
	public String getActors() {
		return Actors;
	}
	
	public void setActors(String actors) {
		Actors = actors;
	}
	
	public String getPlot() {
		return Plot;
	}
	
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	public String getLanguage() {
		return Language;
	}
	
	public void setLanguage(String language) {
		Language = language;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public void setCountry(String country) {
		Country = country;
	}
	
	public String getAwards() {
		return Awards;
	}
	
	public void setAwards(String awards) {
		Awards = awards;
	}
	
	public String getPoster() {
		return Poster;
	}
	
	public void setPoster(String poster) {
		Poster = poster;
	}
	
	public int getMetascore() {
		return Metascore;
	}
	
	public void setMetascore(int metascore) {
		Metascore = metascore;
	}
	
	public float getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public int getImdbVotes() {
		return imdbVotes;
	}
	
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}
	
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
    
}
