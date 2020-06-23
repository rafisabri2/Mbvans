package com.testcases;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Library.ReusableFunctions;
import com.pages.Baseclass;
import com.pages.EventsMBVansPage;


public class EventsMBVansTest extends Baseclass {

	public EventsMBVansPage mbvans_events = new EventsMBVansPage(driver);
	public ReusableFunctions reuse = new ReusableFunctions();
	SoftAssert softassertion = new SoftAssert();

	//----------------------------------------------Section1------------------------------------------------
	
	@Test(priority = 0)
	public void Section1_Events_Header() {
		
		Logger log = Logger.getLogger("Trade Shows and Events Page");
		PropertyConfigurator.configure("Log4J.properties");
		logger = report.createTest("Events Section1 Validation");
		
		reuse.scroll(driver, mbvans_events.Click_OnEvents_button(driver));
		reuse.waitfor(driver, 60);
		//reuse.waitforele(driver,40, mbvans_events.Click_OnEvents_button(driver));
		mbvans_events.Click_OnEvents_button(driver).click();
		reuse.waitfor(driver, 120);
		 mbvans_events.Get_Section1_Header(driver).click();
		 String Actual_events_header =mbvans_events.Get_Section1_Header(driver).getText();
		log.info("Events header text from site is ---> " + Actual_events_header + "");
		//String Expected_events_header = read_excel.getCellData_sheetname(3, 1, 1);
		//log.info("Events header text from Confluence is ---> " + Expected_events_header + "");
		String Actual_events_copy = mbvans_events.Get_Events_copy(driver).getText();
		log.info("Events copy text from site is ---> " + Actual_events_copy + "");
		//String Expected_events_copy = read_excel.getCellData_sheetname(3, 2, 1);
		//log.info("Events copy text from confluence is ---> " + Expected_events_copy + "");
		String Actual_events_image = mbvans_events.Get_Events_Image(driver).getAttribute("src");
		log.info("Events image name from site is --->" + Actual_events_image + "");
		//String Expected_events_image = read_excel.getCellData_sheetname(4, 4, 1);
		//log.info("Events image name from confluence is ---> " + Expected_events_image + "");

	/*	softassertion.assertEquals(Actual_events_header, Expected_events_header);
		softassertion.assertTrue(Actual_events_image.contains(Expected_events_image), "Image Matches");
		softassertion.assertEquals(Actual_events_copy, Expected_events_copy);

		if (Actual_events_header.equals(Expected_events_header)) {
			logger.pass("Events header text validation passed");
		} else {
			logger.fail("Events header text validation failed");
		}
		if (Actual_events_copy.equals(Expected_events_copy)) {
			logger.pass("Events copy text validation passed");
		} else {
			logger.fail("Events copy text validation failed");
		}
		if (Actual_events_image.equals(Expected_events_image)) {
			logger.pass("Events image name validation passed");
		} else {
			logger.fail("Events image name validation failed");
		}
		reuse.waitfor(driver, 60);
			*/
		
	}

	//----------------------------------------------Section2------------------------------------------------
	
	@Test(priority = 1)
	public void Section2_Events_Details() {
		
		Logger log = Logger.getLogger("Trade Shows and Events Page");
		PropertyConfigurator.configure("Log4J.properties");
		logger = report.createTest("Events Section2 Validation");
		
		reuse.scroll(driver, mbvans_events.Get_Section2_Header(driver));
		reuse.waitfor(driver, 120);
		mbvans_events.Get_Section2_Header(driver).click();
		String Actual_section2_header =mbvans_events.Get_Section2_Header(driver).getText();
		log.info("Section2 events header text from site is ---> " + Actual_section2_header + "");
		//String Expected_section2_header = read_excel.getCellData_sheetname(3, 1, 1);
		//log.info("Section2 events header text from Confluence is ---> " + Expected_section2_header + "");
		String Actual_section2_title1 = mbvans_events.Get_Events_title1(driver).getText();
		log.info("Section2 events title1 text from site is ---> " + Actual_section2_title1 + "");
		//String Expected_section2_title1 = read_excel.getCellData_sheetname(3, 2, 1);
		//log.info("Section2 events title1 text from confluence is ---> " + Expected_section2_title1 + "");
		String Actual_section2_copy1 = mbvans_events.Get_Events_copy1(driver).getText();
		log.info("Section2 events copy1 text from site is ---> " + Actual_section2_copy1 + "");
		//String Expected_section2_copy1 = read_excel.getCellData_sheetname(3, 2, 1);
		//log.info("Section2 events copy1 text from confluence is ---> " + Expected_section2_copy1 + "");
		//String Actual_section2_link1 = mbvans_events.Click_on_Link1(driver).click();
		//log.info("Section2 events link1 text from site is --->" + Actual_section2_link1 + "");
		//String Expected_section2_link1 = read_excel.getCellData_sheetname(4, 4, 1);
		//log.info("Section2 events link1 text from confluence is ---> " + Expected_section2_link1 + "");
		String Actual_section2_title2 = mbvans_events.Get_Events_title2(driver).getText();
		log.info("Section2 events title2 text from site is ---> " + Actual_section2_title2 + "");
		//String Expected_section2_title2 = read_excel.getCellData_sheetname(3, 2, 1);
		//log.info("Section2 events title2 text from confluence is ---> " + Expected_section2_title2 + "");
		String Actual_section2_copy2 = mbvans_events.Get_Events_copy2(driver).getText();
		log.info("Section2 events copy2 text from site is ---> " + Actual_section2_copy2 + "");
		//String Expected_section2_copy2 = read_excel.getCellData_sheetname(3, 2, 1);
		//log.info("Section2 events copy2 text from confluence is ---> " + Expected_section2_copy2 + "");
		//String Actual_section2_link2 = mbvans_events.Get_Events_Image(driver).getAttribute("src");
		//log.info("Section2 events link2 text from site is --->" + Actual_section2_link2 + "");
		//String Expected_section2_link2 = read_excel.getCellData_sheetname(4, 4, 1);
		//log.info("Section2 events link2 text from confluence is ---> " + Expected_section2_link2 + "");

	/*	softassertion.assertEquals(Actual_section2_header, Expected_section2_header);
		softassertion.assertEquals(Actual_section2_title1 ,Expected_section2_title1);
		softassertion.assertEquals(Actual_section2_copy1, Expected_section2_copy1);
		softassertion.assertEquals(Actual_section2_link1, Expected_section2_link1);
		softassertion.assertEquals(Actual_section2_title2 ,Expected_section2_title2);
		softassertion.assertEquals(Actual_section2_copy2, Expected_section2_copy2);
		softassertion.assertEquals(Actual_section2_link2, Expected_section2_link2);


		if (Actual_section2_header.equals(Expected_section2_header)) {
			logger.pass("Section2 events header text validation passed");
		} else {
			logger.fail("Section2 events header text validation failed");
		}
		if (Actual_section2_title1.equals(Expected_section2_title1)) {
			logger.pass("Section2 events title1 text validation passed");
		} else {
			logger.fail("Section2 events title1 text validation failed");
		}
		if (Actual_section2_copy1.equals(Expected_section2_copy1)) {
			logger.pass("Section2 events copy1 text validation passed");
		} else {
			logger.fail("Section2 events copy1 text validation failed");
		}
		if (Actual_section2_link1.equals(Expected_section2_link1)) {
			logger.pass("Section2 events link1 text validation passed");
		} else {
			logger.fail("Section2 events link1 text validation failed");
		}
		if (Actual_section2_title2.equals(Expected_section2_title2)) {
			logger.pass("Section2 events title2 text validation passed");
		} else {
			logger.fail("Section2 events title2 text validation failed");
		}
		if (Actual_section2_copy2.equals(Expected_section2_copy2)) {
			logger.pass("Section2 events copy2 text validation passed");
		} else {
			logger.fail("Section2 events copy2 text validation failed");
		}
		if (Actual_section2_link2.equals(Expected_section2_link2)) {
			logger.pass("Section2 events link2 text validation passed");
		} else {
			logger.fail("Section2 events link2 text validation failed");
		}
		reuse.waitfor(driver, 60);
			
		
	*/
	}
		}


