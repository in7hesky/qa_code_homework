package webdriver.hurtmeplentyandhardcore.pages.tenminutemail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import webdriver.AbstractPage;

import java.util.List;

public class TenMinuteHomePagePF extends AbstractPage {

    private List<String> tabs;

    public TenMinuteHomePagePF(WebDriver driver) {
        super(driver);
    }

    @Override
    public TenMinuteHomePagePF openPage() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        ((JavascriptExecutor)driver).executeScript("window.open('https://10minutemail.com/','_blank');");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
