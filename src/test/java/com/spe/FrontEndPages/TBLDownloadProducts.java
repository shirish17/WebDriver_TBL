package com.spe.FrontEndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.SPERunner.SPERunnerTest;
import com.spe.Utils.ReusableActions;
import com.spe.master.pagecomponents.SPEMasterPage;

public class TBLDownloadProducts extends SPEMasterPage
{
	String strCurrentBrowser="";
	public TBLDownloadProducts(WebDriver driver) 
	{
		super(driver);
		strCurrentBrowser=SPERunnerTest.getCurrentBrowser();
	}
	//========================== Object Repository ==============
	
	//Email field on login page
	@FindBy(how=How.XPATH,using="//input[@name='TPL_username']")
	public WebElement input_Email;
	
	//Password Field
	@FindBy(how=How.XPATH,using="//input[@name='TPL_password']")
	public WebElement input_Password;
	
	//Login button
	@FindBy(how=How.XPATH,using="//button[contains(text(),'SIGN IN')]")
	public WebElement btn_Submit;
	
	//Auto topup popup on home page
	@FindBy(how=How.XPATH,using="//i[@class='next-icon next-icon-close next-medium next-dialog-close-icon']")
	public WebElement btn_PopupCloseBtn;
	
	//Home Page 'Business Advisor' link on left menu
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Business Advisor')]")
	public WebElement link_BusinessAdvisor;
	
	//Product link on top menu
	@FindBy(how=How.LINK_TEXT,using="Product")
	public WebElement link_Product;
	
	//Performance link in Product section
	@FindBy(how=How.LINK_TEXT,using="Performance")
	public WebElement link_Performance;
	
	//Export link on page
	@FindBy(how=How.XPATH,using="//div[@class='_3bs9waax']")
	public WebElement link_Export_Option;
	
	//OK button on Export popup
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Ok')]")
	public WebElement btn_Ok_onExportPopup;
	
	//SKU Radio button
	@FindBy(how=How.XPATH,using="//span[contains(text(),'SKU')]")
	public WebElement radioBtn_SKU;
	
	//Settings icon on right side of page
	@FindBy(how=How.XPATH,using="//div[@class='profile-icon aplus-auto-exp aplus-auto-clk']")
	public WebElement btn_Profile;
	
	//Logout link
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Log Out')]")
	public WebElement link_Logout;
	
	//Right side "side bar" arrow
	@FindBy(how=How.XPATH,using="//i[@class='next-icon next-icon-arrow-left next-small layout-icon layout-icon-arrow-left']")
	public WebElement arrow_SideBar;
	
	//=====================================================
	public void download_Products_SKU_Details(String strEmail, String strPassword)
	{
		boolean blnStatus =false;
		try
		{
			Thread.sleep(5000);
			ReusableActions.waitForElementToBeVisible(driver, input_Email, "Email field");
			ReusableActions.inputText(driver, input_Email, strEmail, "Entered email");
			
			ReusableActions.waitForElementToBeVisible(driver, input_Password, "Password field");
			ReusableActions.inputText(driver, input_Password, strPassword, "Entered password");
			
			ReusableActions.buttonClick(driver, btn_Submit, "Submit button clicked");
			Thread.sleep(5000);
			blnStatus=ReusableActions.waitForElementToBeVisible(driver, btn_PopupCloseBtn, "Autotopup Popup");
			if(blnStatus)
			{
				Thread.sleep(5000);
				ReusableActions.linkClick(driver, btn_PopupCloseBtn, "Popup close");
			}
			ReusableActions.waitForElementToBeVisible(driver, link_BusinessAdvisor, "Business Advisor link");
			ReusableActions.linkClick(driver, link_BusinessAdvisor, "Business Advisor clicked");
			
			Thread.sleep(2000);
			ReusableActions.waitForElementToBeClickable(driver, link_Product, "Product link on Top");
			ReusableActions.linkClick(driver, link_Product, "Product link clicked");
			
			Thread.sleep(2000);
			ReusableActions.waitForElementToBeClickable(driver, link_Performance, "Performance link on Top");
			ReusableActions.linkClick(driver, link_Performance, "Performance link clicked");
			
			ReusableActions.waitForElementToBeClickable(driver, link_Export_Option, "Export option");
			ReusableActions.linkClick(driver, link_Export_Option, "Export option");
			
			Thread.sleep(2000);
			ReusableActions.waitForElementToBeClickable(driver, btn_Ok_onExportPopup, "Ok button on Export Pooup");
			ReusableActions.linkClick(driver, btn_Ok_onExportPopup, "OK button clicked");
			
			Thread.sleep(2000);
			ReusableActions.waitForElementToBeClickable(driver, radioBtn_SKU, "SKU radio button");
			ReusableActions.linkClick(driver, radioBtn_SKU, "SKU radio button clicked");
			
			ReusableActions.waitForElementToBeClickable(driver, link_Export_Option, "Export option");
			ReusableActions.linkClick(driver, link_Export_Option, "Export option");
			
			ReusableActions.waitForElementToBeClickable(driver, btn_Ok_onExportPopup, "Ok button on Export Pooup");
			ReusableActions.linkClick(driver, btn_Ok_onExportPopup, "OK button clicked");
			
			Thread.sleep(2000);
			ReusableActions.waitForElementToBeClickable(driver, arrow_SideBar, "Side bar arrow");
			ReusableActions.linkClick(driver, arrow_SideBar, "Side bar Arrow");
			
			ReusableActions.waitForElementToBeClickable(driver, btn_Profile, "Profile button");
			ReusableActions.linkClick(driver, btn_Profile, "Profile button clicked");
			
			ReusableActions.waitForElementToBeClickable(driver, link_Logout, "Profile button");
			ReusableActions.linkClick(driver, link_Logout, "Logout clicked");			
		}
		catch (Exception exception)
		{
			exception.printStackTrace();			
		}
	}
}
