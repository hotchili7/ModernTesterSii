package example.interactions;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectablePageTest extends BaseTest {

    private SelectablePage selectablePage;
    private List<String> numbers = Arrays.asList("1", "2", "3");

    @BeforeMethod
   public void before() {
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        selectablePage = new SelectablePage(driver);
    }

    @Test
    public void shouldSelectRowByNumber() {
        selectablePage.selectRowByNumber("4");
        Assert.assertEquals(selectablePage.getTextFromResult(), "4");

    }

    @Test
    public void shouldSelectRowByNumbers() {
        selectablePage.selectMultiple(numbers);
//        System.out.println(selectablePage.getTextFromResult());
//        System.out.println(selectablePage.getNumbersFromString(selectablePage.getTextFromResult()));
        Assert.assertEquals(selectablePage.getNumbersFromString(selectablePage.getTextFromResult()), numbers);
    }


}
