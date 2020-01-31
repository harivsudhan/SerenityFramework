package com.taf.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features= {"src/test/resources/com/taf/features/brandstory.feature"},glue = {
"com.taf.steps"})
public class BrandStoryTest {}
