package example.widgets;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;

public class SpinnerPageTest extends BaseTest {

    public SpinnerPage spinnerPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php#");
        spinnerPage = new SpinnerPage(driver);
    }



}
