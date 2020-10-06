package webdriver.icanwinandbringiton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.icanwinandbringiton.page.HighlightingType;
import webdriver.icanwinandbringiton.page.PasteBinExpirationTermins;
import webdriver.icanwinandbringiton.page.PasteBinHomePagePF;
import webdriver.icanwinandbringiton.page.PasteBinPostPagePF;

public class PasteBinHighlightedTest {
    private static final String CODE_SNIPPET =
                    "git config --global user.name  \"New Sheriff in Town\"\n" +
                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                    "git push origin master --force";

    private static final String HIGHLIGHTED_TITLE = "how to gain dominance among developers";
    private PasteBinPostPagePF pasteBinPostPagePF;

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupContent() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        PasteBinHomePagePF pasteBinHomePagePF = new PasteBinHomePagePF(this.driver).openPage();
        pasteBinHomePagePF
                .inputText(CODE_SNIPPET)
                .setHighlighting(HighlightingType.BASH)
                .setExpirationTermin(PasteBinExpirationTermins.MINUTES_10)
                .inputTextName(HIGHLIGHTED_TITLE);

        pasteBinPostPagePF = pasteBinHomePagePF.submitPost();
    }


    @Test
    public void correctFormattingIsApplied() {
        Assert.assertTrue(pasteBinPostPagePF.getHighlightFormatting().toLowerCase()
                .contains(HighlightingType.BASH.toString().toLowerCase()));
    }

    @Test
    public void savedTextIsCorrect() {
        Assert.assertEquals(CODE_SNIPPET, pasteBinPostPagePF.getSavedText());
    }

    @Test
    public void postTitleIsCorrect() {
        Assert.assertEquals(HIGHLIGHTED_TITLE, pasteBinPostPagePF.getPostTitle());
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
