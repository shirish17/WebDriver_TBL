package com.spe.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SPERunner.SPERunnerTest;
import com.spe.common.utils.LoggerActions;
import com.spe.master.pagecomponents.SPEMasterPage;
import com.spe.master.pagecomponents.SPEPageGenerator;

import junit.framework.Assert;

public class ReusableActions extends SPEMasterPage
{
	WebDriver driver;
	public static String fsep = System.getProperty("file.separator");
	SPERunnerTest sperunnertest;
	SPEPageGenerator pageGenerator;
	static LoggerActions logAction = new LoggerActions();
	public static int timeoutsec=60;
	public static int polltime=3;
	
	public ReusableActions (WebDriver driver)
	{
		super(driver);
	}
	
	public static boolean waitForElementToBeVisible(WebDriver driver, WebElement element, String elementName)
	{
		FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver);
		wait.withTimeout(timeoutsec, TimeUnit.SECONDS);		
		wait.pollingEvery(polltime,TimeUnit.SECONDS);
		wait.ignoring(TimeoutException.class);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(new ExpectedCondition<Boolean>()
			{
			public Boolean apply(WebDriver driver)
			{
				try
				{
					return (element.isDisplayed());
				}
				catch(NoSuchElementException e)
				{
					return true;
				}
				catch (StaleElementReferenceException e)
				{
					return true;
				}
				catch (Exception exception)
				{
					exception.printStackTrace();
					return false;
				}
							
			}
			}
		);
		
	}
	public static String getAttributeofElement(WebDriver driver,WebElement element, String attributename) 
	{
		String strAttributeValue="";
		try
		{
			if(attributename.equalsIgnoreCase("getText"))
			{
				strAttributeValue=element.getText().trim();
			}			
			else
			{
				strAttributeValue=element.getAttribute(attributename).trim();
			}			
			if(strAttributeValue.isEmpty())
			{
				strAttributeValue="";
			}
		}
		catch (org.openqa.selenium.NoSuchElementException noSuchElement)
		{
			String strExcptText="";
			strExcptText=noSuchElement.getMessage();			
		}
		catch (Exception E)
		{
			E.printStackTrace();
		}
		return strAttributeValue;
	}
	
	public static void buttonClick(WebDriver driver, WebElement element, String msg)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				element.click();
			}
		}
		catch (org.openqa.selenium.ElementNotVisibleException elmNotVisible)
		{
			logAction.error("ElementNotVisibleException: In 'ReusableActions' class --> 'buttonClick', error details: "+elmNotVisible.getMessage());
			elmNotVisible.printStackTrace();
		}
		catch (org.openqa.selenium.NoSuchElementException noSuchElement)
		{
			logAction.error("NoSuchElementException: In 'ReusableActions' class --> 'buttonClick', error details: "+noSuchElement.getMessage());
			noSuchElement.printStackTrace();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			logAction.error("Exception: In 'ReusableActions' class --> 'buttonClick', error details: "+exception.getMessage());
		}
	}
	public static boolean waitForElementToBeClickable(WebDriver driver, WebElement element, String elementName)
	{
		boolean blnStatus=false;
		try
		{
			WebDriverWait wait =new WebDriverWait(driver, timeoutsec);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			blnStatus=true;
		}
		catch (org.openqa.selenium.ElementNotVisibleException elmNotVisible)
		{
			logAction.error("ElementNotVisibleException: In 'ReusableActions' class --> 'waitForElementToBeClickable', error details: "+elmNotVisible.getMessage());
			elmNotVisible.printStackTrace();
		}
		catch (org.openqa.selenium.NoSuchElementException noSuchElement)
		{
			logAction.error("NoSuchElementException: In 'ReusableActions' class --> 'waitForElementToBeClickable', error details: "+noSuchElement.getMessage());
			noSuchElement.printStackTrace();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			logAction.error("Exception: In 'ReusableActions' class --> 'waitForElementToBeClickable', error details: "+exception.getMessage());
		}
		return blnStatus;
	}
	
	public static void inputText(WebDriver driver, WebElement element , CharSequence value, String elementName)
	{
		try
		{
			element.clear();
			element.sendKeys(value);
		}
		catch(org.openqa.selenium.NoSuchElementException nex)
		{
			logAction.error("Exception: NoSuchElementException in 'inputText' method for ''" +elementName +"and it has error:'"+nex.getMessage()+".");
			nex.printStackTrace();
		}
		catch (Exception exception)
		{
			//strMsg="Failed : In 'inputText' method, for element '" +elementName +"'not able to enter text.";
			logAction.error("Exception: in 'inputText' method for ''" +elementName +"and it has error:'"+exception.getMessage()+".");
			exception.printStackTrace();
		}
	}	
	
	public  static void linkClick(WebDriver driver, WebElement element, String elementName)
	{
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				element.click();
			}
		}
		catch(org.openqa.selenium.NoSuchElementException nex)
		{
			logAction.error("Exception: NoSuchElementException in 'mouseHover' method for ''" +elementName +"and it has error:'"+nex.getMessage()+".");
			nex.printStackTrace();
		}
		catch (Exception exception)
		{
			//strMsg="Failed : In 'inputText' method, for element '" +elementName +"'not able to enter text.";
			logAction.error("Exception: in 'mouseHover' method for ''" +elementName +"and it has error:'"+exception.getMessage()+".");
			exception.printStackTrace();
		}
	}		
		
}
