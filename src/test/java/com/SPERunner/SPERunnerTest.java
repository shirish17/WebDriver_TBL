package com.SPERunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.spe.common.utils.WebDriverEventListner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources/features/", format = { "pretty", "html:target/html",
		"json:target/json/output.json" }, tags = { "@Orders"})
public class SPERunnerTest extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String fsep = System.getProperty("file.separator");
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListner eventListener;
	public static String currentBrowser;
	public static String getCurrentBrowser() 
	{
		return currentBrowser;
	}
	public static void setCurrentBrowser(String currentBrowser) 
	{
		SPERunnerTest.currentBrowser = currentBrowser;
	}
	
	@Parameters({ "browser" })
	@BeforeTest
	public void parameterTest(@Optional String browser) throws MalformedURLException
	{
		setCurrentBrowser(browser);
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + fsep + "src" + fsep + "test"
					+ fsep + "resources" + fsep + "browserDrivers" + fsep + "geckodriver.exe"));

			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + fsep + "src" + fsep + "test"
					+ fsep + "resources" + fsep + "browserDrivers" + fsep + "chromedriver.exe"));
			//driver = new ChromeDriver();
			//===========
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", "D:\\Lazada");
			ChromeOptions options = new ChromeOptions();			
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			//============
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir") + fsep + "src" + fsep + "test"
					+ fsep + "resources" + fsep + "browserDrivers" + fsep + "IEDriverServer.exe"));

			driver = new InternetExplorerDriver();

		}
		else // if nothing set then open chrome
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + fsep + "src" + fsep + "test"
					+ fsep + "resources" + fsep + "chromedriver.exe"));
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public WebDriver getDriver()
	{
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebDriverEventListner(driver);
		e_driver.register(eventListener);
		return e_driver;
	}
	@AfterClass
	public void closeDriver() throws InterruptedException, IOException 
	{
		driver.manage().deleteAllCookies();
		e_driver.quit();
	}
	
}
