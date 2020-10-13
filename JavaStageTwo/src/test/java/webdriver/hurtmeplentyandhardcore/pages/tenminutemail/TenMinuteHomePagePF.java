package webdriver.hurtmeplentyandhardcore.pages.tenminutemail;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.AbstractPage;


import java.util.ArrayList;
import java.util.List;

public class TenMinuteHomePagePF extends AbstractPage {
    @FindBy (id = "copy-button")
    private WebElement copyAddressButton;

    @FindBy (xpath = "//td[contains(text(),'Cloud')]")
    private WebElement viewLink;

    @FindBy (xpath = "(//table//h3)[2]")
    private WebElement costCell;

    private static final String HOMEPAGE_URL = "https://10minutemail.net/";

    private String oldTab;
    private String thisTab;

    public TenMinuteHomePagePF(WebDriver driver) {
        super(driver);
    }

    public void copyEmailAddress() {
        copyAddressButton.click();
        driver.switchTo().window(oldTab);
    }

    public String getReceivedCost() {
        driver.switchTo().window(thisTab);
        new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOf(viewLink));
        viewLink.click();
        wait.until(ExpectedConditions.visibilityOf(costCell));
        String cost = costCell.getText().split(" ")[1];
        driver.switchTo().window(oldTab);
        return cost;
    }

    @Override
    public TenMinuteHomePagePF openPage() {
        oldTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open('" + HOMEPAGE_URL + "','_blank');");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(oldTab);
        thisTab = tabs.get(0);
        driver.switchTo().window(thisTab);
        wait.until(ExpectedConditions.visibilityOf(copyAddressButton));
        return this;
    }
}
