package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "@getApi",

        features = {"src/test/resources/Feature/getApi.feature"},
        glue = {"stepDefination"},   monochrome = true,
        dryRun = false,
        plugin= {
        "pretty","html:build/reports/Feature.html"
        }
)
@Test
public class apiRunner extends AbstractTestNGCucumberTests{
}