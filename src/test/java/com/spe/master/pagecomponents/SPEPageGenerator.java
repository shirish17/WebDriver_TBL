package com.spe.master.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SPEPageGenerator 
{
	protected WebDriver driver;
	
	public SPEPageGenerator (WebDriver driver)
	{
		this.driver=driver;
	}
	public  <TPage extends SPEMasterPage> TPage GetInstance (Class<TPage> pageClass)throws Exception
	{
        return PageFactory.initElements(driver,  pageClass);

	}
}
