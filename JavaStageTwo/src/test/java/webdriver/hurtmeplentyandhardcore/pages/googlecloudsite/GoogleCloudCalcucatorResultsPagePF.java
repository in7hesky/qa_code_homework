package webdriver.hurtmeplentyandhardcore.pages.googlecloudsite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriver.AbstractPage;

import java.util.Objects;

public class GoogleCloudCalcucatorResultsPagePF extends AbstractPage {
    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement calculatorFrame;

    @FindBy (id = "myFrame")
    private WebElement resultsFrame;

    @FindBy (css = "#compute  md-list > div")
    private WebElement numberOfInstances;

    @FindBy (css = "#compute  md-list")
    private WebElement cartItemsWrapper;

    @FindBy (id = "email_quote")
    private WebElement emailEstimateButton;

    @FindBy (xpath = "//input[@name='description' and @type='email']")
    private WebElement emailInput;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;


    public GoogleCloudCalcucatorResultsPagePF(WebDriver driver) {
        super(driver);
    }

    public int getChosenNumberOfInstances() {
        return Integer.parseInt(numberOfInstances.getText().split(" ")[0]);
    }

    public String getChosenVMClass() {
        return Objects.requireNonNull(getCartItemByText("VM class")).getText().split(":")[1].trim();
    }

    public String getChosenInstanceType() {
        return Objects.requireNonNull(getCartItemByText("Instance type"))
                .getText().split(":")[1].trim();
    }

    public String getChosenRegion() {
        return Objects.requireNonNull(getCartItemByText("Region")).getText().split(":")[1].trim();
    }

    public int getChosenSSDAmount() {
        String[] wordsInTextLine =  getCartItemByText("SSD").getText().split(" ");
        return Integer.parseInt(wordsInTextLine[wordsInTextLine.length - 2].split("x")[0]);
    }

    public int getChosenCommitmentTermInYears() {
        return Integer.parseInt(String.valueOf(Objects.requireNonNull(
                getCartItemByText("Commitment term"))
                .getText().split(":")[1].trim().charAt(0)));
    }

    public String getEstimatedCost() {
        String[] wordsInTextLine = Objects.requireNonNull(
                getCartItemByText("cost")).getText().split(" ");

        return wordsInTextLine[wordsInTextLine.length - 4];
    }

    public void refocusOnResultsFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(calculatorFrame));
        driver.switchTo().frame(resultsFrame);
    }

    public void sendResultsToCopiedEmail() throws InterruptedException {
        refocusOnResultsFrame();

        emailEstimateButton.click();
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(Keys.CONTROL + "v");
        Thread.sleep(5000);
        sendEmailButton.click();


    }

    //FIX IT
    private WebElement getCartItemByText(String innerText) {
        for (WebElement cartItem: cartItemsWrapper.findElements(By.xpath("//*[@id='compute']/md-list/md-list-item"))) {
            if (cartItem.getText().toLowerCase().contains(innerText.toLowerCase())) {
                return cartItem;
            }
        }
        return null;
    }


    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("You shouldn't come here..");
    }


}
