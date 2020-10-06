package webdriver.hurtmeplentyandhardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.AbstractPage;

import java.util.List;

public class GoogleCloudSearchResultsPagePF extends AbstractPage {

    @FindBy (xpath = "//a[@class='gs-title']/b")
    private List<WebElement> searchResults;
    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement calculatorFrame;

    private final static int WAIT_FOR_FRAME = 12;

    public GoogleCloudSearchResultsPagePF(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPagePF getToCloudCalculatorPage() {
        searchResults.get(0).click();

        new WebDriverWait(driver, WAIT_FOR_FRAME)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
        return new GoogleCloudCalculatorPagePF(this.driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Learning purposes!");
    }
}
