package com.testcases;

import com.Library.ReusableFunctions;
import com.pages.Baseclass;
import com.pages.LoginMBVansPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LoginMBVansTest extends Baseclass {

	public LoginMBVansPage mbvans = new LoginMBVansPage(driver);
	public ReusableFunctions reuse = new ReusableFunctions();
	SoftAssert softassertion = new SoftAssert();


	@Test(priority = 0)
	public void Section1_Header() {
		Logger log = Logger.getLogger("CPO Page");
		PropertyConfigurator.configure("Log4J.properties");
		logger = report.createTest("Header Validation");
//-----------------------------------Section1-Hero Title validation------------------------------------------
		String Actual_hero_title = mbvans.Get_Hero_title(driver).getText();
		logger.info("Header Section Validation Started");
		log.info("Hero Title from Site is " +Actual_hero_title);
		String Expected_hero_title = read_excel.getCellData_sheetname(2, 1, 1);
		log.info("Hero Title from Confluence is ---> " +Expected_hero_title);
		String Actual_hero_image = mbvans.Get_HeroImage(driver).getAttribute("alt");
		log.info("Hero Image from Site is ---> " +Actual_hero_image);
		String Expected_hero_image = read_excel.getCellData_sheetname(2, 4, 1);
		log.info("Hero Image from Confluence is ---> " +Expected_hero_image);
		String Actual_hero_copy = mbvans.Get_Hero_copy(driver).getText();
		log.info("Hero Copy from Site is ---> " +Actual_hero_copy);
		String Expected_hero_copy = read_excel.getCellData_sheetname(2, 2, 1);// Verify title
		log.info("Hero copy from confluence is ---> " +Expected_hero_copy);
		softassertion.assertEquals(Actual_hero_title, Expected_hero_title);
		softassertion.assertEquals(Actual_hero_image,Expected_hero_image);
		softassertion.assertEquals(Actual_hero_copy, Expected_hero_copy);
		if (Actual_hero_title.equals(Expected_hero_title)) {
			logger.pass("Header Title validation passed");

		} else {
			logger.fail("Header Title Validation Failed");
		}
		if (Actual_hero_image.equals(Expected_hero_image)) {
			logger.pass("Header Image validation passed");
		} else {
			logger.fail("Header Image validation Failed");
		}
		if (Actual_hero_copy.equals(Expected_hero_copy)) {
			logger.pass("Header Copy validation passed");
		} else {
			logger.fail("Header Copy validation Failed");
		}
//		Helper.CaptureScreenshot(driver);
		log.info("");
	}


//----------------------------------------------Section2------------------------------------------------
	@Test(priority = 1)
	public void Section2_Details() throws Exception {
		Logger log = Logger.getLogger("CPO Page");
		PropertyConfigurator.configure("Log4J.properties");
		logger = report.createTest("Section2 Validation");
		reuse.scroll(driver,mbvans.Get_Details_title(driver));
		reuse.waitfor(driver,60);
//		reuse.waitforele(driver,40, mbvans.Get_Details_copy(driver));
		String Actual_details_title = mbvans.Get_Details_title(driver).getText();
		log.info("Section2 Details title text from site is ---> " + Actual_details_title + "");
		String Expected_details_title = read_excel.getCellData_sheetname(3, 1, 1);
		log.info("Section2 Details title from Confluence is ---> " + Expected_details_title + "");
		String Actual_details_copy = mbvans.Get_Details_copy(driver).getText();
		log.info("Section2 details copy from site is ---> " + Actual_details_copy + "");
		String Expected_details_copy = read_excel.getCellData_sheetname(3, 2, 1);
		log.info("Section2 details copy from confluence is ---> " + Expected_details_copy + "");
		String Actual_details_image = mbvans.Get_Details_Image(driver).getAttribute("src");
		log.info("Section2 details copy from site is --->" + Actual_details_image + "");
		String Expected_details_image = read_excel.getCellData_sheetname(4, 4, 1);
		log.info("Section2 details copy from confluence is ---> " + Expected_details_image + "");

		softassertion.assertEquals(Actual_details_title, Expected_details_title);
		softassertion.assertTrue(Actual_details_image.contains(Expected_details_image),"Image Matches");
		softassertion.assertEquals(Actual_details_copy, Expected_details_copy);

		if (Actual_details_title.equals(Expected_details_title)) {
			logger.pass("Section2 Header Title validation passed");
		} else {
			logger.fail("Section2 Header Title validation failed");
		}
		if (Actual_details_copy.equals(Expected_details_copy)) {
			logger.pass("Section2 copy validation passed");
		} else {
			logger.fail("Section2 copy validation failed");
		}
		if (Actual_details_image.equals(Expected_details_image)) {
			logger.pass("Section2 Image validation passed");
		} else {
			logger.fail("Section2 Image validation failed");
		}
		reuse.waitfor(driver,60);


//		// Section2- Validate Details image
//
//		// Print on console
//		System.out.println("Actual Details title is" + Actual_details_image);
//		System.out.println("Expected details title is" + Expected_details_image); //
//		// Helper.CaptureScreenshot(driver);

		// Section2 - Validate details copy
		// Validate Details copy

	}
//------------------------------------Section3----------------------------------------------------------
	@Test(priority = 2)
	public void Section3_CPOEligibility() {
		// Section3-Validate Eligibility title
		reuse.waitfor(driver,60);
		reuse.scroll(driver,mbvans.GetEligibilityTitle(driver));
		String actual_eligibility_title = mbvans.GetEligibilityTitle(driver).getText();
		logger.info("Captured eligibility title from UI" + actual_eligibility_title + "");
		String Expected_eligibility_title = read_excel.getCellData_sheetname(5, 1, 1);
		logger.info("eligibility title text from Input xls file is " + Expected_eligibility_title + "");
		// Verify Eligibility Header
		softassertion.assertEquals(actual_eligibility_title, Expected_eligibility_title);

		if (actual_eligibility_title.equals(Expected_eligibility_title)) {
			System.out.println("Eligibility title text verified");
			logger.pass("Eligibility title matches with Input file");
		} else {
			logger.fail("Eligibility title text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Eligibility title text : " + actual_eligibility_title);
		System.out.println("Expected Eligibility title text : " + Expected_eligibility_title); // Helper.CaptureScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3 - Validate Eligibility Image 1
		String Actual_eligibility_image1 = mbvans.GetEligibility_Image1(driver).getAttribute("");
		logger.info("Captured eligibility image1 from UI" + Actual_eligibility_image1 + "");
		String Expected_eligibility_image1 = read_excel.getCellData_sheetname(7, 4, 1);
		logger.info("eligibility image1 text from Input xls file is " + Expected_eligibility_image1 + "");
		// Verify Eligibility Header
		softassertion.assertEquals(Actual_eligibility_image1, Expected_eligibility_image1);

		if (Actual_eligibility_image1.equals(Expected_eligibility_image1)) {
			System.out.println("Eligibility image1 text verified");
			logger.pass("Eligibility image1 matches with Input file");
		} else {
			logger.fail("Eligibility image1 text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Eligibility image1 text : " + Actual_eligibility_image1);
		System.out.println("Expected Eligibility image1 text : " + Expected_eligibility_image1);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES); //
		// Helper.CaptureScreenshot(driver);
		// Section5 - Validate Eligibility Image 2

		String Actual_Eligibility_image2 = mbvans.GetEligibility_Image2(driver).getAttribute("");
		logger.info("Captured eligibility image2 from UI" + Actual_Eligibility_image2 + "");
		String Expected_eligibility_image2 = read_excel.getCellData(8, 4, 1);
		logger.info("eligibility image2 text from Input xls file is " + Expected_eligibility_image2 + "");
		// Verify Eligibility Header
		softassertion.assertEquals(Actual_Eligibility_image2, Expected_eligibility_image2);

		if (Actual_Eligibility_image2.equals(Expected_eligibility_image2)) {
			System.out.println("Eligibility image2 text verified");
			logger.pass("Eligibility image2 matches with Input file");
		} else {
			logger.fail("Eligibility image2 text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Eligibility image2 text : " + Actual_Eligibility_image2);
		System.out.println("Expected Eligibility image2 text : " + Expected_eligibility_image2); // Helper.CaptureScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3 -Validate Eligibility copy 1
		String Actual_eligibility_copy1 = mbvans.GetEligibilityCopy1(driver).getText();
		logger.info("Captured eligibility copy 1 from UI" + Actual_eligibility_copy1 + "");
		String Expected_eligibility_copy1 = read_excel.getCellData_sheetname(7, 2, 1);
		logger.info("eligibility copy 1 text from Input xls file is " + Expected_eligibility_copy1 + "");

		// Verify description details
		softassertion.assertEquals(Actual_eligibility_copy1, Expected_eligibility_copy1);

		if (Actual_eligibility_copy1.equals(Expected_eligibility_copy1)) {
			System.out.println("Eligibility copy 1 text verified");
			logger.pass("Eligibility copy 1 matches with Input file");
		} else {
			logger.fail("Eligibility copy 1 text do not match with input file");
		}

		// Print on console
		System.out.println("Actual copy 1 text is :  " + Actual_eligibility_copy1);
		System.out.println("Expected copy 1 text is :  " + Expected_eligibility_copy1);
		// Helper.CaptureScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3 -Validate Eligibility copy 2
		String Actual_eligibility_copy2 = mbvans.GetEligibilityCopy2(driver).getText();
		logger.info("Captured eligibility copy 2 from UI" + Actual_eligibility_copy2 + "");
		String Expected_eligibility_copy2 = read_excel.getCellData(8, 2, 1);
		logger.info("eligibility copy2 text from Input xls file is " + Expected_eligibility_copy2 + "");
		softassertion.assertEquals(Actual_eligibility_copy2, Expected_eligibility_copy2);
		// Verify description details
		if (Actual_eligibility_copy2.equals(Expected_eligibility_copy2)) {
			System.out.println("Eligibility copy2 text verified");
			logger.pass("Eligibility copy2 matches with Input file");
		} else {
			logger.fail("Eligibility copy2 text do not match with input file");
		}

		// Print on console
		System.out.println("Actual copy2 text is :  " + Actual_eligibility_copy2);
		System.out.println("Expected copy2 text is :  " + Expected_eligibility_copy2);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		// Helper.CaptureScreenshot(driver);
		reuse.waitfor(driver,60);
	}
//-------------------------------------Section4-----------------------------------------------------------
	@Test(priority = 3)
	public void Section4_ExclusiveOffer() throws Exception {
		// Section 2
		// Click on Exclusive offer mbvans.ClickOnExclusive_Offer(driver);
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
		reuse.waitfor(driver,60);
		// Section2- Exclusive Offer title validation
		reuse.scroll(driver,mbvans.Get_Exclusive_Offer_title(driver));
		String Actual_offer_title = mbvans.Get_Exclusive_Offer_title(driver).getText();
		logger.info("Exclusive Offer title from UI is " + Actual_offer_title + "");
		String Expected_offer_title = read_excel.getCellData_sheetname(9, 1, 1);

		// Verify Exclusive Offer title
		softassertion.assertEquals(Actual_offer_title, Expected_offer_title);
		logger.info("Exclusive Offer title from Input xls file is " + Expected_offer_title + "");

		if (Actual_offer_title.equals(Expected_offer_title)) {
			System.out.println("Exclusive Offer title verified");
			logger.pass("Exclusive Offer title text matches with Input file");
		} else {
			logger.fail("Exclusive Offer title text do not match with input file");
		}

		System.out.println("Actual Exclusive Offer title text is" + Actual_offer_title);
		System.out.println("Expected Exclusive Offer title text is" + Expected_offer_title); // Helper.CaptureScreenshot(driver);

		// Section2-Exclusive Offer Image Validation
		String Actual_exclusiveoffer_image = mbvans.Get_Exclusive_Offer_image(driver).getAttribute("");
		logger.info("Exclusive Offer image src from UI is " + Actual_exclusiveoffer_image + "");
		String Expected_exclusiveoffer_image = read_excel.getCellData_sheetname(9, 1, 1);

		// Verify Exclusive Offer Image
		softassertion.assertEquals(Actual_exclusiveoffer_image, Expected_exclusiveoffer_image);
		logger.info("Exclusive Offer image text from Input xls file is " + Expected_exclusiveoffer_image + "");

		if (Actual_exclusiveoffer_image.equals(Expected_exclusiveoffer_image)) {
			System.out.println("Exclusive Offer image text verified");
			logger.pass("Exclusive Offer image text matches with Input file");
		} else {
			logger.fail("Exclusive Offer image text do not match with input file");
		}

		System.out.println("Actual Exclusive Offer image text is" + Actual_exclusiveoffer_image);
		System.out.println("Expected Exclusive Offer image text is" + Expected_exclusiveoffer_image); // Helper.CaptureScreenshot(driver);

		// Section2-Exclusive Offer Copy Validation
		String Actual_exclusiveoffer_copy = mbvans.Get_Exclusive_Offer_copy(driver).getText();
		logger.info("Exclusive Offer copy text from UI is " + Actual_exclusiveoffer_copy + "");
		String Expected_exclusiveoffer_copy = read_excel.getCellData_sheetname(9, 1, 1);
		// Verify Exclusive offer copy
		softassertion.assertEquals(Actual_exclusiveoffer_copy, Expected_exclusiveoffer_copy);
		logger.info("Exclusive Offer copy text from Input xls file is " + Expected_exclusiveoffer_copy + "");

		if (Actual_exclusiveoffer_copy.equals(Expected_exclusiveoffer_copy)) {
			System.out.println("Exclusive Offer copy text verified");
			logger.pass("Exclusive Offer copy text matches with Input file");
		} else {
			logger.fail("Hero copy text do not match with input file");
		}

		System.out.println("Actual Exclusive Offer copy text is" + Actual_exclusiveoffer_copy);
		System.out.println("Expected Exclusive Offer copy text is" + Expected_exclusiveoffer_copy);
		// Helper.CaptureScreenshot(driver); }*/
		reuse.waitfor(driver,60);
	}
//---------------------------------------------Section5-------------------------------------------------
	@Test(priority = 4)
	public void Section5_FAQ() {
		// Click on FAQ button
		// mbvans.ClickOn_FAQ_button(driver);

		// driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3 -Validate FAQ title
		reuse.waitfor(driver,60);
		reuse.scroll(driver,mbvans.GetFAQTitle(driver));
		String Actual_faq_title = mbvans.GetFAQTitle(driver).getText();
		logger.info("FAQ title text from UI is " + Actual_faq_title + "");
		String Expected_faq_title = read_excel.getCellData_sheetname(11, 1, 1);
		logger.info("FAQ title text from Input xls file is " + Expected_faq_title + "");
		// Verify FAQ title
		softassertion.assertEquals(Actual_faq_title, Expected_faq_title);

		if (Actual_faq_title.equals(Expected_faq_title)) {
			System.out.println("FAQ title text verified");
			logger.pass("FAQ title text matches with Input file");
		} else {
			logger.fail("FAQ title text do not match with input file");
		}

		// Print on console
		System.out.println("Actual FAQ title is : " + Actual_faq_title);
		System.out.println("Expected FAQ title is : " + Expected_faq_title);
		// Helper.CaptureScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3- Validate FAQ copy
		String Actual_faq_copy = mbvans.GetFAQDescription(driver).getText();
		logger.info("FAQ copy text from UI is " + Actual_faq_copy + "");
		String Expected_faq_copy = read_excel.getCellData_sheetname(12, 2, 1);
		logger.info("FAQ copy text from Input xls file is " + Expected_faq_copy + "");

		// Verify FAQ copy
		softassertion.assertEquals(Actual_faq_copy, Expected_faq_copy);

		if (Actual_faq_copy.equals(Expected_faq_copy)) {
			System.out.println("FAQ copy text verified");
			logger.pass("FAQ copy text matches with Input file");
		} else {
			logger.fail("FAQ copy text do not match with input file");
		}

		// Print on console
		System.out.println("Actual FAQ copy is : " + Actual_faq_copy);
		System.out.println("Expected FAQ copy is : " + Expected_faq_copy);
		// Helper.CaptureScreenshot(driver);
		reuse.waitfor(driver,60);
	}
//-------------------------------------------Section6--------------------------------------------------
	@Test(priority = 5)
	public void Section6_FindDealer() {
		// Section6-Find Dealer
		reuse.waitfor(driver,60);
//		reuse.scroll(driver,mbvans.GetFind_Dealer_Title(driver));
		String Actual_find_dealer_title = mbvans.GetFind_Dealer_Title(driver).getText();
		logger.info("Captured find dealer title from UI" + Actual_find_dealer_title + "");
		String Expected_find_dealer_title = read_excel.getCellData_sheetname(13, 1, 1);
		logger.info("find dealer title text from Input xls file is " + Expected_find_dealer_title + "");
		// Verify title

		softassertion.assertEquals(Actual_find_dealer_title, Expected_find_dealer_title);

		if (Actual_find_dealer_title.equals(Expected_find_dealer_title)) {
			System.out.println("Find dealer title text verified");
			logger.pass("find dealer title matches with Input file");
		} else {
			logger.fail("find dealer title text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Find dealer title is : " + Actual_find_dealer_title);
		System.out.println("Expected Find delaer title is : " + Expected_find_dealer_title);

		// Section6-Validate FindDealer image
		String Actual_find_dealer_image = mbvans.GetFind_Dealer_Title(driver).getAttribute("");
		logger.info("Captured find dealer image from UI" + Actual_find_dealer_image + "");
		String Expected_find_dealer_image = read_excel.getCellData_sheetname(13, 4, 1);
		logger.info("find dealer image text from Input xls file is " + Expected_find_dealer_image + ""); // Verify title

		softassertion.assertEquals(Actual_find_dealer_image, Expected_find_dealer_image);

		if (Actual_find_dealer_image.equals(Expected_find_dealer_image)) {
			System.out.println("Find dealer image text verified");
			logger.pass("find dealer image matches with Input file");
		} else {
			logger.fail("find dealer image text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Find dealer image is : " + Actual_find_dealer_image);
		System.out.println("Expected Find delaer image is : " + Expected_find_dealer_image);

		// Section6 -Validate find dealer copy
		String Actual_find_dealer_copy = mbvans.GetFind_Dealer_Copy(driver).getAttribute("");
		logger.info("Captured find dealer copy from UI" + Actual_find_dealer_copy + "");
		String Expected_find_dealer_copy = read_excel.getCellData_sheetname(13, 2, 1);
		logger.info("find dealer copy text from Input xls file is " + Expected_find_dealer_copy + ""); // Verify title

		softassertion.assertEquals(Actual_find_dealer_copy, Expected_find_dealer_copy);

		if (Actual_find_dealer_copy.equals(Expected_find_dealer_copy)) {
			System.out.println("Find dealer copy text verified");
			logger.pass("find dealer copy matches with Input file");
		} else {
			logger.fail("find dealer copy text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Find dealer copy is : " + Actual_find_dealer_copy);
		System.out.println("Expected Find delaer copy is : " + Expected_find_dealer_copy);

		// Section6- Click on Find Dealer button
//		mbvans.ClickOn_FindDealer(driver).click();

	}
}