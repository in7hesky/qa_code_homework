package webdriver.hurtmeplentyandhardcore.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.hurtmeplentyandhardcore.page.GoogleCloudCalculatorPagePF;
import webdriver.hurtmeplentyandhardcore.page.GoogleCloudHomePagePF;


public class GoogleCloudCalculatorTest {

    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    private static final int NUMBER_OF_INSTANCES = 4;
    private static final int SSD_AMOUNT = 2;
    private static final int GPU_AMOUNT = 1;
    private static final String GPU_TYPE_VALUE = "NVIDIA_TESLA_V100";
    private static final String MACHINE_TYPE_VALUE = "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8";
    private static final String DATACENTER_LOCATION_VALUE = "europe-west3";

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupCalculatorPage() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        GoogleCloudCalculatorPagePF googleCloudCalculator = new GoogleCloudHomePagePF(driver)
                .openPage()
                .searchFor(SEARCH_QUERY).getToCloudCalculatorPage();

        googleCloudCalculator
                .setNumberOfInstances(NUMBER_OF_INSTANCES)
                .setMachineType(MACHINE_TYPE_VALUE)
                .addGPU(GPU_AMOUNT, GPU_TYPE_VALUE)
                .setSSDAmount(SSD_AMOUNT)
                .setDataCenterLocation(DATACENTER_LOCATION_VALUE);
    }

    @Test
    public void test() throws InterruptedException {

    }


    @AfterClass(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
        driver = null;
    }
}

