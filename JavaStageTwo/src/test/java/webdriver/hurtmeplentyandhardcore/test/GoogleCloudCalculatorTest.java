package webdriver.hurtmeplentyandhardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.hurtmeplentyandhardcore.pages.googlecloudsite.GoogleCloudCalcucatorResultsPagePF;
import webdriver.hurtmeplentyandhardcore.pages.googlecloudsite.GoogleCloudCalculatorPagePF;
import webdriver.hurtmeplentyandhardcore.pages.googlecloudsite.GoogleCloudHomePagePF;
import webdriver.hurtmeplentyandhardcore.pages.tenminutemail.TenMinuteHomePagePF;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GoogleCloudCalculatorTest {

    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    private int numberOfInstances;
    private int ssdAmount;
    private int gpuAmount;
    private int commitedUsageYears;
    private String gpuTypeValue;
    private String machineTypeValue;
    private String datacenterLocationValue;
    private String expectedCost;

    private String costViaEmail;

    private WebDriver driver;
    private GoogleCloudCalcucatorResultsPagePF calculatorResultsPage;
    {
        initializeArgumentsByFile();
    }

    @BeforeClass(alwaysRun = true)
    public void setupCalculatorPage() throws InterruptedException {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        GoogleCloudCalculatorPagePF googleCloudCalculator = new GoogleCloudHomePagePF(driver)
                .openPage()
                .searchFor(SEARCH_QUERY)
                .getToCloudCalculatorPage();

        this.calculatorResultsPage = inputTestValues(googleCloudCalculator);
        TenMinuteHomePagePF tenMinuteHomePagePF = new TenMinuteHomePagePF(driver).openPage();
        tenMinuteHomePagePF.copyEmailAddress();
        calculatorResultsPage.sendResultsToCopiedEmail();
        costViaEmail = tenMinuteHomePagePF.getReceivedCost();
        calculatorResultsPage.refocusOnResultsFrame();
    }

    @Test
    public void costViaEmailIsCorrect() {
        Assert.assertEquals(costViaEmail.replace(",", ""), expectedCost);
    }

    @Test
    public void chosenNumberOfInstancesIsCorrect() {
        Assert.assertEquals(numberOfInstances, calculatorResultsPage.getChosenNumberOfInstances());
    }

    @Test
    public void chosenVMClassIsCorrect() {
        Assert.assertEquals(calculatorResultsPage.getChosenVMClass().toLowerCase(), "Regular".toLowerCase());
    }

    @Test
    public void chosenInstanceTypeIsCorrect() {
        Assert.assertEquals(calculatorResultsPage.getChosenInstanceType(), "n1-standard-8");
    }

    @Test
    public void chosenRegionIsCorrect() {
        Assert.assertEquals(calculatorResultsPage.getChosenRegion().toLowerCase(), "Frankfurt".toLowerCase());
    }

    @Test
    public void chosenSSDAmountIsCorrect() {
        Assert.assertEquals(calculatorResultsPage.getChosenSSDAmount(), ssdAmount);
    }

    @Test
    public void chosenCommitmentTermInYearsIsCorrect() {
        Assert.assertEquals(calculatorResultsPage.getChosenCommitmentTermInYears(), commitedUsageYears);
    }

    @Test
    public void estimatedCostAsExpected() {
        Assert.assertEquals(calculatorResultsPage.getEstimatedCost().replace(",", ""), expectedCost);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        //driver.quit();
        driver = null;
    }

    private GoogleCloudCalcucatorResultsPagePF inputTestValues(GoogleCloudCalculatorPagePF calculator) {
        return calculator
                .setNumberOfInstances(numberOfInstances)
                .setMachineType(machineTypeValue)
                .addGPU(gpuAmount, gpuTypeValue)
                .setSSDAmount(ssdAmount)
                .setDataCenterLocation(datacenterLocationValue)
                .setCommitedUsageInYears(commitedUsageYears)
                .calculateResults();
    }

    private void initializeArgumentsByFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/test/java/webdriver/hurtmeplentyandhardcore/test/inputData.csv"))) {
            String[] testValues = reader.readLine().split(",");
            numberOfInstances = Integer.parseInt(testValues[0]);
            ssdAmount = Integer.parseInt(testValues[1]);
            gpuAmount = Integer.parseInt(testValues[2]);
            commitedUsageYears = Integer.parseInt(testValues[3]);
            gpuTypeValue = testValues[4];
            machineTypeValue = testValues[5];
            datacenterLocationValue = testValues[6];
            expectedCost = testValues[7];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }
}

