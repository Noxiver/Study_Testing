import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest{
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUP () {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10 , 0);
    }
    @AfterTest
    public void quitBrowser () {
        driver.quit();
    }
    @Test
    public void alertTest () {

        //find and click on submit
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("user");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();

        //wait alert and switch on it
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert =driver.switchTo().alert();

        //parse alert text and compare with first expected alertness
        String expectedAlertness = "Do you really want to delete this Customer?";
        String actualAlertness = alert.getText();
        Assert.assertEquals(actualAlertness, expectedAlertness);
        alert.accept();

        //parse alert text and compare with second expected alertness
        Alert alert2 = driver.switchTo().alert();
        String expectedAlertness2 = "Customer Successfully Delete!";
        String actualAlertness2 = alert2.getText();
        Assert.assertEquals(actualAlertness2, expectedAlertness2);
        alert2.accept();
    }
}
