package com.testcases;

import com.Library.ReusableFunctions;
import com.pages.Baseclass;
import com.pages.LoginMBVansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginMBVansTest  extends Baseclass {

	public LoginMBVansPage mbvans= new LoginMBVansPage(driver);
	public ReusableFunctions reuse = new ReusableFunctions();

   	@Test(priority=0)
	public void Section1_Header() 
	{
		logger = report.createTest("Navigating to CPO Page");
		mbvans.Click_on_HeroImage(driver).click();
		  
		String Actual_hero_text=mbvans.Get_Hero_text(driver).getText();
		logger.info("Hero text details from UI is " +Actual_hero_text+"");
		String Expected_hero_text=read_excel.getCellData(0, 0, 0);
		Assert.assertEquals(Actual_hero_text, Expected_hero_text);
		logger.info("Hero text details from Input xls file is " +Expected_hero_text+ "");
		if(Actual_hero_text.equals(Expected_hero_text))
		{
			System.out.println("Hero text verified");
			logger.pass("Hero Title matches with Input file");
		}
		else
		{
			logger.fail("Hero text do not match with input file");
		}
		  
		System.out.println("Hero text is"+Actual_hero_text);
		System.out.println("Expected hero text"+Expected_hero_text);
//		Helper.CaptureScreenshot(driver);
		
	}
	
	@Test(priority=1)
	public void Section2_Details() throws Exception
	{
		WebElement Exclusiveoffer = driver.findElement(By.xpath("//*[@class ='sticky-nav__item-link-label'][text()='Exclusive Offer']"));
		reuse.scroll(driver,Exclusiveoffer);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		mbvans.Get_Details_Image(driver).click();
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		String details=mbvans.Get_Details_text(driver).getText();
		System.out.println("Details"+details);
		logger.info("Captured Section2 text details from UI");
		String Expected_sec2_text=read_excel.getCellData(0, 1, 0);
		logger.info("Section2 text details from Input xls file is " +Expected_sec2_text+ "");
		Assert.assertEquals(details, Expected_sec2_text);
		if(details.equals(Expected_sec2_text))
		{
			System.out.println("Section2 text verified");
			logger.pass("Section2 Text matches with Input file");
		}
		else
		{
			logger.fail("Scetion2 text do not match with input file");
		}

//		Helper.CaptureScreenshot(driver);
	}
	
	@Test(priority=2)
	public void Section3_Eligibility()
	{
		String header=mbvans.GetEligibilityHeader(driver).getText();
		System.out.println(""+header);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		mbvans.GetEligibility_Image_Left(driver).click();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		mbvans.GetEligibility_Image_Right(driver).click();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String description1=mbvans.GetEligibilityDescription1(driver).getText();
		System.out.println(""+description1);
		logger.info("Captured Section3 Title" +description1+" details from UI");
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String description2=mbvans.GetEligibilityDescription2(driver).getText();
		System.out.println(""+description2);
		logger.info("Captured Section3 text details from UI");
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
//		Helper.CaptureScreenshot(driver);
	}
	
	@Test(priority=3)
	public void Section4_FAQ()
	{
		String faq_header=mbvans.GetFAQHeader(driver).getText();
		System.out.println(""+faq_header);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String faq_description=mbvans.GetFAQDescription(driver).getText();	
		System.out.println(""+faq_description);
		logger.info("Captured Section4 text details from UI");
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
//		Helper.CaptureScreenshot(driver);
	}
	
	@Test(priority=4)
	public void Section5_FindADealer()
	{
		mbvans.GetFindDelaerImage(driver).click();
		
		mbvans.ClickOn_FindDealer(driver).click();
//		Helper.CaptureScreenshot(driver);
	}
	

}
