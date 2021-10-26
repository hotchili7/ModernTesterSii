package example.interactions;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortablePageTest extends BaseTest {

    private SortablePage sortablePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/sortable.php");
        sortablePage = new SortablePage(driver);
    }


    @Test
    public void shouldClickOnElementOnIndexTest() {
        sortablePage.clickOnElementOnIndexAndMove("5", "2");
    }
}
