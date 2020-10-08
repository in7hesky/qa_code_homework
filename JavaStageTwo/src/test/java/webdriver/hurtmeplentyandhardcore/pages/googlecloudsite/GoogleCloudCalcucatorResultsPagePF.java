package webdriver.hurtmeplentyandhardcore.pages.googlecloudsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.AbstractPage;

import java.util.List;
import java.util.Objects;

public class GoogleCloudCalcucatorResultsPagePF extends AbstractPage {

    @FindBy (css = "#compute  md-list > div")
    private WebElement numberOfInstances;

    @FindBy (css = "#compute  md-list")
    private WebElement cartItemsWrapper;



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
