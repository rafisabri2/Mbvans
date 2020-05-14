package com.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ReusableFunctions {
//public static WebDriver driver;
//    public ReusableFunctions(WebDriver driver)
//    {
//        this.driver = driver;
//    }
//    public static WebDriver driver;
    public static void checkPageIsReady(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor)driver;


        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page Is loaded.");
            return;
        }

        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i=0; i<25; i++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")){
                break;
            }
        }
    }

    public void scroll(WebDriver driver, WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }
    public static void scrolltobottom(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

    }

    public void waitfor(WebDriver driver, int timeUnit)
    {
        WebDriverWait wait = new WebDriverWait(driver, ((TimeUnit.SECONDS).toSeconds(timeUnit)));
    }
    public void waitforele(WebDriver driver,int time,WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+ele+"")));
    }


}
