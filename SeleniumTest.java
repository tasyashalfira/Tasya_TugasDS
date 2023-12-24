package automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SeleniumTest {
    WebDriver driver;

    @Test
    public void loginTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://www.yopmail.com/";
        driver.get(url);

        WebElement searchBar = driver.findElement(By.id("login"));
        searchBar.sendKeys("automationtest");
        WebElement checkInboxButton = driver.findElement(By.cssSelector("button.md"));
        checkInboxButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame("ifinbox");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.id("ifmail"));
        driver.switchTo().frame(iframeElement);
        WebElement emailContent = driver.findElement(By.id("mail"));
        String content = emailContent.getText();
        
        // printout the content of email
        System.out.println("The Email Content:\n" + content);

        driver.quit();
    }
}