package com.pages;

import com.Conf.Extractor.ExtractionTool;
import com.Library.ReusableFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class Baseclass {

    public WebDriver driver;
    public ExcelDataProvider read_excel;
    public ConfigDataProvider config;
    public static ExtentReports report;
    public static ExtentTest logger;
    @BeforeSuite
    public void setupsuite() throws IOException {
        ExtractionTool extract= new ExtractionTool();
//        extract.Runextraction();
        read_excel=new ExcelDataProvider(System.getProperty("user.dir")+"/TestData/CPO.xlsx");
        config=new ConfigDataProvider();
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CPO"+Helper.getCurrentDate()+".html"));
        report = new ExtentReports();
        report.attachReporter(extent);

    }

    @BeforeClass
    public void Setup()
    {
    //        String Url=read_excel.getCellData(0, 0, 0);
            driver= BrowserFactory.startbrowser(driver,config.Getbrowser(),config.Geturl());
    //        driver.navigate().to(config.Geturl());
            ReusableFunctions.checkPageIsReady(driver);
//            ReusableFunctions.scrolltobottom(driver);

    }
    @AfterClass
    public void Teardown()
    {
        driver.quit();
    }

    @AfterMethod
    public void TeardownMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE)
        {
//            Helper.CaptureScreenshot(driver);
            logger.fail("Test Failed" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
        }

        else if(result.getStatus()==ITestResult.SKIP)
        {
//            Helper.CaptureScreenshot(driver);
            logger.skip("Test Skipped" , MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());

        }
        report.flush();
    }

}
