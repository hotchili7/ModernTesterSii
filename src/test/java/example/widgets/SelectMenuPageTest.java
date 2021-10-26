package example.widgets;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuPageTest extends BaseTest {

    public SelectMenuPage selectMenuPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php#");
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test
    public void test() {
        System.out.println(selectMenuPage.getNamesOfSpeeds());
        System.out.println(selectMenuPage.getNamesOfFiles());
        System.out.println(selectMenuPage.getNamesOfNumber());
        System.out.println(selectMenuPage.getNamesOfTitles());
    }

    @Test
    public void test1() {
        selectMenuPage.selectOptionSpeed("Fast");
    }
}
