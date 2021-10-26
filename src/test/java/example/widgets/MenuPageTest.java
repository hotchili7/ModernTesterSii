package example.widgets;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class MenuPageTest extends BaseTest {
    public MenuPage menuPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/menu-item.php");
        menuPage = new MenuPage(driver);


    }


    @Test
    public void shouldConfirmThatNumberOfActiveCategoriesIs5Test() {
        System.out.println(menuPage.getActiveCategories());
                Assert.assertEquals(menuPage.getActiveCategories().size(), 5);
    }

    @Test
    public void shouldConfirmThatNumberOfAllCategoriesIs7Test() {
        System.out.println(menuPage.getAllCAtegories());
        Assert.assertEquals(menuPage.getAllCAtegories().size(), 7);
    }

    @Test
    public void test() {
        List<String> names = menuPage.openCategoryDropdown("Music")
                .getSubcategoryNames("Music");

        System.out.println(names);
    }
}
