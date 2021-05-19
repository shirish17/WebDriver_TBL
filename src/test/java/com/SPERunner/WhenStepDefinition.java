package com.SPERunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.spe.FrontEndPages.TBLDownloadProducts;
import com.spe.FrontEndPages.TBLHomePage;
import com.spe.common.utils.LoggerActions;
import com.spe.master.pagecomponents.SPEPageGenerator;

import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class WhenStepDefinition 
{
	WebDriver driver;
	public static String fsep = System.getProperty("file.separator");
	public static String browserName="";
	SPERunnerTest sperunnertest;
	SPEPageGenerator pageGenerator;
	LoggerActions logAction = new LoggerActions();
	public WhenStepDefinition (SPERunnerTest sperunnertest)
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
	@When("^Customer login to system by providing \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_login_by_providing_email_password(String strEmail, String strPassword) throws Throwable
	{
		pageGenerator.GetInstance(TBLDownloadProducts.class).download_Products_SKU_Details(strEmail, strPassword);
	}
}
