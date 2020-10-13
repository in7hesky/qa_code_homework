package webdriver.hurtmeplentyandhardcore.pages.googlecloudsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.AbstractPage;

import java.util.List;

public class GoogleCloudSearchResultsPagePF extends AbstractPage {

    @FindBy (xpath = "//a[@class='gs-title']/b")
    private List<WebElement> searchResults;

    @FindBy (className = "gsc-expansionArea")
    private WebElement searchResultsWrapper;

    public GoogleCloudSearchResultsPagePF(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(searchResultsWrapper));
    }

    public GoogleCloudCalculatorPagePF getToCloudCalculatorPage() {
        searchResults.get(0).click();


        return new GoogleCloudCalculatorPagePF(this.driver);
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Learning purposes!");
    }
}
