package webdriver.hurtmeplentyandhardcore.pages.googlecloudsite;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.AbstractPage;


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

    @FindBy (id = "select_value_label_60")
    private WebElement commitedUsageTerminField;

    @FindBy (xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    private WebElement submitButton;

    @FindBy(id = "compute")
    private WebElement calculatedResultsBlock;

    private WebDriverWait wait;

    public GoogleCloudCalculatorPagePF(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(inputFrame);
        this.wait = new WebDriverWait(driver, 4);
    }

    public GoogleCloudCalculatorPagePF setMachineType(String typeValue) {
        machineTypeField.click();
        WebElement desiredMachineTypeOption = driver.findElement(getOptionSelector(typeValue));
        wait.until(ExpectedConditions.elementToBeClickable(desiredMachineTypeOption));

        desiredMachineTypeOption.click();
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


        numberOfGPUsField.click();
        WebElement numberOfGPUsMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(numberOfGPUsMenu));
        new Actions(driver).sendKeys(Integer.toString(gpuAmount))
                .sendKeys(Keys.ENTER).perform();

        gpuTypeField.click();
        driver.switchTo().activeElement();//

        //FIX
        By xpathForGpuType = getOptionSelector(typeValue);
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
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterLocationField));
        return this;
    }

    public GoogleCloudCalculatorPagePF setDataCenterLocation(String locationValue) {
        dataCenterLocationField.click();
        WebElement locationsMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(locationsMenu));

        List <WebElement> matchedResults = driver.findElements(getOptionSelector(locationValue));
        //FIX IT
        for (WebElement match: matchedResults) {
            if (match.getText().contains("(")) {
                match.click();
                break;
            }
        }

        wait.until(ExpectedConditions.invisibilityOf(locationsMenu));
        return this;
    }

    public GoogleCloudCalculatorPagePF setCommitedUsageInYears(int yearsAmount) {
        commitedUsageTerminField.click();
        WebElement usageMenu = driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(usageMenu));

        //FIX IT
        WebElement targetOption = null;
        for (WebElement option : driver.findElements(getOptionSelector(Integer.toString(yearsAmount)))) {
            if (option.getText().toLowerCase().contains("year")) {
                targetOption = option;
            }
        }
        assert targetOption != null;
        targetOption.click();
        wait.until(ExpectedConditions.invisibilityOf(targetOption));

        return this;
    }

    public GoogleCloudCalcucatorResultsPagePF calculateResults() {
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(calculatedResultsBlock));

        return new GoogleCloudCalcucatorResultsPagePF(driver);
    }

    private By getOptionSelector(String value) {
        return By.xpath("//md-option[@value='" + value + "']");
    }

    @Override
    public GoogleCloudCalculatorPagePF openPage() {
        throw new RuntimeException("Learning purposes!");
    }
}
