package com.testcases;

import com.Library.ReusableFunctions;
import com.pages.Baseclass;
import com.pages.LoginMBVansPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        log.info("Section1 Hero Title from Site is " +Actual_hero_title);
        String Expected_hero_title = read_excel.getCellData_sheetname(2, 1, 1);
        log.info("Section1 Hero Title from Confluence is ---> " +Expected_hero_title);
        String Actual_hero_image = mbvans.Get_HeroImage(driver).getAttribute("alt");
        log.info("Section1 Hero Image from Site is ---> " +Actual_hero_image);
        String Expected_hero_image = read_excel.getCellData_sheetname(2, 4, 1);
        log.info("Section1 Hero Image from Confluence is ---> " +Expected_hero_image);
        String Actual_hero_copy = mbvans.Get_Hero_copy(driver).getText();
        log.info("Section1 Hero Copy from Site is ---> " +Actual_hero_copy);
        String Expected_hero_copy = read_excel.getCellData_sheetname(2, 2, 1);
        log.info("Section1 Hero copy from confluence is ---> " +Expected_hero_copy);

        softassertion.assertEquals(Actual_hero_title, Expected_hero_title);
        softassertion.assertEquals(Actual_hero_image,Expected_hero_image);
        softassertion.assertEquals(Actual_hero_copy, Expected_hero_copy);
        if (Actual_hero_title.equals(Expected_hero_title)) {
            logger.pass("Section1 Header Title validation passed");

        } else {
            logger.fail("Section1 Header Title Validation Failed");
        }
        if (Actual_hero_image.equals(Expected_hero_image)) {
            logger.pass("Section1 Header Image validation passed");
        } else {
            logger.fail("Section1 Header Image validation Failed");
        }
        if (Actual_hero_copy.equals(Expected_hero_copy)) {
            logger.pass("Section1 Header Copy validation passed");
        } else {
            logger.fail("Section1 Header Copy validation Failed");
        }
//		Helper.CaptureScreenshot(driver);
        log.info("");
    }


    //----------------------------------------------Section2------------------------------------------------
    @Test(priority = 1)
    public void Section2_Details() throws Exception {
        Logger log = Logger.getLogger("CPO Page");
        PropertyConfigurator.configure("Log4J.properties");
        logger = report.createTest("Section2 Details Validation");

        reuse.scroll(driver,mbvans.Get_Details_title(driver));
        reuse.waitfor(driver,60);
//		reuse.waitforele(driver,40, mbvans.Get_Details_copy(driver));
        String Actual_details_title = mbvans.Get_Details_title(driver).getText();
        log.info("Section2 Details title text from site is ---> " + Actual_details_title + "");
        String Expected_details_title = read_excel.getCellData_sheetname(3, 1, 1);
        log.info("Section2 Details title from Confluence is ---> " + Expected_details_title + "");
        String Actual_details_copy = mbvans.Get_Details_copy(driver).getText();
        log.info("Section2 Details copy from site is ---> " + Actual_details_copy + "");
        String Expected_details_copy = read_excel.getCellData_sheetname(3, 2, 1);
        log.info("Section2 Details copy from confluence is ---> " + Expected_details_copy + "");
        String Actual_details_image = mbvans.Get_Details_Image(driver).getAttribute("src");
        log.info("Section2 Details copy from site is --->" + Actual_details_image + "");
        String Expected_details_image = read_excel.getCellData_sheetname(4, 4, 1);
        log.info("Section2 Details copy from confluence is ---> " + Expected_details_image + "");

        softassertion.assertEquals(Actual_details_title, Expected_details_title);
        softassertion.assertTrue(Actual_details_image.contains(Expected_details_image),"Image Matches");
        softassertion.assertEquals(Actual_details_copy, Expected_details_copy);

        if (Actual_details_title.equals(Expected_details_title)) {
            logger.pass("Section2 Details Title validation passed");
        } else {
            logger.fail("Section2 Details Title validation failed");
        }
        if (Actual_details_copy.equals(Expected_details_copy)) {
            logger.pass("Section2 Details copy validation passed");
        } else {
            logger.fail("Section2 Details copy validation failed");
        }
        if (Actual_details_image.equals(Expected_details_image)) {
            logger.pass("Section2 Details Image validation passed");
        } else {
            logger.fail("Section2 Details Image validation failed");
        }
        reuse.waitfor(driver,60);

    }
    //------------------------------------Section3----------------------------------------------------------
    @Test(priority = 2)
    public void Section3_CPOEligibility() {
        Logger log = Logger.getLogger("CPO Page");
        PropertyConfigurator.configure("Log4J.properties");
        logger = report.createTest("Section3 CPO Eligibility Validation");

        reuse.scroll(driver,mbvans.GetEligibilityTitle(driver));
        reuse.waitfor(driver,120);

        String actual_eligibility_title = mbvans.GetEligibilityTitle(driver).getText();
        log.info("Section3 CPO Eligibility title from site is ---> " + actual_eligibility_title + "");
        String Expected_eligibility_title = read_excel.getCellData_sheetname(5, 1, 1);
        log.info("Section3 CPO Eligibility title text from Confluence is ---> " + Expected_eligibility_title + "");
        String Actual_eligibility_image1 = mbvans.GetEligibility_Image1(driver).getAttribute("src");
        log.info("Section3 CPO Eligibility image1 from site is ---> " + Actual_eligibility_image1 + "");
        String Expected_eligibility_image1 = read_excel.getCellData_sheetname(7, 4, 1);
        log.info("Section3 CPO Eligibility image1 text from Confluence is ---> " + Expected_eligibility_image1 + "");
        String Actual_Eligibility_image2 = mbvans.GetEligibility_Image2(driver).getAttribute("src");
        log.info("Section3 CPO Eligibility image2 from site is ---> " + Actual_Eligibility_image2 + "");
        String Expected_eligibility_image2 = read_excel.getCellData(8, 4, 1);
        log.info("Section3 CPO Eligibility image2 text from Confluence is ---> " + Expected_eligibility_image2 + "");
        String Actual_eligibility_copy1 = mbvans.GetEligibilityCopy1(driver).getText();
        log.info("Section3 CPO Eligibility copy 1 from site is ---> " + Actual_eligibility_copy1 + "");
        String Expected_eligibility_copy1 = read_excel.getCellData_sheetname(7, 2, 1);
        log.info("Section3 CPO Eligibility copy 1 text from Confluence is ---> " + Expected_eligibility_copy1 + "");
        String Actual_eligibility_copy2 = mbvans.GetEligibilityCopy2(driver).getText();
        log.info("Section3  CPOEligibility copy 2 from site is ---> " + Actual_eligibility_copy2 + "");
        String Expected_eligibility_copy2 = read_excel.getCellData(8, 2, 1);
        log.info("Section3 CPO Eligibilitycopy2 text from Confluence is ---> " + Expected_eligibility_copy2 + "");

        // Verify Eligibility Section
        softassertion.assertEquals(actual_eligibility_title, Expected_eligibility_title);
        softassertion.assertTrue(Actual_eligibility_image1.contains(Expected_eligibility_image1),"Image Matches");
        softassertion.assertTrue(Actual_Eligibility_image2.contains(Expected_eligibility_image2),"Image Matches");
        softassertion.assertEquals(Actual_eligibility_copy1, Expected_eligibility_copy1);
        softassertion.assertEquals(Actual_eligibility_copy2, Expected_eligibility_copy2);


        if (actual_eligibility_title.equals(Expected_eligibility_title)) {
            logger.pass("Section3 Eligibility Header Title validation passed");
        } else {
            logger.fail("Section3 Eligibility Header Title validation failed");
        }
        if (Actual_eligibility_image1.equals(Expected_eligibility_image1)) {
            logger.pass("Section3 Eligibility Image1 validation passed");
        } else {
            logger.fail("Section3 Eligibility Image1 validation failed");
        }
        if (Actual_Eligibility_image2.equals(Expected_eligibility_image2)) {
            logger.pass("Section3 Eligibility Image2 validation passed");
        } else {
            logger.fail("Section3 Eligibility Image2 validation failed");
        }
        if (Actual_eligibility_copy1.equals(Expected_eligibility_copy1)) {
            logger.pass("Section3 Eligibility copy1 validation passed");
        } else {
            logger.fail("Section3 Eligibility copy1 validation failed");
        }
        if (Actual_eligibility_copy2.equals(Expected_eligibility_copy2)) {
            logger.pass("Section3 Eligibility copy2 validation passed");
        } else {
            logger.fail("Section3 Eligibility copy2 validation failed");
        }

        reuse.waitfor(driver,60);

    }
    //-------------------------------------Section4-----------------------------------------------------------
    @Test(priority = 3)
    public void Section4_ExclusiveOffer() throws Exception {
        Logger log = Logger.getLogger("CPO Page");
        PropertyConfigurator.configure("Log4J.properties");
        logger = report.createTest("Section4 Exclusive Offer Validation");

        reuse.scroll(driver,mbvans.Get_Exclusive_Offer_title(driver));
        reuse.waitfor(driver,120);

        String Actual_offer_title = mbvans.Get_Exclusive_Offer_title(driver).getText();
        log.info("Section4 Exclusive Offer title from site is ---> " + Actual_offer_title + "");
        String Expected_offer_title = read_excel.getCellData_sheetname(9, 1, 1);
        log.info("Section4 Exclusive Offer title from Confluence is ---> " + Expected_offer_title + "");
        String Actual_exclusiveoffer_image = mbvans.Get_Exclusive_Offer_image(driver).getAttribute("src");
        log.info("Section4 Exclusive Offer image src from site is ---> " + Actual_exclusiveoffer_image + "");
        String Expected_exclusiveoffer_image = read_excel.getCellData_sheetname(9, 1, 1);
        log.info("Section4 Exclusive Offer image text from Confluence is ---> " + Expected_exclusiveoffer_image + "");
        String Actual_exclusiveoffer_copy = mbvans.Get_Exclusive_Offer_copy(driver).getText();
        log.info("Section4 Exclusive Offer copy text from site is ---> " + Actual_exclusiveoffer_copy + "");
        String Expected_exclusiveoffer_copy = read_excel.getCellData_sheetname(9, 1, 1);
        log.info("Section4 Exclusive Offer copy text from Confluence is ---> " + Expected_exclusiveoffer_copy + "");

        softassertion.assertEquals(Actual_offer_title, Expected_offer_title);
        softassertion.assertTrue(Actual_exclusiveoffer_image.contains(Expected_exclusiveoffer_image),"Image matches");
        softassertion.assertEquals(Actual_exclusiveoffer_copy, Expected_exclusiveoffer_copy);

        if (Actual_offer_title.equals(Expected_offer_title)) {
            logger.pass("Section4 Exclusive Offer title validation passed");
        } else {
            logger.fail("Section4 Exclusive Offer title validation failed");
        }
        if (Actual_exclusiveoffer_image.equals(Expected_exclusiveoffer_image)) {
            logger.pass("Section4 Exclusive Offer image validation passed");
        } else {
            logger.fail("Section4 Exclusive Offer image validation failed");
        }
        if (Actual_exclusiveoffer_copy.equals(Expected_exclusiveoffer_copy)) {
            logger.pass("Section4 Exclusive Offer copy validation passed");
        } else {
            logger.fail("Section4 Exclusive Offer copy validation failed");
        }
        reuse.waitfor(driver,60);
    }
    //---------------------------------------------Section5-------------------------------------------------
    @Test(priority = 4)
    public void Section5_FAQ() {
        Logger log = Logger.getLogger("CPO Page");
        PropertyConfigurator.configure("Log4J.properties");
        logger = report.createTest("Section5 Frequently Asked Questions Validation");

        reuse.scroll(driver,mbvans.GetFAQTitle(driver));
        reuse.waitfor(driver,120);

        String Actual_faq_title = mbvans.GetFAQTitle(driver).getText();
        log.info("Section5 FAQ title text from site is ---> " + Actual_faq_title + "");
        String Expected_faq_title = read_excel.getCellData_sheetname(11, 1, 1);
        log.info("Section5 FAQ title text from Confluence is ---> " + Expected_faq_title + "");
        String Actual_faq_copy = mbvans.GetFAQDescription(driver).getText();
        log.info("Section5 FAQ copy text from site is ---> " + Actual_faq_copy + "");
        String Expected_faq_copy = read_excel.getCellData_sheetname(12, 2, 1);
        log.info("Section5 FAQ copy text from Confluence is ---> " + Expected_faq_copy + "");

        softassertion.assertEquals(Actual_faq_title, Expected_faq_title);
        softassertion.assertEquals(Actual_faq_copy, Expected_faq_copy);

        if (Actual_faq_title.equals(Expected_faq_title)) {
            logger.pass("Section5 FAQ title validation passed");
        } else {
            logger.fail("Section5 FAQ title validation failed");
        }
        if (Actual_faq_copy.equals(Expected_faq_copy)) {
            logger.pass("Section5 FAQ copy validation passed");
        } else {
            logger.fail("Section5 FAQ copy validation failed");
        }
        // Helper.CaptureScreenshot(driver);
        reuse.waitfor(driver,60);
    }
    //-------------------------------------------Section6--------------------------------------------------
    @Test(priority = 5)
    public void Section6_FindDealer() {
        Logger log = Logger.getLogger("CPO Page");
        PropertyConfigurator.configure("Log4J.properties");
        logger = report.createTest("Section5 Frequently Asked Questions Validation");

        reuse.scroll(driver,mbvans.GetFind_Dealer_Title(driver));
        reuse.waitfor(driver,120);

        String Actual_find_dealer_title = mbvans.GetFind_Dealer_Title(driver).getText();
        log.info("Section6 Find Dealer title from site is ---> " + Actual_find_dealer_title + "");
        String Expected_find_dealer_title = read_excel.getCellData_sheetname(13, 1, 1);
        log.info("Section6 Find Dealer title text from Confluence is --->" + Expected_find_dealer_title + "");
        String Actual_find_dealer_image = mbvans.GetFindDealerImage(driver).getAttribute("src");
        log.info("Section6 Find Dealer image from site is ---> " + Actual_find_dealer_image + "");
        String Expected_find_dealer_image = read_excel.getCellData_sheetname(13, 4, 1);
        log.info("Section6 Find Dealer image text from Confluence is --->" + Expected_find_dealer_image + "");
        String Actual_find_dealer_copy = mbvans.GetFind_Dealer_Copy(driver).getText();
        log.info("Section6 Find Dealer copy from site is ---> " + Actual_find_dealer_copy + "");
        String Expected_find_dealer_copy = read_excel.getCellData_sheetname(13, 2, 1);
        log.info("Section6 Find Dealer copy text from Confluence is --->" + Expected_find_dealer_copy + "");

        softassertion.assertEquals(Actual_find_dealer_title, Expected_find_dealer_title);
        softassertion.assertTrue(Actual_find_dealer_image.contains(Expected_find_dealer_image),"Image matches");
        softassertion.assertEquals(Actual_find_dealer_copy, Expected_find_dealer_copy);

        if (Actual_find_dealer_title.equals(Expected_find_dealer_title)) {
            logger.pass("Section6 Find Dealer title validation passed");
        } else {
            logger.fail("Section6 Find Dealer title validation failed");
        }
        if (Actual_find_dealer_image.equals(Expected_find_dealer_image)) {
            logger.pass("Section6 Find Dealer image validation passed");
        } else {
            logger.fail("Section6 Find Dealer image validation failed");
        }
        if (Actual_find_dealer_copy.equals(Expected_find_dealer_copy)) {
            logger.pass("Section6 Find Dealer copy validation passed");
        } else {
            logger.fail("Section6 Find Dealer copy validation failed");
        }
        reuse.waitfor(driver,60);
        // Section6- Click on Find Dealer button
        mbvans.ClickOn_FindDealer(driver).click();
        reuse.waitfor(driver, 120);

        driver.navigate().back();

    }
}