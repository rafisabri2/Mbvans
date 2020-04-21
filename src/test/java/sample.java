import org.openqa.selenium.By;
//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
@Test
    public void hello() {


//    System.setProperty("webdriver.chrome.driver","C:\\Users\\Rafi\\Downloads\\chromedriver_win32\\chromedriver.exe");
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-gpu");
////    options.setPageLoadStrategy(PageLoadStrategy.NONE);
//// Instantiate the chrome driver
//    WebDriver driver = new ChromeDriver(options);

//    WebDriverManager.getInstance(CHROME).setup();
    WebDriverManager.chromedriver().version("2.40").setup();
    
    ChromeOptions options = new ChromeOptions();

  WebDriver driver = new ChromeDriver(options);
  //  WebDriver driver=new ChromeDriver();
//
//    options.setPageLoadStrategy(PageLoadStrategy.EAGER); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
//    options.addArguments("start-maximized"); // https://stackoverflow."com/a/26283818/1689770
//    options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
//    options.addArguments("--headless"); // only if you are ACTUALLY running headless
//    options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
//    options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
//    options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
//    options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
//    options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
//    driver = new ChromeDriver(options);

    driver.get("https://www.mbvans.com/en/cpo");
    driver.manage().window().maximize();
   WebDriverWait wait = new WebDriverWait(driver, 20);
   
 WebElement a=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"corporate\"]/div[1]/section/div[2]/section/div/p[2]/a")));
 a.click();
  //   wait.until(ExpectedConditions.elementToBeClickable(By.className("column-link-list__link-container footer-container__item-content")));
   // driver.getTitle();
    driver.quit();
}
}
