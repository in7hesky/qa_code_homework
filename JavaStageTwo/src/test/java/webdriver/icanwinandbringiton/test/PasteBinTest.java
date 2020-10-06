package webdriver.icanwinandbringiton.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webdriver.icanwinandbringiton.page.PasteBinExpirationTermins;
import webdriver.icanwinandbringiton.page.PasteBinHomePagePF;

public class PasteBinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void canPostMessage() {
        PasteBinHomePagePF pasteBinHomePagePF = new PasteBinHomePagePF(this.driver).openPage();
        pasteBinHomePagePF
                .inputText("Hello from Webdriver")
                .setExpirationTermin(PasteBinExpirationTermins.MINUTES_10)
                .inputTextName("helloweb");
        Assert.assertNotNull(pasteBinHomePagePF.submitPost(), "The submission has been rejected!");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
