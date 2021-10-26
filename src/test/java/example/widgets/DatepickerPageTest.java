package example.widgets;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatepickerPageTest extends BaseTest {

    private DatepickerPage datepickerPage;

    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        datepickerPage = new DatepickerPage(driver);

    }


    @Test
    public void shouldInputDate() {
        // datepickerPage.inputDate("01/01/2010");
        // System.out.println(datepickerPage.getSelectedDate());
        System.out.println(datepickerPage.getCurrentDate());
    }

    @Test
    public void test() {

//        System.out.println(datepickerPage.getIntegerFromNameOfMonth("January"));
        datepickerPage.selectDate(12,10,2023);
    }

    @Test
    public void test1() {
        int expectedDay = 27;
        int expectedMonth = 5;
        int expectedYear = 2024;

        datepickerPage.selectDate(expectedDay, expectedMonth, expectedYear);

        Assert.assertEquals(datepickerPage.getNumericValueFromDatepickerInput()[1], expectedDay);
        Assert.assertEquals(datepickerPage.getNumericValueFromDatepickerInput()[0], expectedMonth);
        Assert.assertEquals(datepickerPage.getNumericValueFromDatepickerInput()[2], expectedYear);
    }






}
