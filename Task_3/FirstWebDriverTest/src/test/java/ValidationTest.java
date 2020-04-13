import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationTest  {
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
    public void validationTest () {
        //find fields: username, password, body
        driver.get("http://demo.guru99.com/V1/index.php");
        WebElement username = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        WebElement pass = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
        WebElement body = driver.findElement(By.cssSelector("body"));
        //click on this fields and miss click on empty field of page for get Validation message
        username.click();
        pass.click();
        body.click();
        //wait validation message and compare it with expected result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message23\"]")));
        WebElement passValidation =  driver.findElement(By.xpath("//*[@id=\"message23\"]"));
        String actualpassValidation = passValidation.getText();
        String expectedpassValidation = "User-ID must not be blank";
        Assert.assertEquals(actualpassValidation, expectedpassValidation);
        //check that the validation message has disappeared
        username.sendKeys("a");
        pass.sendKeys("a");
        Assert.assertEquals(actualpassValidation, expectedpassValidation);
        System.out.println("Test passed");
    }
}
