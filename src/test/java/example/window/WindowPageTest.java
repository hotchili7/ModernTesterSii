package example.window;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowPageTest extends BaseTest {

    private WindowPage windowpage;


    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        windowpage = new WindowPage(driver);
    }


    @Test
    public void shouldOpenNewWindow() {
        windowpage.switchToNewWindow();
    }

    @Test
    public void shouldOpenNewMessageWindowAndGEtText() {
        System.out.println(windowpage.switchToNewMessageWindow());
    }


    @Test
    public void shouldSwitchToTab() {
        windowpage.clickNewBrowserAndSwitchToNewTab();
    }
}
