package com.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Library.ReusableFunctions;
import com.pages.Baseclass;
import com.pages.LoginMBVansPage;

public class LoginMBVansTest extends Baseclass {

	public LoginMBVansPage mbvans = new LoginMBVansPage(driver);
	public ReusableFunctions reuse = new ReusableFunctions();

	@Test(priority = 0)
	public void Section1_Header() {
		logger = report.createTest("Navigating to CPO Page");
		// Section1-Hero Title validation
		String Actual_hero_title = mbvans.Get_Hero_title(driver).getText();
		logger.info("Hero Title details from UI is " + Actual_hero_title + "");
		String Expected_hero_title = read_excel.getCellData_sheetname(2, 1, 1);
		// Verify title
		Assert.assertEquals(Actual_hero_title, Expected_hero_title);
		logger.info("Hero text details from Input xls file is " + Expected_hero_title + "");

		if (Actual_hero_title.equals(Expected_hero_title)) {
			System.out.println("Hero text verified");
			logger.pass("Hero Title matches with Input file");
		} else {
			logger.fail("Hero text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Hero text is" + Actual_hero_title);
		System.out.println("Expected hero text" + Expected_hero_title);
//		Helper.CaptureScreenshot(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section1-Hero Image validation
		String Actual_hero_image = mbvans.Get_HeroImage(driver).getAttribute("alt");
		logger.info("Hero image name from UI is " + Actual_hero_image + "");
		String Expected_hero_image = read_excel.getCellData_sheetname(2, 4, 1);
		// Verify image src name
		Assert.assertEquals(Actual_hero_image, Expected_hero_image);
		logger.info("Hero image name from Input xls file is " + Expected_hero_image + "");

		if (Actual_hero_image.equals(Expected_hero_image)) {
			System.out.println("Hero image name verified");
			logger.pass("Hero image matches with Input file");
		} else {
			logger.fail("Hero image name do not match with input file");
		}
		// Print on console
		System.out.println("Actual Hero image name is" + Actual_hero_image);
		System.out.println("Expected Hero image name is" + Expected_hero_image); //
		// Helper.CaptureScreenshot(driver);

		// Section1-Hero Copy validation
		String Actual_hero_copy = mbvans.Get_Hero_copy(driver).getText();
		logger.info("Hero copy text from UI is " + Actual_hero_copy + "");
		String Expected_hero_copy = read_excel.getCellData_sheetname(2, 2, 1);
		// Verify copy text
		Assert.assertEquals(Actual_hero_copy, Expected_hero_copy);
		logger.info("Hero copy text from Input xls file is " + Expected_hero_copy + "");

		if (Actual_hero_copy.equals(Expected_hero_copy)) {
			System.out.println("Hero copy text verified");
			logger.pass("Hero copy text matches with Input file");
		} else {
			logger.fail("Hero copy text do not match with input file");
		}

		System.out.println("Actual Hero copy text is" + Actual_hero_copy);
		System.out.println("Expected Hero copy text is" + Expected_hero_copy); //
		// Helper.CaptureScreenshot(driver);
	}

	@Test(priority = 1)
	public void Section2_Details() throws Exception {
		// Section2 - Validate Details title
		String Actual_details_title = mbvans.Get_Details_title(driver).getText();
		logger.info("Details title text from UI" + Actual_details_title + "");
		String Expected_details_title = read_excel.getCellData_sheetname(3, 1, 1);
		logger.info("Details title from Input xls file is " + Expected_details_title + "");

		// Verify Details title
		Assert.assertEquals(Actual_details_title, Expected_details_title);
		if (Actual_details_title.equals(Expected_details_title)) {
			System.out.println("Details text verified");
			logger.pass("Details Text matches with Input file");
		} else {
			logger.fail("Details text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Details title is" + Actual_details_title);
		System.out.println("Expected details title is" + Expected_details_title);
		// Helper.CaptureScreenshot(driver);

		// Section2- Validate Details image
		String Actual_details_image = mbvans.Get_Details_Image(driver).getAttribute("img src");
		logger.info("Captured image text details from UI" + Actual_details_image + "");
		String Expected_details_image = read_excel.getCellData_sheetname(4, 4, 1);
		logger.info("Image text details from Input xls file is " + Expected_details_image + "");

		// Verify Details image
		Assert.assertEquals(Actual_details_image, Expected_details_image);
		if (Actual_details_image.equals(Expected_details_image)) {
			System.out.println("Details image text verified");
			logger.pass("Details image matches with Input file");
		} else {
			logger.fail("Scetion2 text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Details title is" + Actual_details_image);
		System.out.println("Expected details title is" + Expected_details_image); //
		// Helper.CaptureScreenshot(driver);

		// Section2 - Validate details copy
		// Validate Details copy
		String Actual_details_copy = mbvans.Get_Details_copy(driver).getText();
		logger.info("Captured details copy from UI" + Actual_details_copy + "");
		String Expected_details_copy = read_excel.getCellData_sheetname(3, 2, 1);
		logger.info("details copy from Input xls file is " + Expected_details_copy + "");

		// Verify Details image
		Assert.assertEquals(Actual_details_copy, Expected_details_copy);
		if (Actual_details_copy.equals(Expected_details_copy)) {
			System.out.println("Details copy text verified");
			logger.pass("Details copy matches with Input file");
		} else {
			logger.fail("Details copy text do not match with input file");
		}
		// Print on console
		System.out.println("Actual Details title is" + Actual_details_copy);
		System.out.println("Expected details title is" + Expected_details_copy); //
		// Helper.CaptureScreenshot(driver);

	}

	@Test(priority = 2)
	public void Section3_CPOEligibility() {
		// Section3-Validate Eligibility title
		String actual_eligibility_title = mbvans.GetEligibilityTitle(driver).getText();
		logger.info("Captured eligibility title from UI" + actual_eligibility_title + "");
		String Expected_eligibility_title = read_excel.getCellData_sheetname(5, 1, 1);
		logger.info("eligibility title text from Input xls file is " + Expected_eligibility_title + "");
		// Verify Eligibility Header
		Assert.assertEquals(actual_eligibility_title, Expected_eligibility_title);

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
		Assert.assertEquals(Actual_eligibility_image1, Expected_eligibility_image1);

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
		Assert.assertEquals(Actual_Eligibility_image2, Expected_eligibility_image2);

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
		Assert.assertEquals(Actual_eligibility_copy1, Expected_eligibility_copy1);

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
		Assert.assertEquals(Actual_eligibility_copy2, Expected_eligibility_copy2);
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
	}

	@Test(priority = 3)
	public void Section4_ExclusiveOffer() throws Exception {
		// Section 2
		// Click on Exclusive offer mbvans.ClickOnExclusive_Offer(driver);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section2- Exclusive Offer title validation
		String Actual_offer_title = mbvans.Get_Exclusive_Offer_title(driver).getText();
		logger.info("Exclusive Offer title from UI is " + Actual_offer_title + "");
		String Expected_offer_title = read_excel.getCellData_sheetname(2, 1, 1);

		// Verify Exclusive Offer title
		Assert.assertEquals(Actual_offer_title, Expected_offer_title);
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
		String Expected_exclusiveoffer_image = read_excel.getCellData_sheetname(2, 1, 1);

		// Verify Exclusive Offer Image
		Assert.assertEquals(Actual_exclusiveoffer_image, Expected_exclusiveoffer_image);
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
		String Expected_exclusiveoffer_copy = read_excel.getCellData_sheetname(2, 1, 1);
		// Verify Exclusive offer copy
		Assert.assertEquals(Actual_exclusiveoffer_copy, Expected_exclusiveoffer_copy);
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
	}

	@Test(priority = 1)
	public void Section5_FAQ() {
		// Click on FAQ button
		// mbvans.ClickOn_FAQ_button(driver);

		// driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);

		// Section3 -Validate FAQ title
		String Actual_faq_title = mbvans.GetFAQTitle(driver).getText();
		logger.info("FAQ title text from UI is " + Actual_faq_title + "");
		String Expected_faq_title = read_excel.getCellData_sheetname(11, 1, 1);
		logger.info("FAQ title text from Input xls file is " + Expected_faq_title + "");
		// Verify FAQ title
		Assert.assertEquals(Actual_faq_title, Expected_faq_title);

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
		Assert.assertEquals(Actual_faq_copy, Expected_faq_copy);

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
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.MINUTES);
	}

	@Test(priority = 5)
	public void Section6_FindDealer() {
		// Section6-Find Dealer
		String Actual_find_dealer_title = mbvans.GetFind_Dealer_Title(driver).getText();
		logger.info("Captured find dealer title from UI" + Actual_find_dealer_title + "");
		String Expected_find_dealer_title = read_excel.getCellData_sheetname(0, 8, 0);
		logger.info("find dealer title text from Input xls file is " + Expected_find_dealer_title + "");
		// Verify title

		Assert.assertEquals(Actual_find_dealer_title, Expected_find_dealer_title);

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
		String Expected_find_dealer_image = read_excel.getCellData_sheetname(0, 8, 0);
		logger.info("find dealer image text from Input xls file is " + Expected_find_dealer_image + ""); // Verify title

		Assert.assertEquals(Actual_find_dealer_image, Expected_find_dealer_image);

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
		String Expected_find_dealer_copy = read_excel.getCellData_sheetname(0, 8, 0);
		logger.info("find dealer copy text from Input xls file is " + Expected_find_dealer_copy + ""); // Verify title

		Assert.assertEquals(Actual_find_dealer_copy, Expected_find_dealer_copy);

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
		mbvans.ClickOn_FindDealer(driver).click();

	}
}