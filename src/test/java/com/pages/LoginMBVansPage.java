package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMBVansPage {

	 WebDriver driver;
	By hero_image =By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[1]/picture/img");
	
	By hero_title=By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[2]/section/div/h1");
	
	By hero_copy=By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[2]/section/div/p[1]");
	
	By details_title=By.xpath("//*[@id=\"mercedes-benz-vans-certified-pre-owned\"]/div[1]/div/header/h2");
	
	By details_copy=By.xpath("//*[@id=\"mercedes-benz-vans-certified-pre-owned\"]/div[1]/div/header/p");
	
	By details_image=By.xpath("//*[@id=\"mercedes-benz-vans-certified-pre-owned\"]/div[2]/section/div/div/div/div/div[1]/ul/li/div[2]/picture/img");
	
	By eligibility_title_text=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[1]/div/header/h2");
	
	By eligibility_image1=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[1]/div/div[1]/picture/img");
	
	By eligibility_image2=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[2]/div/div[1]/picture/img");
	
	By eligibility_description1=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[1]/div/div[2]");
	
	By eligibility_description2=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[2]/div/div[2]");
	
	By exclusive_offer_button=By.xpath("");
	
	By exclusive_offer_title=By.xpath("//*[@id=\"exclusive-offer\"]/div[1]/div/header/h2");
	
	By exclusive_offer_image=By.xpath("//*[@id=\"exclusive-offer\"]/div[2]/section/div[1]/div/div/div/div[1]/ul/li/div[2]/picture/img");
	
	By exclusive_offer_copy=By.xpath("//*[@id=\"exclusive-offer\"]/div[2]/section/div[2]/div/div");
	
	By faq_button=By.xpath("");
	
	By faq_title=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[1]/div/header/h2");
	
	By faq_description=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[2]/div/div");
	
	By find_dealer_image=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[3]/section/div[1]/div/div/div/div[1]/ul/li/div[2]/picture/img");
	
	By find_dealer_button=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[3]/section/div[2]/div/a");
	
	By find_dealer_title=By.xpath("//*[@id=\"main-content\"]");
	
	By find_dealer_copy=By.xpath("");
	
	public LoginMBVansPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Get_HeroImage(WebDriver driver)
	{
		return driver.findElement(hero_image);
	}
	
	public WebElement Get_Hero_title(WebDriver driver)
	{
		 return driver.findElement(hero_title);
	}
	
	public WebElement Get_Hero_copy(WebDriver driver)
	{
		 return driver.findElement(hero_copy);
	}
	
	public WebElement ClickOnExclusive_Offer(WebDriver driver)
	{
		 return driver.findElement(exclusive_offer_button);
	}
	
	public WebElement Get_Exclusive_Offer_title(WebDriver driver)
	{
		 return driver.findElement(exclusive_offer_title);
	}
	
	public WebElement Get_Exclusive_Offer_image(WebDriver driver)
	{
		 return driver.findElement(exclusive_offer_image);
	}
	
	public WebElement Get_Exclusive_Offer_copy(WebDriver driver)
	{
		 return driver.findElement(exclusive_offer_copy);
	}
	
	public WebElement ClickOn_FAQ_button(WebDriver driver)
	{
		 return driver.findElement(faq_button);
	}
	
	public WebElement GetFAQTitle(WebDriver driver)
	{
		return driver.findElement(faq_title);
	}
	
	public WebElement GetFAQDescription(WebDriver driver)
	{
		return driver.findElement(faq_description);
	}
	
	
	public WebElement Get_Details_title(WebDriver driver)
	{
		return driver.findElement(details_title);
	}
	
	public WebElement Get_Details_Image(WebDriver driver)
	{
		return driver.findElement(details_image);
	}
	
	public WebElement Get_Details_copy(WebDriver driver)
	{
		return driver.findElement(details_copy);
	}
	
	public WebElement GetEligibilityTitle(WebDriver driver)
	{
		return driver.findElement(eligibility_title_text);
	}
	
	public WebElement GetEligibility_Image1(WebDriver driver)
	{
		return driver.findElement(eligibility_image1);
	}
	
	public WebElement GetEligibility_Image2(WebDriver driver)
	{
		return driver.findElement(eligibility_image2);
	}
	
	public WebElement GetEligibilityCopy1(WebDriver driver)
	{
		return driver.findElement(eligibility_description1);
	}
	
	public WebElement GetEligibilityCopy2(WebDriver driver)
	{
		return driver.findElement(eligibility_description2);
	}
	
	
	public WebElement GetFindDelaerImage(WebDriver driver)
	{
			return driver.findElement(find_dealer_image);
	}	
	
	public WebElement ClickOn_FindDealer(WebDriver driver)
	{
		return driver.findElement(find_dealer_button);
	
	}
	
	public WebElement GetFind_Dealer_Title(WebDriver driver)
	{
		return driver.findElement(find_dealer_title);
	}
	
	public WebElement GetFind_Dealer_Copy(WebDriver driver)
	{
		return driver.findElement(find_dealer_copy);
	}
	
	
}
