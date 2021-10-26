package example.interactions;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DraggablePageTest extends BaseTest {
    private DraggablePage draggablePage;

    @BeforeMethod
    public void before(){
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        draggablePage = new DraggablePage(driver);
    }


    @Test
    public void shouldMoveElement(){
        draggablePage.moveElement(250, 250);

    }

}
