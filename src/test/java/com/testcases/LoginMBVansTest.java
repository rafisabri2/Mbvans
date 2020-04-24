package com.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pages.LoginMBVansPage;
import com.poi.data.ReadDataFromExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMBVansTest   {
	
	WebDriver driver;
	
	LoginMBVansPage mbvans= new LoginMBVansPage(driver);

	ReadDataFromExcel read_excel=new ReadDataFromExcel(".//src//test//java//com//poi//data//MBVansData.xlsx");
	
	@BeforeTest
	public void MBVans_Setup() 
	{
		WebDriverManager.chromedriver().version("2.40").setup();
	    
	    ChromeOptions options = new ChromeOptions();

	   driver = new ChromeDriver(options);
	   
	   String Url=read_excel.getCellData(0, 0, 0);
	   driver.navigate().to(Url);
	   
	   driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
	   
	   driver.manage().window().maximize();
	   
	   driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
	}
	
	@Test(priority=0)
	public void Section1_Header() 
	{
		mbvans.Click_on_HeroImage(driver).click();
		  
		String Actual_hero_text=mbvans.Get_Hero_text(driver).getText();
		
		String Expected_hero_text=read_excel.getCellData(0, 1, 0);
		Assert.assertEquals(Actual_hero_text, Expected_hero_text);
		
		if(Actual_hero_text.equals(Expected_hero_text))
		{
			System.out.println("Hero text verified");
		}
		  
		System.out.println("Hero text is"+Actual_hero_text);
		System.out.println("Expected hero text"+Expected_hero_text);
		
	}
	
	@Test(priority=1)
	public void Section2_Details() throws Exception
	{
		
		mbvans.Get_Details_Image(driver).click();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String details=mbvans.Get_Details_text(driver).getText();
		System.out.println("Details"+details);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
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
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String description2=mbvans.GetEligibilityDescription2(driver).getText();
		System.out.println(""+description2);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
	}
	
	@Test(priority=3)
	public void Section4_FAQ()
	{
		String faq_header=mbvans.GetFAQHeader(driver).getText();
		System.out.println(""+faq_header);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		
		String faq_description=mbvans.GetFAQDescription(driver).getText();	
		System.out.println(""+faq_description);
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
	}
	
	@Test(priority=4)
	public void Section5_FindADealer()
	{
		mbvans.GetFindDelaerImage(driver).click();
		
		mbvans.ClickOn_FindDealer(driver).click();
	}
	
	@AfterTest
	public void LogOutMBVans()
	{
		driver.quit();

}
}
