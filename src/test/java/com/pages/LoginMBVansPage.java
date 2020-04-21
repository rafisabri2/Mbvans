package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMBVansPage {

	 WebDriver driver;
	By hero_image =By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[1]/picture/img");
	
	By hero_text=By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[2]/section/div/h1");
	
	By details_heading=By.xpath("//*[@id=\"mercedes-benz-vans-certified-pre-owned\"]/div[1]/div/header/p");
	
	By details_image=By.xpath("//*[@id=\"mercedes-benz-vans-certified-pre-owned\"]/div[2]/section/div/div/div/div/div[1]/ul/li/div[2]/picture/img");
	
	By eligibility_header_text=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[1]/div/header/h2");
	
	By eligibility_image_left=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[1]/div/div[1]/picture/img");
	
	By eligibility_image_right=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[2]/div/div[1]/picture/img");
	
	By eligibility_description_Left=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[1]/div/div[2]");
	
	By eligibility_description_Right=By.xpath("//*[@id=\"cpo-vehicle-eligibility\"]/div[2]/section/div/div[2]/div/div[2]");
	
	By faq_header=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[1]/div/header/h2");
	
	By faq_description=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[2]/div/div");
	
	By find_dealer_image=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[3]/section/div[1]/div/div/div/div[1]/ul/li/div[2]/picture/img");
	
	By find_dealer_button=By.xpath("//*[@id=\"frequently-asked-questions\"]/div[3]/section/div[2]/div/a");
	
	
	public LoginMBVansPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Click_on_HeroImage(WebDriver driver)
	{
		return driver.findElement(hero_image);
	}
	
	public WebElement Get_Hero_text(WebDriver driver)
	{
		 return driver.findElement(hero_text);
	}
	
	public WebElement Get_Details_text(WebDriver driver)
	{
		return driver.findElement(details_heading);
	}
	
	public WebElement Get_Details_Image(WebDriver driver)
	{
		return driver.findElement(details_image);
	}
	
	public WebElement GetEligibilityHeader(WebDriver driver)
	{
		return driver.findElement(eligibility_header_text);
	}
	
	public WebElement GetEligibility_Image_Left(WebDriver driver)
	{
		return driver.findElement(eligibility_image_left);
	}
	
	public WebElement GetEligibility_Image_Right(WebDriver driver)
	{
		return driver.findElement(eligibility_image_right);
	}
	
	public WebElement GetEligibilityDescription1(WebDriver driver)
	{
		return driver.findElement(eligibility_description_Left);
	}
	
	public WebElement GetEligibilityDescription2(WebDriver driver)
	{
		return driver.findElement(eligibility_description_Right);
	}
	
	public WebElement GetFAQHeader(WebDriver driver)
	{
		return driver.findElement(faq_header);
	}
	
	public WebElement GetFAQDescription(WebDriver driver)
	{
		return driver.findElement(faq_description);
	}
	
	public WebElement GetFindDelaerImage(WebDriver driver)
	{
			return driver.findElement(find_dealer_image);
	}	
	
	public WebElement ClickOn_FindDealer(WebDriver driver)
	{
		return driver.findElement(find_dealer_button);
	}
	
	
}
