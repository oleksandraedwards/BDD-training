package feature.movie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycompany.app.movie.Catalog;
import com.mycompany.app.movie.Movie;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MovieSearchSteps {
	Catalog catalog = new Catalog();
	List<Movie> resultList = new ArrayList<>();

	// Given a movie with the title 'Out of Africa', produced by 'Universal Pictures', released 20 December 1985

	@Given("a movie with the title (.+), produced by (.+), released (.+)")
	public void addAnotherMovie(String movieName, String producedBy, String newDate) throws ParseException {
		Date date1=new SimpleDateFormat("dd MMMM yyyy").parse(newDate);  
		Movie movie = new Movie (movieName, producedBy, date1);
		catalog.addMovie(movie);
	}

	@When("the customer searches for movies with the keyword (.*)")
	public void setSearchParameters(String movieName) {
		resultList = catalog.findMovieByKeyword(movieName);
	}
	
	@When("the customer searches for the third movie" )
	public void setOrdinalSearchParameters() {
	resultList = catalog .findMovieByOrder(2);
	}
	
	@Then("(\\d+) movies? should have been found" )
	public void verifyQuantityOfMoviesFound(int quanity) {
		assertThat(resultList.size(), equalTo(quanity));
	}
	
	@Then("the movie title should be (.+)" )
	public void verifyMovieTitle(String movieName) {
	assertThat(resultList.get(0).getTitle(), equalTo(movieName));
	}
	
	@Then("the catalog should have (\\d+) total movies" )
	public void verifyCatalogSize(int quanity) {
	assertThat(catalog.getSize (), equalTo(quanity));
	}

}