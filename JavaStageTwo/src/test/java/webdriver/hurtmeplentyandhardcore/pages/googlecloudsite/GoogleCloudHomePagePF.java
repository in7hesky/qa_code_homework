package webdriver.hurtmeplentyandhardcore.pages.googlecloudsite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.AbstractPage;

public class GoogleCloudHomePagePF extends AbstractPage {

    @FindBy (className = "devsite-search-field")
    private WebElement searchField;

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudHomePagePF(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchResultsPagePF searchFor(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchField.submit();
        return new GoogleCloudSearchResultsPagePF(driver);
    }

    @Override
    public GoogleCloudHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return this;
    }


}
