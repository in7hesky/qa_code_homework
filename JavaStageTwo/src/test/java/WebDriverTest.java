
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class WebDriverTest {
    @Test
    public void firstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://vk.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testWikiPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchInput.sendKeys("Hello World");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button/i"));
        searchBtn.click();
        Thread.sleep(3000);

        driver.quit();
    }
}
