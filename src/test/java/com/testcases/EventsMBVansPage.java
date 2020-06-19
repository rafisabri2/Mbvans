package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventsMBVansPage {

	 WebDriver driver;
	
	
	By events_button=By.xpath("//*[@id=\"footer-accordionItem3\"]/ul/li[2]/a");
	
	By events_header_title=By.xpath("//*[@id=\"content\"]/div[2]/div[1]/section/div[2]/section/div/h1");
	
	By events_header_image=By.xpath("//*[@id=\"content\"]/div[2]/div[1]/section/div[1]/picture/img");
	
	By events_header_copy=By.xpath("//*[@id=\"content\"]/div[2]/div[1]/section/div[2]/section/div/p[1]");
	
	By header2_title= By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/caption");
	
	By title1=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[1]/th");
	
	By title2=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[2]/th");
	
	By copy1=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[1]/td[1]");
	
	By copy2=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[2]/td[1]");
	
	By link1=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[1]/td[2]/a");
	
	By link2=By.xpath("//*[@id=\"content\"]/div[2]/div[3]/table/tbody/tr[2]/td[2]/a");
	
	public EventsMBVansPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Click_OnEvents_button(WebDriver driver)
	{
		
		return driver.findElement(events_button);
	}
	
	public WebElement Get_Section1_Header(WebDriver driver)
	{
		return driver.findElement(events_header_title);
	}
	
	public WebElement Get_Events_Image(WebDriver driver)
	{
		 return driver.findElement(events_header_image);
	}
	
	public WebElement Get_Events_copy(WebDriver driver)
	{
		 return driver.findElement(events_header_copy);
	}
	
	public WebElement Get_Section2_Header(WebDriver driver)
	{
		 return driver.findElement(header2_title);
	}
	
	public WebElement Get_Events_title1(WebDriver driver)
	{
		 return driver.findElement(title1);
	}
	
	public WebElement Get_Events_title2(WebDriver driver)
	{
		 return driver.findElement(title2);
	}
	
	public WebElement Get_Events_copy1(WebDriver driver)
	{
		 return driver.findElement(copy1);
	}
	
	public WebElement Get_Events_copy2(WebDriver driver)
	{
		 return driver.findElement(copy2);
	}
	
	public WebElement Click_on_Link1(WebDriver driver)
	{
		return driver.findElement(link1);
	}
	
	public WebElement Click_on_Link2(WebDriver driver)
	{
		return driver.findElement(link2);
	}
	
}
