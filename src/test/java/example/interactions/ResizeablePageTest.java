package example.interactions;

import example.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResizeablePageTest extends BaseTest {
    private ResizeablePage resizeablePage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        resizeablePage = new ResizeablePage(driver);
    }


    @Test
    public void test() {
        resizeablePage.resizeElementBy(50, 50);

    }

    @Test
    public void test1() {
        System.out.println("początkowe x: " + resizeablePage.getCoordX());
        System.out.println("początkowe y: " + resizeablePage.getCoordY());

        resizeablePage.resizeElementBy(18, 18);

        System.out.println("końcowe x: " + resizeablePage.getCoordX());
        System.out.println("pkońcowe y: " + resizeablePage.getCoordY());


    }

}
