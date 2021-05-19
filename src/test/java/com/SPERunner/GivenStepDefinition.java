package com.SPERunner;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.spe.common.utils.LoggerActions;
import com.spe.master.pagecomponents.SPEPageGenerator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import junit.framework.Assert;

public class GivenStepDefinition 
{
	WebDriver driver;
	public static String fsep = System.getProperty("file.separator");
	public static String browserName="";
	SPERunnerTest sperunnertest;
	SPEPageGenerator pageGenerator;
	LoggerActions logAction = new LoggerActions();
	
	public GivenStepDefinition(SPERunnerTest sperunnertest) 
	{
		this.sperunnertest = sperunnertest;
	}
	@Before
	public void setup () throws IOException
	{
		driver=sperunnertest.getDriver();
		pageGenerator=new SPEPageGenerator(driver);
		browserName=sperunnertest.getCurrentBrowser();
	}
	@Given("^Customer opens the homepage for the \"(.*?)\"$")
	public void Open_homepage(String URL) throws Throwable
	{
		driver.manage().deleteAllCookies();
		if(!URL.isEmpty())
		{
			driver.get(URL);
		}
		else
		{
			Assert.assertFalse("URL value is empty, please provide URL value in feature file.", false);
		}
		
	}
	
	@After
	public void endScenario(Scenario scenario) throws IOException 
	{
		try 
		{
			if (scenario.isFailed()) {
				scenario.write("Scenario: "+scenario.getName()+",is failed for the browser: "+browserName);
				if (!browserName.equalsIgnoreCase("htmlunit")) {					
					final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
					scenario.embed(screenshot, "image/png");
					}
			}
		} catch (Exception e) {
			logAction.error(e.getMessage());
		}

	}
}
