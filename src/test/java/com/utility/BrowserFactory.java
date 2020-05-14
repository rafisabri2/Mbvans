package com.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startbrowser(WebDriver driver,String browsername, String appurl)
    {if(browsername.equals("Chrome"))
        {

        WebDriverManager.chromedriver().version("2.40").setup();

        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

    }
    else if (browsername.equals("Firefox"))
        {

            WebDriverManager.firefoxdriver().setup();

            ChromeOptions options = new ChromeOptions();

            driver = new FirefoxDriver(options);

        }
    else if (browsername.equals("IE"))
    {

        WebDriverManager.iedriver().setup();

        ChromeOptions options = new ChromeOptions();

        driver = new InternetExplorerDriver(options);
    }
    else
    {
        System.out.println("We do not support the browser");
    }
    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(appurl);
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    return  driver;
    }

}
