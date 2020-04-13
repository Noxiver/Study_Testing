import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownloadFile {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUP () {
        System.setProperty("webdriver.chrome.driver", "src/resources/operadriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10 , 0);
    }
    @AfterTest
    public void quitBrowser () {
        driver.quit();
    }
    @Test
    public void uploadFile() {
        //open site and parse link for download
        driver.get("http://demo.guru99.com/test/yahoo.html");
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String link = downloadButton.getAttribute("href");
        //prepare message for wget
        String wgetCommand = "wget -P E:/TestDownload --no-check-certificate "+ link;
        System.out.println(wgetCommand);
        //run cmd and write command for downloading with wget! Also start try catch block for catch IOException
        try {
            Process cmd = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = cmd.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }


}
