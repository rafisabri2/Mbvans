package com.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    public static String CaptureScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotpath= System.getProperty("user.dir")+"/Screenshots/cpo_"+getCurrentDate()+".png";
        try {
            FileHandler.copy(src, new File(screenshotpath));
            System.out.println("Screenshot Captured");
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot" + e.getMessage());
        }
        return screenshotpath;

    }

    public static String getCurrentDate() {
        DateFormat customdate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentdate = new Date();
       return customdate.format(currentdate);
    }
}
