package webdriver.hurtmeplentyandhardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.AbstractPage;

public class GoogleCloudHomePagePF extends AbstractPage {

    @FindBy (className = "devsite-search-field")
    private WebElement searchField;
    @FindBy (xpath = "//a[@class='gs-title']/b")
    private WebElement searchResults;

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudHomePagePF(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchResultsPagePF searchFor(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchField.submit();
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        return new GoogleCloudSearchResultsPagePF(this.driver);
    }

    @Override
    public GoogleCloudHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return this;
    }


}
