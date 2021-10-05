package demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Petswaggerui {

    @Then("I expand and collapse the pet arrows for endpoints")
    public void iExpandAndCollapseThePetArrowsForEndpoints() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\DemoRA\\src\\main\\driversss\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.swagger.io/");
        String jsCode1 = "window.scrollBy(0, document.body.scrollHeight)";
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript(jsCode1);
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[2]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[2]")).click();
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[5]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[5]")).click();
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[10]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[10]")).click();
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[15]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("(//*[name()='svg' and@class='arrow'])[15]")).click();
        driver.close();
    }
}