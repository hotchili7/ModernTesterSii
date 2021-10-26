package example.widgets;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabsPageTest extends BaseTest {

    public TabsPage tabsPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/tabs.php");
        tabsPage = new TabsPage(driver);
    }


    @Test
    public void test() {
        tabsPage.switchToTab("Tab 2");
    }


    @Test
    public void test1() {
        System.out.println(tabsPage.getTextFromTab("Tab 1"));
        System.out.println(tabsPage.getTextFromParagraphs());
    }
}
