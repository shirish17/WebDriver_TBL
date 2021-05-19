package com.spe.FrontEndPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.SPERunner.SPERunnerTest;
import com.spe.master.pagecomponents.SPEMasterPage;

import junit.framework.Assert;

public class TBLHomePage extends SPEMasterPage
{
	String strCurrentBrowser="";
	public TBLHomePage(WebDriver driver)
	{
		super(driver);
		strCurrentBrowser=SPERunnerTest.getCurrentBrowser();
		
	}
	//========================== Object Repository ==============
	//Search box
	@FindBy(how=How.NAME,using="q")
	public WebElement input_SearchBox;
	//============================================================
	public void searchProduct(String searchString)
	{
		try
		{
			switch (strCurrentBrowser)
			{
				case "AndroidBrowser":
					break;
				case "iOSBrowser":
				case "chrome":			
				case "firefox":
				case "Internet Explorer":
					input_SearchBox.sendKeys(searchString);
					input_SearchBox.sendKeys(Keys.ENTER);
					break;
				default:
					Assert.assertFalse("Browser initial failed, as no browser type defined in TestNG.xml file.", false);
			}
			
		}
		catch (Exception excpetion)
		{
			excpetion.printStackTrace();
		}
	}

}
