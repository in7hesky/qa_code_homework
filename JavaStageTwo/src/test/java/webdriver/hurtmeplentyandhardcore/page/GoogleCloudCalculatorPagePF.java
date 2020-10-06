package webdriver.hurtmeplentyandhardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.AbstractPage;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class GoogleCloudCalculatorPagePF extends AbstractPage {

    @FindBy (id = "myFrame")
    private WebElement inputFrame;

    @FindBy (id = "input_61")
    private WebElement numberOfInstancesField;

    @FindBy (id = "select_value_label_58")
    private WebElement machineTypeField;

    @FindBy (tagName = "md-checkbox")
    private WebElement addGPUCheckbox;

    @FindBy (id = "select_value_label_371")
    private WebElement numberOfGPUsField;

    @FindBy (id = "select_value_label_372")
    private WebElement gpuTypeField;

    @FindBy (id = "select_value_label_193")
    private WebElement ssdAmountField;

    @FindBy (id = "select_value_label_59")
    private WebElement dataCenterLocationField;

    private WebDriverWait wait;

    public GoogleCloudCalculatorPagePF(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(inputFrame);
        this.wait = new WebDriverWait(driver, 4);
    }

    public GoogleCloudCalculatorPagePF setMachineType(String typeValue) {
        machineTypeField.click();
        WebElement desiredMachineTypeOption = driver.findElement(By.xpath("//md-option[@value='" + typeValue + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(desiredMachineTypeOption));
        scrollTo(desiredMachineTypeOption).click();
        wait.until(ExpectedConditions.invisibilityOf(desiredMachineTypeOption));
        return this;
    }

    public GoogleCloudCalculatorPagePF setNumberOfInstances(int numberOfInstances) {
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys(Integer.toString(numberOfInstances));
        return this;
    }

    public GoogleCloudCalculatorPagePF addGPU(int gpuAmount, String typeValue) {
        addGPUCheckbox.click();

        scrollTo(numberOfGPUsField).click();
        WebElement numberOfGPUsMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(numberOfGPUsMenu));
        new Actions(driver).sendKeys(Integer.toString(gpuAmount))
                .sendKeys(Keys.ENTER).perform();

        gpuTypeField.click();
        driver.switchTo().activeElement();

        By xpathForGpuType = By.xpath("//md-option[@value='" + typeValue+ "']");
        wait.until(ExpectedConditions.elementToBeClickable(xpathForGpuType));
        driver.findElement(xpathForGpuType).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(xpathForGpuType)));
        return this;
    }

    public GoogleCloudCalculatorPagePF setSSDAmount(int ssdAmount) {
        ssdAmountField.click();
        WebElement ssdAmountMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(ssdAmountMenu));
        new Actions(driver).sendKeys(Integer.toString(ssdAmount))
                .sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.invisibilityOf(ssdAmountMenu));
        return this;
    }

    public GoogleCloudCalculatorPagePF setDataCenterLocation(String locationValue) {
        dataCenterLocationField.click();
        WebElement locationsMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(locationsMenu));

        List <WebElement> matchedResults = driver.findElements(By.xpath("//md-option[@value='" + locationValue + "']"));
        for (WebElement match: matchedResults) {
            if (match.getText().toLowerCase().contains("(")) {
                match.click();
                break;
            }
        }

        wait.until(ExpectedConditions.invisibilityOf(locationsMenu));
        return this;
    }

    private WebElement scrollTo(WebElement webElement) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        return webElement;
    }

    @Override
    public GoogleCloudCalculatorPagePF openPage() {
        throw new RuntimeException("Learning purposes!");
    }
}
