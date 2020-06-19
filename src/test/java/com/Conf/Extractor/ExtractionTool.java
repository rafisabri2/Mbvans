package com.Conf.Extractor;

import com.utility.ConfigDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

//import java.nio.file.Files;
//import java.nio.file.Files;

    public class ExtractionTool extends ConfigDataProvider {
        static WebDriverWait wait;
        ConfigDataProvider cdp = new ConfigDataProvider();
@Test
 public void Runextraction()
{

    try {
        String baseUrl = cdp.GetConfExtractUrl();
//        "https://mbusarf.atlassian.net/wiki/spaces/VOW/pages/845547115/CPO"
//                https://mbusarf.atlassian.net/wiki/spaces/VOW/pages/1000604963/Events
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().version("2.40").setup();

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
//            WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement formElement = driver.findElement(By.id("form-login"));
        formElement.findElement(By.id("username")).sendKeys("Extern.rafiuddin@mbusa.com");
        driver.findElement(By.id("login-submit")).click();

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        ((RemoteWebDriver) driver).executeScript("document.getElementById('password').value='Welcome@2020';",
                "password");

        WebDriverWait wait = new WebDriverWait(driver, 2000);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-submit")));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click(element);
        Action action = actions.build();
        action.perform();

        element.click();

        wait = null;
        wait = new WebDriverWait(driver, 2000);
        List<WebElement> listOfTables = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("table")));

        List<WebElement> listOfTable = driver
                .findElements(By.xpath("//div[@id='main-content']/div/div/div/div/div/table"));
        int n = 0;

        Iterator<WebElement> iterator = listOfTable.iterator();
        iterator.next();
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (WebElement table : listOfTable) {

            List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
            List<WebElement> listOfCols = listOfRows.get(0).findElements(By.tagName("th"));

            String text1 = listOfRows.get(0).findElements(By.tagName("th")).get(1).getText();
            System.out.println(text1);
            List<WebElement> webElement = driver.findElements(By.xpath("//div[@id='main-content']/div/div/div/h1"));
//			String sheetName = webElement.get(n).getText().replaceAll("[^a-zA-Z0-9\\s+]", "");
//			System.out.println("sheetName :"+sheetName);
            XSSFSheet sheet = workbook.createSheet(String.valueOf(n + 1)); //String.valueOf(n)
            System.out.println("Table count :" + listOfTable.size());
            System.out.println("listOfRows count :" + listOfRows.size());
            System.out.println("listOfCols count :" + listOfCols.size());
            System.out.println("TH: " + listOfRows.get(2).findElement(By.tagName("th")).getText());

//			Font for header cell's
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 10);
            font.setFontName("Arial");
            font.setBold(true);
            font.setItalic(false);

//			Style for header cell's
            CellStyle style = workbook.createCellStyle();
            style.setFont(font);
            style.setWrapText(true);
            style.setAlignment(CellStyle.ALIGN_CENTER);

            int rowCount = 0;
            for (int i = 0; i < listOfRows.size(); i++) {
                Row row = sheet.createRow(rowCount);
                int columnCount = 0;
                for (int j = 0; j < listOfCols.size(); j++) {
                    sheet.setColumnWidth(j, 35 * 250);
                    if (i == 0) {
                        String text = listOfRows.get(i).findElements(By.tagName("th")).get(j).getText();

                        Cell cell = row.createCell(columnCount);
                        cell.setCellValue(text);
                        cell.setCellStyle(style);

                    } else {
                        if (j == 0) {
                            WebElement tdData = listOfRows.get(i).findElements(By.tagName("th")).get(j);
                            String text = (tdData != null) ? tdData.getText() : "";

                            Cell cell = row.createCell(columnCount);
                            cell.setCellValue(text);
                            cell.setCellStyle(style);

                        } else {

                            Cell cell = row.createCell(columnCount);
                            CellStyle styleForTd = workbook.createCellStyle();
                            styleForTd.setAlignment(CellStyle.ALIGN_CENTER);
                            styleForTd.setWrapText(true);

                            String text = "";
                            try {
                                WebElement imgCheckforTDdata = listOfRows.get(i).findElements(By.tagName("td"))
                                        .get(j - 1).findElement(By.tagName("div"));

                                if (imgCheckforTDdata == null) {

                                    WebElement tdData = listOfRows.get(i).findElements(By.tagName("td")).get(j - 1);
                                    text = (tdData != null) ? tdData.getText() : "";
                                    cell.setCellValue(text);
                                    cell.setCellStyle(styleForTd);

                                } else {

                                    String imgUrl = imgCheckforTDdata.findElement(By.tagName("img"))
                                            .getAttribute("src");
                                    System.out.println("url:" + imgUrl);

                                    imgCheckforTDdata.findElement(By.tagName("img")).click();

                                    String imageName = imgCheckforTDdata.findElement(By.tagName("div"))
                                            .getAttribute("data-file-name");
                                    System.out.println("imageName :" + imageName);

                                    try {
                                        List<WebElement> imgDownloadBtn = wait
                                                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
                                                        "//button[contains(@data-testid,'media-viewer-download-button')]")));
                                        imgDownloadBtn.get(0).click();
                                        List<WebElement> imgCloseBtn = wait
                                                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
                                                        "//button[contains(@data-testid,'media-viewer-close-button')]")));
                                        imgCloseBtn.get(0).click();

                                        String currentDirFilePath = System.getProperty("user.dir") + "\\" + imageName;
                                        String downloadsFilePath = System.getProperty("user.home") + "\\Downloads\\" + imageName;

                                        while (!new File(downloadsFilePath).exists()) {
                                            System.out.println("Thread Sleep: " + 2000);
                                            Thread.sleep(2000);
                                        }
                                        System.out.println("Downloads Path :" + downloadsFilePath);
                                        System.out.println("Current dir path: " + currentDirFilePath);

                                        moveFile(downloadsFilePath, currentDirFilePath);

                                        File f = new File(currentDirFilePath);
                                        InputStream my_banner_image = new FileInputStream(f);
                                        /* Convert picture to be added into a byte array */
                                        byte[] bytes = IOUtils.toByteArray(my_banner_image);
                                        /* Add Picture to Workbook, Specify picture type as PNG and Get an Index */
                                        int my_picture_id = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
                                        /* Close the InputStream. We are ready to attach the image to workbook now */
                                        my_banner_image.close();
                                        /* Create the drawing container */
                                        XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();

                                        /* Create an anchor point */
                                        // ============= Inserting image - END

                                        // ========adding image START
                                        XSSFClientAnchor my_anchor = new XSSFClientAnchor();
                                        //	XSSFClientAnchor my_anchor = new XSSFClientAnchor(5,5,122,46,columnCount,rowCount,0,0);
                                        /* Define top left corner, and we can resize picture suitable from there */

                                        my_anchor.setCol1(columnCount);
                                        my_anchor.setRow1(rowCount);

                                        /* Invoke createPicture and pass the anchor point and ID */
                                        XSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
                                        my_picture.resize(0.04);
                                        // ========adding image END
                                        f.delete();
                                    } catch (FileNotFoundException e) {
                                        System.out.println("Error: " + e.getMessage());
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        System.out.println("Error: " + e.getMessage());
                                        e.printStackTrace();
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Exception e) {
                                WebElement tdData = listOfRows.get(i).findElements(By.tagName("td")).get(j - 1);
                                text = (tdData != null) ? tdData.getText() : "";
                                cell.setCellValue(text);
                                cell.setCellStyle(styleForTd);
                            }

                        }
                    }
                    columnCount++;
                }
                rowCount++;
            }

            n++;
        }
        try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/TestData/Events.xlsx")) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    catch(Exception e)
    {

        System.out.println("Login to conf Failed " +e.getMessage());
    }

}

        private static void moveFile(String src, String dest) {
            Path result = null;
            try {
                System.out.println("Src: " + src+"\n Exist: "+new File(src).exists());
                System.out.println("dest: " + dest+"\n Exist: "+new File(dest).exists());
                if(new File(dest).exists()) {
                    new File(dest).delete();
                }
                result = java.nio.file.Files.move(Paths.get(src), Paths.get(dest));
            } catch (IOException e) {
                System.out.println("Exception while moving file: " + e.getMessage());
            }
            if (result != null) {
                System.out.println("File moved successfully.");
            } else {
                System.out.println("File movement failed.");
            }
        }

    }


