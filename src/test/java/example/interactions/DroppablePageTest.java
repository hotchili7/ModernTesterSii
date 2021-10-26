package example.interactions;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppablePageTest extends BaseTest {
    private DroppablePage droppablePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        droppablePage = new DroppablePage(driver);


    }


    @Test
    public void test() {
        droppablePage.dragElementAndDrop();

        Assert.assertEquals(droppablePage.getTextFromDroppedMessage(), "Dropped!");

    }

}
