package feature.movie;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions ( plugin = {"html:target/report"})
public class MovieSearchTest {
}