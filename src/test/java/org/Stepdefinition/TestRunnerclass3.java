package org.Stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",glue = "org.Stepdefinition",
monochrome = true, 
dryRun = false,
strict = true,

snippets=SnippetType.CAMELCASE,
plugin = {"html:Report","junit:Report\\junitreport.xml"}

)


public class TestRunnerclass3 {
	

}
