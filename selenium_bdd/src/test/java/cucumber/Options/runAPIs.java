package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin="json:target/jsonReports/cucumber-report.json" ,features = "src/test/java/features" ,glue={"stepDefinitions"} )
public class runAPIs extends AbstractTestNGCucumberTests{
	

}
