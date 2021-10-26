package example.widgets;

import example.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends BaseTest {

    public ProgressbarPage progressbarPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        progressbarPage = new ProgressbarPage(driver);

    }


    @Test
    public void test() {
        progressbarPage.verifyThatProgressBarIsCompleted();
    }



}
