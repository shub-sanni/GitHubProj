package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
	glue = { "steps", "hooks" }, 
	plugin = { "pretty",
			"html:target/cucumber-reports.html",
			"json:target/cucumber.json"},
	tags="@login",
	monochrome = true
	)
public class TestRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel= true)
public Object[][] scenarios(){
	return super.scenarios();
}
}
/*	Our TestRunner extends AbstractTestNGCucumberTests, 
	which provides the integration between Cucumber and TestNG.
	We override the scenarios() method because we want to enable
	parallel execution of Cucumber scenarios.The @DataProvider(parallel = true) 
	tells TestNG that the scenarios returned by this DataProvider can be executed in parallel.
 */