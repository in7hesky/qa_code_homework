package webdriver.icanwinandbringiton.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.AbstractPage;

import java.util.List;


public class PasteBinHomePagePF extends AbstractPage {

    @FindBy(id = "postform-text")
    private WebElement textArea;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationMenuActivator;

    @FindBy(xpath = expirationListSelector + "/child::li")
    private List<WebElement> expirationOptions;

    @FindBy (id = "select2-postform-format-container")
    private WebElement highlightingMenuActivator;

    @FindBy (css = "#select2-postform-format-results > li:nth-child(3) > ul")
    private List<WebElement> highlightingOptions;

    @FindBy(id = "postform-name")
    private WebElement textNameField;

    @FindBy(css = "button.btn.-big")
    private WebElement submitButton;

    private static final String expirationListSelector = "//ul[@role='listbox']";
    private static final String highlightingListSelector = "//*[@id='select2-postform-format-results']/li[2]/ul";
    private static final String HOMEPAGE_URL = "http://pastebin.com/";


    public PasteBinHomePagePF(WebDriver driver) {
        super(driver);
    }


    public PasteBinHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(textArea));
        return this;
    }

    public PasteBinHomePagePF inputText(String text) {
        textArea.sendKeys(text);
        return this;
    }

    public PasteBinHomePagePF setHighlighting(HighlightingType highlightingType) {
        highlightingMenuActivator.click();
        for (int i = 0; i < highlightingOptions.size(); i++) {
            WebElement option = highlightingOptions.get(i);
            if (option.getText().toLowerCase().contains(highlightingType.toString().toLowerCase())) {
                driver.findElement(By.xpath(highlightingListSelector + "/child::*[" + (i + 1) + "]")).click();
                break;
            }
        }

        return this;
    }

    public PasteBinHomePagePF setExpirationTermin(PasteBinExpirationTermins termin) {
        expirationMenuActivator.click();

        for (int i = 0; i < expirationOptions.size(); i++) {
            WebElement option = expirationOptions.get(i);
            if (option.getText().contains(termin.getTermin())) {
                driver.findElement(By.xpath(expirationListSelector + "/child::*[" + (i + 1) + "]")).click();
                break;
            }
        }

        return this;
    }

    public PasteBinHomePagePF inputTextName(String name) {
        textNameField.click();
        textNameField.sendKeys(name);
        return this;
    }

    public PasteBinPostPagePF submitPost() {
        submitButton.click();
        try {
            wait.until(ExpectedConditions.stalenessOf(textArea));
        } catch (Exception e) {
            return null;
        }
        return new PasteBinPostPagePF(driver);
    }


}
