package com.spe.common.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverEventListner extends AbstractWebDriverEventListener
{
	WebDriver driver;
	String strLogfileName="";
	String strLogMessage="";
	public static String fsep=System.getProperty("file.separator");
	LoggerActions logAction = new LoggerActions();
	public WebDriverEventListner (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		strLogfileName=System.getProperty(System.getProperty("user.dir")+fsep+"src" + fsep+ "test" +fsep + "resources"+ fsep + "Logs"+fsep+"log4j-application.log");
	}
	public void beforeNavigateTo(java.lang.String url,WebDriver driver)
	{
		strLogMessage="Webdriver's beforeNavigateTo method is called for the URL: "+url+".";
		logAction.info(strLogMessage);
	}
	public void afterNavigateTo(java.lang.String url,WebDriver driver)
	{
		strLogMessage="Webdriver's afterNavigateTo method is called for the URL: "+url+".";
		logAction.info(strLogMessage);
	}
	public void beforeClickOn(WebElement element, WebDriver driver)
	{
		strLogMessage="Webdriver's 'beforeClickOn' method is called for the element: '"+element.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void afterClickOn(WebElement element, WebDriver driver)
	{
		strLogMessage="Webdriver's 'afterClickOn' method is called for the element: '"+element.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void afterFindBy(By by,WebElement element,WebDriver driver)
	{
		strLogMessage="Webdriver's 'afterFindBy' method is and found element by: '"+by.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void beforeFindBy(By by,WebElement element,WebDriver driver)
	{
		strLogMessage="Webdriver's 'beforeFindBy' method is called and trying to find element by: '"+by.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void beforeChangeValueOf(WebElement element, WebDriver driver) 
	{
		strLogMessage="Webdriver's 'beforeChangeValueOf' method is called for the element: '"+element.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver) 
	{
		strLogMessage="Webdriver's 'afterChangeValueOf' method is called for the element and element value changed to: '"+element.toString()+"'.";
		logAction.info(strLogMessage);
	}
	public void beforeNavigateBack(WebDriver driver) 
	{
		strLogMessage="Webdriver's 'beforeNavigateBack' method is called and trying to navigate back to previous page.";
		logAction.info(strLogMessage);
	}
	public void afterNavigateBack(WebDriver driver) 
	{
		strLogMessage="Webdriver's 'beforeNavigateBack' method is called and navigated back to previous page.";
		logAction.info(strLogMessage);
	}
	public void beforeNavigateForward(WebDriver driver)
	{
		strLogMessage="Webdriver's 'beforeNavigateForward' method is called and navigated forward to next page.";
		logAction.info(strLogMessage);
	}
	public void afterNavigateForward(WebDriver driver) 
	{
		strLogMessage="Webdriver's 'afterNavigateForward' method is called and navigated forward to next page.";
		logAction.info(strLogMessage);
	}
	public void onException(Throwable error, WebDriver driver) 
	{
		strLogMessage="Webdriver's 'afterNavigateForward' method is called and navigated forward to next page.";		
		logAction.error(error.getMessage());
		
	}
		
}
