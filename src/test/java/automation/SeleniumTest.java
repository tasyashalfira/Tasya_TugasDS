package automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;
    public static void main(String[] args) {
        // Set path driver sesuai lokasi driver Chrome di komputer Anda
        WebDriverManager.chromedriver().setup();
        // Inisialisasi WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    
            // 1. Buka makemytrip.com
            driver.get("https://www.makemytrip.com/");

            // Tunggu beberapa detik untuk memastikan halaman telah sepenuhnya dimuat
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Cari dan klik tombol "Search"
            WebElement searchButton = driver.findElement(By.xpath("//a[text()='Search']"));
            searchButton.click();

            // Tunggu beberapa detik untuk memastikan hasil pencarian ditampilkan
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // 2. Ekstrak nilai harga tertinggi
            List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='blackFont' and text()!='']"));
            if (!priceElements.isEmpty()) {
                WebElement topPriceElement = priceElements.get(0);
                String topPrice = topPriceElement.getText();
                System.out.println("Top Price: " + topPrice);
            } else {
                System.out.println("No price information found.");
            }

            WebElement topPriceElement = driver.findElement(By.cssSelector("div.blackText.fontSize18.blackFont.white-space-no-wrap.clusterViewPrice']"));
            String topPrice = topPriceElement.getText();

            System.out.println("Top Price: " + topPrice);
            // Tutup browser setelah selesai
            driver.quit();
            
    }
}
