package webdriver.icanwinandbringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.AbstractPage;

public class PasteBinPostPagePF extends AbstractPage {

    @FindBy (tagName = "h1")
    private WebElement postTitle;
    @FindBy (className = "textarea")
    private WebElement savedText;
    @FindBy (css = ".left > a")
    private WebElement highlightFormatting;


    public PasteBinPostPagePF (WebDriver driver) {
        super(driver);
    }

    public String getPostTitle() {
        return postTitle.getText();
    }

    public String getSavedText() {
        return savedText.getText();
    }

    public String getHighlightFormatting () {
        return highlightFormatting.getAttribute("href");

    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("You shall not pass!");
    }


}
